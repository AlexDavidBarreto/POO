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
public class DTOTotales {
    private double subtotalSinIva;
    private double iva;
    private double totalVenta;

    public double getSubtotalSinIva() {
        return subtotalSinIva;
    }

    public void setSubtotalSinIva(double subtotalSinIva) {
        this.subtotalSinIva = subtotalSinIva;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public DTOTotales() {
    }
    
}
