/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracionpos;

import entidadespos.Linea;
import entidadespos.Producto;
import entidadespos.Promocion;
import entidadespos.Venta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXB;

/**
 *
 * @author Sebastian
 */
public class GestionarAccesoDatos implements IGestionarAccesoDatos {

    private List<Producto> productos = new ArrayList<>();
    private String FILE_NAME_LINEASXML = "C:\\Users\\Alex\\Desktop\\Entrega final - Copy\\LINEAS.xml";
    private String FILE_NAME_PROMOCIONESXML = "C:\\Users\\Alex\\Desktop\\Entrega final - Copy\\PROMOCIONES.xml";
    private String FILE_NAME_VENTAXML = "C:\\Users\\Alex\\Desktop\\Entrega final - Copy\\VENTA.xml";

    
    public List<Producto> getProductos() {
        return productos;
    }

    public GestionarAccesoDatos() {

    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getFILE_NAME_LINEASXML() {
        return FILE_NAME_LINEASXML;
    }

    public void setFILE_NAME_LINEASXML(String FILE_NAME_LINEASXML) {
        this.FILE_NAME_LINEASXML = FILE_NAME_LINEASXML;
    }

    public String getFILE_NAME_PROMOCIONESXML() {
        return FILE_NAME_PROMOCIONESXML;
    }

    public void setFILE_NAME_PROMOCIONESXML(String FILE_NAME_PROMOCIONESXML) {
        this.FILE_NAME_PROMOCIONESXML = FILE_NAME_PROMOCIONESXML;
    }

    public String getFILE_NAME_VENTAXML() {
        return FILE_NAME_VENTAXML;
    }

    public void setFILE_NAME_VENTAXML(String FILE_NAME_VENTAXML) {
        this.FILE_NAME_VENTAXML = FILE_NAME_VENTAXML;
    }

    //METODO CREADO PARA GENERAR ARCHIVO XML BASE
    public boolean persistirProductos() {
        List<Linea> listaL = new ArrayList<>();
        List<Promocion> listaP = new ArrayList<>();
        for (Producto producto : this.productos) {
            if (producto instanceof Linea) {
                listaL.add((Linea) producto);
            } else {
                listaP.add((Promocion) producto);
            }

        }
        if (persistirPromociones(listaP) && persistirLineas(listaL)) {
            return true;
        }
        return false;
    }

    public boolean persistirProductos(List<Producto> catalogo) {
        List<Linea> listaL = new ArrayList<>();
        List<Promocion> listaP = new ArrayList<>();
        for (Producto producto : catalogo) {
            if (producto instanceof Linea) {
                listaL.add((Linea) producto);
            } else {
                listaP.add((Promocion) producto);
            }

        }
        if (persistirPromociones(listaP) && persistirLineas(listaL)) {
            return true;
        }
        return false;
    }

    public boolean persistirLineas(List<Linea> listaL) {
        ArchivoLinea lista = new ArchivoLinea(listaL);
        try (BufferedWriter output = Files.newBufferedWriter(Paths.get(FILE_NAME_LINEASXML))) {
            JAXB.marshal(lista, output);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

    }
    //METODO CREADO PARA GENERAR ARCHIVO XML BASE

    public boolean persistirPromociones(List<Promocion> listaP) {
        ArchivoPromocion lista = new ArchivoPromocion(listaP);
        try (BufferedWriter output = Files.newBufferedWriter(Paths.get(FILE_NAME_PROMOCIONESXML))) {
            JAXB.marshal(lista, output);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Producto> consultarProductos() {
        try (BufferedReader input = Files.newBufferedReader(Paths.get(FILE_NAME_LINEASXML))) {
            ArchivoLinea listaL = new ArchivoLinea();
            listaL = JAXB.unmarshal(input, ArchivoLinea.class);
            //this.productos = lista.getListaL();
            for (Linea not : listaL.getListaL()) {
                this.productos.add(not);
            }

        } catch (IOException ioe) {
            System.out.println("No se puede leer archivo Lineas ");
            return null;
        }

        try (BufferedReader input2 = Files.newBufferedReader(Paths.get(FILE_NAME_PROMOCIONESXML))) {
            ArchivoPromocion listaP = new ArchivoPromocion();
            listaP = JAXB.unmarshal(input2, ArchivoPromocion.class);
            //this.productos = lista.getListaL();
            for (Promocion not : listaP.getListaP()) {
                this.productos.add(not);
            }
            return this.productos;
        } catch (IOException ioe) {
            System.out.println("No se puede leer archivo Promociones ");
            return null;
        }
    }

    @Override
    public boolean persist(Venta venta, List<Producto> catalogo) {
        if (this.persistirProductos(catalogo)) {
            ArchivoVenta arVenta = new ArchivoVenta(venta);
            try (BufferedWriter output = Files.newBufferedWriter(Paths.get(FILE_NAME_VENTAXML))) {
                JAXB.marshal(arVenta, output);
                return true;
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return false;
            }
        }
        else{
            System.out.println("Error al persistir los cambios");
            return false;
        }
    }

}
