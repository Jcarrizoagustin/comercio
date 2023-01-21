package com.project.comercio.dtos.sale;

import com.project.comercio.dtos.item.ItemResponseDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class SaleResponseDTO {
    private UUID id;
    private String client;
    private String total;
    private String date;
    private List<ItemResponseDTO> items;
}
