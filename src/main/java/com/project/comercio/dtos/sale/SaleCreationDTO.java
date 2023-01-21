package com.project.comercio.dtos.sale;

import com.project.comercio.dtos.item.ItemCreationDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter @Setter
public class SaleCreationDTO {

    private UUID idClient;
    private List<ItemCreationDTO> dtos;

}
