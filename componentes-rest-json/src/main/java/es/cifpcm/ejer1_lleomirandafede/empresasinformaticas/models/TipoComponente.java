/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fedel
 */
@Entity
@Table(name = "tipocomponente")
@NamedQueries({
@NamedQuery(name = "tipocomponente.findAll", query = "SELECT t FROM tipocomponente t")})
public class TipoComponente implements Serializable {  
    private static final long serialVersionUID = 1L;
       
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodTipo")
    private int CodTipo;
    @Size(max = 255)
    @Column(name = "Tipo")
    private String Tipo;

    public TipoComponente() {
    }

    public TipoComponente(int CodTipo) {
        this.CodTipo = CodTipo;
    }        

    public TipoComponente(int CodTipo, String Tipo) {
        this.CodTipo = CodTipo;
        this.Tipo = Tipo;
    }

    public int getCodTipo() {
        return CodTipo;
    }

    public void setCodTipo(int CodTipo) {
        this.CodTipo = CodTipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
