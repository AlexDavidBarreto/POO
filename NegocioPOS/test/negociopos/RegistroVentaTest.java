/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negociopos;

import entidadespos.DTOItem;
import entidadespos.DTOTotales;
import entidadespos.Item;
import entidadespos.Linea;
import entidadespos.Producto;
import entidadespos.Promocion;
import entidadespos.Venta;
import integracionpos.IGestionarAccesoDatos;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Sebastian
 */
public class RegistroVentaTest {
    
    public RegistroVentaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of agregarItem method, of class RegistroVenta.
     */
    @Test
    public void testAgregarItem() {
        Venta venta = new Venta();
        List<Item>lista=new ArrayList<>();
        Item it1= new Item();
        Item it2 = new Item();
        
        RegistroVenta reg = new RegistroVenta();
        
        System.out.println("agregarItem");
        Producto producto = new Linea();
        Producto producto2 = new Promocion();
        
        it1.setProducto(producto);
        it1.setCantidad(1);
        it2.setProducto(producto2);
        it2.setCantidad(1);
        lista.add(it1);
        lista.add(it2);
        DTOItem dto;
        dto = new DTOItem();
       
        reg.setVenta(venta);
       reg.getVenta().setLineas(lista);
        dto = reg.agregarItem(producto, 1);
        int cantidad = 0;
        RegistroVenta instance = new RegistroVenta();
        instance.setVenta(venta);
        instance.getVenta().setLineas(lista);
        DTOItem expResult = dto;
        DTOItem result = instance.agregarItem(producto, cantidad);
        System.out.println("DTO: "+result.getNombre()+ "  "+result.getSubtotal());
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of terminarVenta method, of class RegistroVenta.
     */
   /*
    @Test
    public void testTerminarVenta() {
        System.out.println("terminarVenta");
        RegistroVenta instance = new RegistroVenta();
        DTOTotales expResult = null;
        DTOTotales result = instance.terminarVenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarArchivo method, of class RegistroVenta.
     */
    @Ignore
    public void testActualizarArchivo() {
        System.out.println("actualizarArchivo");
        Venta venta = null;
        RegistroVenta instance = new RegistroVenta();
        instance.actualizarArchivo(venta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarProductos method, of class RegistroVenta.
     */
    @Ignore
    public void testConsultarProductos() {
        System.out.println("consultarProductos");
        RegistroVenta instance = new RegistroVenta();
        List<Producto> expResult = null;
        List<Producto> result = instance.consultarProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarItem method, of class RegistroVenta.
     */
    @Ignore
    public void testEliminarItem() {
        System.out.println("eliminarItem");
        Producto producto = null;
        RegistroVenta instance = new RegistroVenta();
        boolean expResult = false;
        boolean result = instance.eliminarItem(producto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearVenta method, of class RegistroVenta.
     */
    @Ignore
    public void testCrearVenta() {
        System.out.println("crearVenta");
        RegistroVenta instance = new RegistroVenta();
        Venta expResult = null;
        Venta result = instance.crearVenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalcularTotalVenta method, of class RegistroVenta.
     */
    @Ignore
    public void testCalcularTotalVenta() {
        System.out.println("CalcularTotalVenta");
        RegistroVenta instance = new RegistroVenta();
        DTOTotales expResult = null;
        DTOTotales result = instance.CalcularTotalVenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
