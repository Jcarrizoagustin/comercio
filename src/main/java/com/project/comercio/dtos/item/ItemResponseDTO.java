package com.project.comercio.dtos.item;

import lombok.Data;

@Data
public class ItemResponseDTO {
    private String productName;
    private Integer quantity;
    private String subtotal;
}
