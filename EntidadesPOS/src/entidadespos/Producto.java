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
public abstract class Producto {
    private int codigo;
    private float precioBase;
    private float impuesto;
    private int existencia;
    private String nombre;
    public abstract float calcularPrecioVenta();

    public Producto() {
    }
    public Producto(int codigo, float precioBase, float impuesto, int existencia, String nombre) {
        this.codigo = codigo;
        this.precioBase = precioBase;
        this.impuesto = impuesto;
        this.existencia = existencia;
        this.nombre= nombre;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Metodo para mostrar los nombres en el ComboBox 
    @Override
    public String toString() {
        return nombre;
    }
}
