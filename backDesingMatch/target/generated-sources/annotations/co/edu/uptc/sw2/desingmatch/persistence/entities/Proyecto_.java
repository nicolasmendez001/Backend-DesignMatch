package co.edu.uptc.sw2.desingmatch.persistence.entities;

import co.edu.uptc.sw2.desingmatch.persistence.entities.Disenio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T04:07:17")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> descripcion;
    public static volatile ListAttribute<Proyecto, Disenio> disenios;
    public static volatile SingularAttribute<Proyecto, Double> valor;
    public static volatile SingularAttribute<Proyecto, Integer> id;
    public static volatile SingularAttribute<Proyecto, String> nombre;

}