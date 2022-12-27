package com.project.comercio.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Table(name = "product")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "UUID",strategy = "uuid2")
    @GeneratedValue(generator = "UUID")
    @Column(name = "id_product")
    private UUID id;

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    @Column(name = "brand",length = 50)
    private String brand;

    @ManyToOne
    @JoinColumn(name = "fk_category",referencedColumnName = "id_category")
    private Category category;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "description")
    private String description;

    @Column(name = "cost_price")
    private BigDecimal costPrice;

    @Column(name = "sale_price",nullable = false)
    private BigDecimal salePrice;


}
