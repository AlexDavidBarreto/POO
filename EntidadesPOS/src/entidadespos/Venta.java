/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadespos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class Venta {
     private List<Item> lineas = new ArrayList<>();
    private Date fecha=new Date();

    public Venta(Date fecha) {
        this.fecha = fecha;
    }

    public Venta() {
    }


    public List<Item> getLineas() {
        return lineas;
    }

    public void setLineas(List<Item> lineas) {
        this.lineas = lineas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
