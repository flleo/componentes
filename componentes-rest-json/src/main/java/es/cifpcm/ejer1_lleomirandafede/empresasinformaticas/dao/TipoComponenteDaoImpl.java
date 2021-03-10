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
import java.util.List;

/**
 *
 * @author fedel
 */
public class TipoComponenteDaoImpl implements TipoComponenteDao{

    DaoConfig  daoCfg = new DaoConfig();
    DaoFactory factory;

    public TipoComponenteDaoImpl() {
        this.daoCfg = new DaoConfig("empresasinformaticas.properties");
        factory = new DaoFactory(daoCfg);
    }
    
    
    @Override
    public TipoComponente getTipoComponente(int id) {
        PreparedStatement stmt = null;
        TipoComponente tipo = new TipoComponente();
        try {
            stmt = factory.getConnection().prepareStatement("SELECT * FROM tipocomponente where CodTipo=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            tipo.setCodTipo(rs.getInt("CodTipo"));
            tipo.setTipo(rs.getString("Tipo"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipo;
    }

  
    
    
    
}
