/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracionpos;

import entidadespos.Linea;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Sebastian
 */
public class ArchivoLinea {
     @XmlElement(name = "Lineas")
    private List<Linea> listaL = new ArrayList<>();
    

    public ArchivoLinea(List<Linea> lista) {
        this.listaL = lista;
    }

    public ArchivoLinea() {
    }

    public List<Linea> getListaL() {
        return listaL;
    }

    
    
}
