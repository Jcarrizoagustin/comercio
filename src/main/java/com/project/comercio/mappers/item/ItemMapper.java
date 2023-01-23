package com.project.comercio.mappers.item;

import com.project.comercio.dtos.item.ItemCreationDTO;
import com.project.comercio.dtos.item.ItemResponseDTO;
import com.project.comercio.entities.Item;
import com.project.comercio.entities.Sale;

public interface ItemMapper {

    Item itemCreationDTOToItem(ItemCreationDTO dto, Sale sale);

    ItemResponseDTO itemToItemResponseDTO(Item item);

}
