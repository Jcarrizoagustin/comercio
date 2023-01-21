package com.project.comercio.mappers.sale;

import com.project.comercio.dtos.item.ItemResponseDTO;
import com.project.comercio.dtos.sale.SaleCreationDTO;
import com.project.comercio.dtos.sale.SaleResponseDTO;
import com.project.comercio.entities.Client;
import com.project.comercio.entities.Item;
import com.project.comercio.entities.Sale;
import com.project.comercio.mappers.item.ItemMapper;
import com.project.comercio.mappers.item.ItemMapperImpl;
import com.project.comercio.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SaleMapperImpl implements SaleMapper{
    @Autowired
    private ItemMapper itemMapper;

    //TODO clienteService
    @Autowired
    private ClientService clientService;



    @Override
    public Sale saleCreationDTOToSale(SaleCreationDTO dto) {
        Sale sale = new Sale();
        List<Item> items = dto.getDtos().stream()
                .map(item -> itemMapper.itemCreationDTOToItem(item))
                .collect(Collectors.toList());
        sale.setItems(items);
        sale.setClient(clientService.getClientById(dto.getIdClient()));
        sale.setDate(LocalDateTime.now());
        return sale;
    }

    @Override
    public SaleResponseDTO saleToSaleResponseDTO(Sale sale) {
        SaleResponseDTO dto = new SaleResponseDTO();
        dto.setId(sale.getId());
        dto.setClient(sale.getClient().getName() +" " + sale.getClient().getSurname());
        dto.setDate(sale.getDate().toString());
        dto.setTotal(sale.getTotal().toString());
        List<ItemResponseDTO> itemsDtos = sale.getItems().stream()
                .map(item -> itemMapper.itemToItemResponseDTO(item)
                ).collect(Collectors.toList());
        dto.setItems(itemsDtos);
        return dto;
    }

}
