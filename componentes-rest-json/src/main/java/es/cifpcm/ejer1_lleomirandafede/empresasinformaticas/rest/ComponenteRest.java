/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.rest;

import es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.dao.ComponenteDao;
import es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.dao.ComponenteDaoImpl;
import es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.dao.TipoComponenteDao;
import es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.dao.TipoComponenteDaoImpl;
import es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.models.Componente;
import es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.models.TipoComponente;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author fedel
 */
@Path("componentes")
public class ComponenteRest {
    
    ComponenteDao cdao =  new ComponenteDaoImpl();
    TipoComponenteDao tcdao =  new TipoComponenteDaoImpl();
    
    @Context
    private UriInfo context;

    public ComponenteRest() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String peticionComponentes() {
        JSONArray jsonArray = new JSONArray();
        for (Componente componente : cdao.getComponentes()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("clave", componente.getClave());
            jsonObject.put("descripcion", componente.getDescripcion());
            jsonObject.put("precio", componente.getPrecio());
            TipoComponente tc = tcdao.getTipoComponente(componente.getCodTipo());
            jsonObject.put("tipo", tc.getTipo());
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }

 
    
    
    
}
