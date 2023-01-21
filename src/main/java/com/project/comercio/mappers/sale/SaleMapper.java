package com.project.comercio.mappers.sale;

import com.project.comercio.dtos.sale.SaleCreationDTO;
import com.project.comercio.dtos.sale.SaleResponseDTO;
import com.project.comercio.entities.Sale;

public interface SaleMapper {
    Sale saleCreationDTOToSale(SaleCreationDTO dto);

    SaleResponseDTO saleToSaleResponseDTO(Sale sale);
}
