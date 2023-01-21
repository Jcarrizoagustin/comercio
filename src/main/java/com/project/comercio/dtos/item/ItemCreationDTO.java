package com.project.comercio.dtos.item;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class ItemCreationDTO {
    private UUID idProduct;
    private int quantity;
}
