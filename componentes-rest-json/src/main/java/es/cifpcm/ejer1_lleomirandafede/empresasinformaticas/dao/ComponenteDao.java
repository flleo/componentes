/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.dao;

import es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.models.Componente;
import java.util.List;

/**
 *
 * @author fedel
 */
public interface ComponenteDao {
    List<Componente> getComponentes();
    
}
