package com.project.comercio.dtos.product;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductResponseDTO {

    private UUID id;
    private String name;
    private String brand;
    private String desciption;
    private String category;
    private Integer availableStock;
    private BigDecimal price;

}
