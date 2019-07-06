package co.edu.uptc.sw2.desingmatch.persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-06T09:01:59")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> descripcion;
    public static volatile ListAttribute<Proyecto, Disenio> disenios;
    public static volatile SingularAttribute<Proyecto, Double> valor;
    public static volatile SingularAttribute<Proyecto, String> nombre;
    public static volatile SingularAttribute<Proyecto, Integer> id;

}