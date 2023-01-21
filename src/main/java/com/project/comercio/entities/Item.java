package com.project.comercio.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Table(name = "item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_item")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "fk_product",referencedColumnName = "id_product")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_sale",referencedColumnName = "id_sale")
    private Sale sale;

    public void calcSubtotal(){
        this.subtotal = this.product.getSalePrice().multiply(BigDecimal.valueOf(quantity));
    }

}
