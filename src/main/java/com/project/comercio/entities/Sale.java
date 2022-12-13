package com.project.comercio.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "sale")
public class Sale implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sale")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "fk_client",referencedColumnName = "id_client")
    private Client client;

    @Column(name = "date",nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm",iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    @OneToMany(mappedBy = "sale")
    private List<Item> items;

    @Column(name = "total")
    private BigDecimal total;



}
