package es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.models;

import es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.models.TipoComponente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T11:54:47")
@StaticMetamodel(Componente.class)
public class Componente_ { 

    public static volatile SingularAttribute<Componente, String> descripcion;
    public static volatile SingularAttribute<Componente, String> clave;
    public static volatile SingularAttribute<Componente, Float> precio;
    public static volatile SingularAttribute<Componente, Integer> CodTipo;
    public static volatile SingularAttribute<Componente, TipoComponente> tipocomponente;

}