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
public class Promocion extends Producto{
    
    private float descuento;

    public Promocion(float descuento,int codigo, float precioBase, float impuesto, int existencia, String nombre) {
        super(codigo,precioBase,impuesto,existencia,nombre);
        this.descuento=descuento;
    }
    
    @Override
    public float calcularPrecioVenta() {
        
       return ((super.getPrecioBase()*this.getDescuento())-super.getPrecioBase());
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public Promocion() {
    }
    
    
}
