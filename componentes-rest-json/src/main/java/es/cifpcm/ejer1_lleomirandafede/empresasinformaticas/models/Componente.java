/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.models;

import es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.dao.TipoComponenteDao;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "componente")
@NamedQueries({
@NamedQuery(name = "componente.findAll", query = "SELECT c FROM componente c")})
public class Componente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(max = 20)
    @Column(name = "clave")
    private String clave;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;   
    @Column(name = "precio")
    private float precio;
    @Column(name = "CodTipo")
    private int CodTipo;
    
 
    @JoinColumn(name = "CodTipo", referencedColumnName = "CodTipo")
    @ManyToOne
    private TipoComponente tipocomponente;
    
    
  
    public Componente() {
        
    }

    public Componente(String clave, String descripcion, float precio, int CodTipo) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.precio = precio;
        this.CodTipo = CodTipo;
    }

  

    
    
    
   
    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCodTipo() {
        return CodTipo;
    }

    public void setCodTipo(int CodTipo) {
        this.CodTipo = CodTipo;
    }

    public TipoComponente getTipocomponente() {
        return tipocomponente;
    }

    public void setTipocomponente(TipoComponente tipocomponente) {
        this.tipocomponente = tipocomponente;
    }


    
    
}
