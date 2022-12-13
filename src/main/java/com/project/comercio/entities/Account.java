package com.project.comercio.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Table(name = "account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_account")
    private UUID id;

    @Column(name = "revenues")
    private BigDecimal revenues;

    @Column(name = "expenses")
    private BigDecimal expenses;


}
