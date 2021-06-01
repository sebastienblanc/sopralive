package org.sebi;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Todo extends PanacheEntity {
    
    public String title;
}
