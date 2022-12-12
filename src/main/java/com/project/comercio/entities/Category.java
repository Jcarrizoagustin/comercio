package com.project.comercio.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name = "category")
public class Category implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_category")
    private UUID id;

    @Column(name = "name",length = 50,unique = true,nullable = false)
    private String name;

}
