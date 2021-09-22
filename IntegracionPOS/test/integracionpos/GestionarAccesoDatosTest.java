/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracionpos;

import entidadespos.Producto;
import entidadespos.Venta;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sebastian
 */
public class GestionarAccesoDatosTest {
    
    public GestionarAccesoDatosTest() {
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

    
    @Test
    public void testLeerProductos() {
         System.out.println("leerParametros");
        GestionarAccesoDatos instance = new GestionarAccesoDatos();
        boolean expResult = true;
        //Se declara como falso para que se ponga verdadero si efectivamente cargó la lista.
        boolean result=false;
        if (instance.consultarProductos().size() > 0){
             result = true;
        }
        
        
        System.out.println(instance.getProductos().size());
        assertEquals(expResult, result);
        //Unsuccessful test
        //Puesto que cambiamos las direccion esperamos que el test falle.
        expResult = false;
        instance.setFILE_NAME_LINEASXML("sadg");
        instance.setFILE_NAME_PROMOCIONESXML("sadg");
        //Se declara como verdadero para que se ponga falso si no cargó la lista.
        result=true;
         if (instance.consultarProductos() == null){
             result = false;
        }
         
        System.out.println(instance.getProductos().size());
        assertEquals(expResult, result);
    }

    
    
}
