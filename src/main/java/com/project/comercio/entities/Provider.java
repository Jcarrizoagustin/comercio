package com.project.comercio.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name = "provider")
public class Provider implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_provider")
    private UUID id;

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "phone",unique = true)
    private String phone;
    @Column(name = "cuit",unique = true,nullable = false)
    private String cuit;


}
