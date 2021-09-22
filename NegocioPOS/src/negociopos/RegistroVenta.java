/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negociopos;

import entidadespos.DTOItem;
import entidadespos.DTOTotales;
import entidadespos.Item;
import entidadespos.Linea;
import entidadespos.Producto;
import entidadespos.Promocion;
import entidadespos.Venta;
import integracionpos.GestionarAccesoDatos;
import integracionpos.IGestionarAccesoDatos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class RegistroVenta implements IRegistroVenta {

    private Venta venta;
    private List<Producto> catalogo = new ArrayList<>();

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Producto> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Producto> catalogo) {
        this.catalogo = catalogo;
    }

    public IGestionarAccesoDatos getiAcceso() {
        return iAcceso;
    }

    public void setiAcceso(IGestionarAccesoDatos iAcceso) {
        this.iAcceso = iAcceso;
    }

    private IGestionarAccesoDatos iAcceso = new GestionarAccesoDatos();

    @Override
    public DTOItem agregarItem(Producto producto, int cantidad) {
        boolean flag = true;
        boolean flag2 = false;
        DTOItem dto = new DTOItem();
        dto.setCantidad(cantidad);
        for (Item not : this.venta.getLineas()) {
            //Recorro la lista de items para ver si alguno contiene el producto
            if (not.getProducto().equals(producto)) {
                //Si la cantidad total es menor a las existencias entonces lo acumulo
                if ((not.getCantidad() + cantidad) < producto.getExistencia()) {

                    //Flag para saber si no existe el producto en los items
                    flag = false;
                    flag2 = true;
                    dto.setItem(not);
                    dto.getItem().setProducto(producto);
                    //Se setean los datos que no están directamente en el dto y se adquieren por medio de herencia
                    dto.setCantidad(not.getCantidad() + cantidad);
                    dto.setNombre(not.getProducto().getNombre());
                    dto.setPrecioBase(not.getProducto().getPrecioBase());
                    not.setCantidad(cantidad + not.getCantidad());
                    dto.setSubtotal(dto.getItem().getProducto().calcularPrecioVenta() * cantidad);

                } else {
                    //Indicador para saber si no hay suficientes existencias
                    dto.setIndicador(-1);
                    flag = false;
                }
            }
        }
        //Si el producto no esta, creo un item que lo tenga y hago la validación de las existencias
        Item item = new Item(producto, cantidad);

        if (flag && producto.getExistencia() > cantidad) {

            dto.setItem(item);
            //Se setean los datos que no están directamente en el dto y se adquieren por medio de herencia
            dto.setCantidad(item.getCantidad());
            dto.setNombre(item.getProducto().getNombre());
            dto.setPrecioBase(item.getProducto().getPrecioBase());
            dto.setIndicador(0);
            float a = dto.getItem().getProducto().calcularPrecioVenta();
            dto.setSubtotal(a * cantidad);
            this.venta.getLineas().add(item);

        } else {
            if (!flag2) {
                dto.setIndicador(-1);
            }
        }
        //Valido que hay existencias
        if (dto.getIndicador() != -1) {

            //casteo para guardar en el dto o el descuento o el recargo
            if (producto instanceof Linea) {
                dto.setRecargo(((Linea) producto).getRecargo());
                dto.setDescuento(0);
            } else {
                dto.setDescuento(((Promocion) producto).getDescuento());
                dto.setRecargo(0);
            }
            dto.setTotales(this.CalcularTotalVenta());
            return dto;
        }
        return dto;
    }

    @Override
    public DTOTotales terminarVenta() {

        actualizarArchivo(venta);
        this.venta.getLineas().clear();
        return this.CalcularTotalVenta();
    }

    public void actualizarArchivo(Venta venta) {
        //Recorro primero todos los items de la venta para después actualizar las existencias de el catalogo
        for (Item linea : venta.getLineas()) {
            for (Producto not : this.catalogo) {
                if (linea.getProducto().equals(not)) {
                    not.setExistencia(not.getExistencia() - linea.getCantidad());
                }
            }
        }
        //Metodo que actualiza el archivo y crea la venta
        this.iAcceso.persist(venta, this.catalogo);
    }

    @Override
    public List<Producto> consultarProductos() {
        this.catalogo = this.iAcceso.consultarProductos();
        return catalogo;
    }

    @Override
    public boolean eliminarItem(Producto producto) {

        for (Item p : this.venta.getLineas()) {
            if (p.getProducto().equals(producto)) {
                this.venta.getLineas().remove(p);

                return true;
            }
        }
        return false;
    }

    private void crearVenta(Date fecha) {
        this.venta = new Venta(fecha);
    }

    @Override
    public Venta crearVenta() {
        java.util.Date fecha = new Date();
        this.crearVenta(fecha);
        return this.venta;
    }

    @Override
    public DTOTotales CalcularTotalVenta() {
        DTOTotales totales = new DTOTotales();
        double subTotalSinIva = 0;
        //Recorro todos los items de la venta,calculando el precio de cada uno y multiplicandole la cantidad del mismo
        for (Item not : this.venta.getLineas()) {
            subTotalSinIva += (not.getProducto().calcularPrecioVenta() * not.getCantidad());
        }
        totales.setSubtotalSinIva(subTotalSinIva);
        totales.setIva(subTotalSinIva * 0.19);
        totales.setTotalVenta(totales.getSubtotalSinIva() + totales.getIva());
        //Retorno un DTOTotales con la informacion
        return totales;
    }

}
