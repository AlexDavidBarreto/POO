/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracionpos;

import entidadespos.Producto;
import entidadespos.Venta;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public interface IGestionarAccesoDatos {
    public List<Producto> consultarProductos();
    public boolean persist(Venta venta,List<Producto> catalogo);
}
