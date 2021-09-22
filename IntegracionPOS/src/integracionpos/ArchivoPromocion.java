/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracionpos;

import entidadespos.Promocion;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Sebastian
 */
public class ArchivoPromocion {

    @XmlElement(name = "promocion")
   
    private List<Promocion> listaP = new ArrayList<>();

    public ArchivoPromocion(List<Promocion> lista) {
        this.listaP=lista;
    }

    public ArchivoPromocion() {
    }

    public List<Promocion> getListaP() {
        return listaP;
    }


    
}
