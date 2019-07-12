package co.edu.uptc.sw2.desingmatch.persistence.entities;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Proyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T04:07:17")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> contrasena;
    public static volatile SingularAttribute<Empresa, Integer> id;
    public static volatile ListAttribute<Empresa, Proyecto> proyectos;
    public static volatile SingularAttribute<Empresa, String> nombre;
    public static volatile SingularAttribute<Empresa, String> email;
    public static volatile SingularAttribute<Empresa, String> url;

}