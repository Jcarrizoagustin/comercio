package com.project.comercio.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;
@Entity
@Data
@Table(name = "client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client")
    private UUID id;
    @Column(name = "name",length = 50,nullable = false)
    private String name;
    @Column(name = "surname",length = 50,nullable = false)
    private String surname;
    @Column(name = "phone",length = 50,unique = true)
    private String phone;
    @Column(name = "dni",length = 8,unique = true)
    private String dni;
    @Column(name = "email",unique = true)
    private String email;


}
