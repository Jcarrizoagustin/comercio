package com.project.comercio.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name = "category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "UUID",strategy = "uuid2")
    @GeneratedValue(generator = "UUID")
    @Column(name = "id_category",updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name",length = 50,unique = true)
    private String name;

}
