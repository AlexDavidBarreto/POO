/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadespos;

/**
 *
 * @author Sebastian
 */
public class DTOItem {
    private Item item= new Item();
    private double subtotal;
    private double descuento;
    private double recargo;
    private double indicador = 0;
    private DTOTotales totales = new DTOTotales();
    private String nombre;
    private int cantidad;
    private float precioBase;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }
    

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public double getIndicador() {
        return indicador;
    }

    public void setIndicador(double indicador) {
        this.indicador = indicador;
    }

    public DTOTotales getTotales() {
        return totales;
    }

    public void setTotales(DTOTotales totales) {
        this.totales = totales;
    }



    public DTOItem(Item item, double subtotal) {
        this.setItem(item);
        this.subtotal = subtotal;
    }

    public DTOItem() {
    }
    
}
