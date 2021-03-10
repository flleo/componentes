/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.dao;

import es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.models.Componente;
import es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.models.TipoComponente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedel
 */
public class ComponenteDaoImpl implements ComponenteDao{
    
    DaoConfig  daoCfg = new DaoConfig();
    DaoFactory factory;

    public ComponenteDaoImpl() {
        this.daoCfg = new DaoConfig("empresasinformaticas.properties");
        factory = new DaoFactory(daoCfg);
    }
    
    

    @Override
    public List<Componente> getComponentes() {
        PreparedStatement stmt = null;
        ArrayList<Componente> componentes = new ArrayList<Componente>();
        try {
            stmt = factory.getConnection().prepareStatement("SELECT c.clave, c.descripcion, c.precio, c.CodTipo FROM componente c");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Componente componente = new Componente();
                componente.setClave(rs.getString("clave"));
                componente.setDescripcion(rs.getString("descripcion"));
                componente.setPrecio(rs.getFloat("precio"));                
                componente.setCodTipo(rs.getInt("CodTipo"));
                componentes.add(componente);
                System.out.println(componente);
            }

        } catch (SQLException ex) {
            //Logger.getLogger(TiendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return componentes;
    }

    private String getTipo(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
