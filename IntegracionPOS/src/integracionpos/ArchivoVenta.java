/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracionpos;

import entidadespos.Venta;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author asus
 */
public class ArchivoVenta {
     @XmlElement(name = "venta")
     private Venta venta;

    public ArchivoVenta() {
    }

    public ArchivoVenta(Venta venta) {
        this.venta = venta;
    }

    public Venta getVenta() {
        return venta;
    }
     
}
