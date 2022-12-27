package com.project.comercio.dtos.product;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductCreateDTO {

    @NotBlank(message = "Name is required")
    private String name;
    private String brand;
    private UUID categoryID;
    private Integer stock;
    private String description;
    private BigDecimal costPrice;
    @NotNull(message = "salePrice is required")
    private BigDecimal salePrice;
}
