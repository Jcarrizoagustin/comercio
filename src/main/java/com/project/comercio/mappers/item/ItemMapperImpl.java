package com.project.comercio.mappers.item;

import com.project.comercio.dtos.item.ItemCreationDTO;
import com.project.comercio.dtos.item.ItemResponseDTO;
import com.project.comercio.entities.Item;
import com.project.comercio.entities.Sale;
import com.project.comercio.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemMapperImpl implements ItemMapper{
    @Autowired
    private ProductService service;

    @Override
    public Item itemCreationDTOToItem(ItemCreationDTO dto, Sale sale) {
        Item item = new Item();
        item.setProduct(service.findById(dto.getIdProduct()));
        item.setQuantity(dto.getQuantity());
        item.setSale(sale);
        return item;
    }

    @Override
    public ItemResponseDTO itemToItemResponseDTO(Item item) {
        ItemResponseDTO dto = new ItemResponseDTO();
        dto.setQuantity(item.getQuantity());
        dto.setProductName(item.getProduct().getName());
        dto.setSubtotal(item.getSubtotal().toString());
        return dto;
    }
}
