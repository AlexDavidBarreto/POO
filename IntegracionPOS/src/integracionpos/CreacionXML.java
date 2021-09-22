/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracionpos;


import entidadespos.Linea;
import entidadespos.Producto;
import entidadespos.Promocion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class CreacionXML {

    //Clase provisional para crear archivo XML base
    public static void main(String[] args) {
        // TODO code application logic here

        //CREACION DE ARCHIVO XML
        List<Producto> productos = new ArrayList<>();
        productos.add(new Linea(5, 1, 100, 19, 10, "Airpods"));
        productos.add(new Linea(5, 2, 200, 38, 10, "HomePod"));
        productos.add(new Linea(5, 3, 300, 57, 10, "AppleWatch"));
        productos.add(new Linea(5, 4, 400, 76, 10, "Iphone"));
        productos.add(new Promocion(10, 5, 500, 95, 10, "Ipad"));
        productos.add(new Promocion(10, 6, 600, 114, 10, "MacBook"));
        productos.add(new Promocion(10, 7, 700, 133, 10, "MAC"));
 

        GestionarAccesoDatos gestion = new GestionarAccesoDatos();
        gestion.setProductos(productos);
        boolean pudo = gestion.persistirProductos();
        System.out.println("pudo? " + pudo);

    }
}
