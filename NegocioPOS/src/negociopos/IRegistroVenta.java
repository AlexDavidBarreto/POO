/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negociopos;

import entidadespos.DTOItem;
import entidadespos.DTOTotales;
import entidadespos.Item;
import entidadespos.Producto;
import entidadespos.Venta;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Sebastian
 */
public interface IRegistroVenta {
    public DTOItem agregarItem(Producto producto, int cantidad);
    public DTOTotales terminarVenta();
    public List<Producto> consultarProductos();
    public boolean eliminarItem(Producto producto);
    public Venta crearVenta();
    public DTOTotales CalcularTotalVenta();
   
}
