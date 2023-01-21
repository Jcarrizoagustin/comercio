package com.project.comercio.mappers.item;

import com.project.comercio.dtos.item.ItemCreationDTO;
import com.project.comercio.dtos.item.ItemResponseDTO;
import com.project.comercio.entities.Item;

public interface ItemMapper {

    Item itemCreationDTOToItem(ItemCreationDTO dto);

    ItemResponseDTO itemToItemResponseDTO(Item item);

}
