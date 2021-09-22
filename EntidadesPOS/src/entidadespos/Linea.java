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
public class Linea extends Producto{

    private float recargo;
    
    @Override
    public float calcularPrecioVenta() {
        
        return ((super.getPrecioBase()*this.getRecargo())+super.getPrecioBase());
    }

    public float getRecargo() {
        return recargo;
    }

    public void setRecargo(float recargo) {
        this.recargo = recargo;
    }

    public Linea(float recargo,int codigo, float precioBase, float impuesto, int existencia, String nombre) {
        super(codigo,precioBase,impuesto,existencia,nombre);
        this.recargo = recargo;
        
    }

    public Linea() {
    }
    
    

    
    
}
