package com.project.comercio.mappers.category;

import com.project.comercio.dtos.category.CategoryCreateDTO;
import com.project.comercio.dtos.category.CategoryResponseDTO;
import com.project.comercio.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper{
    @Override
    public Category categoryCreateDTOToCategory(CategoryCreateDTO create) {
        Category category = new Category();
        category.setName(create.getName());
        return category;
    }

    @Override
    public CategoryResponseDTO categoryToCategoryResponseDTO(Category category) {
        CategoryResponseDTO responseDTO = new CategoryResponseDTO();
        responseDTO.setId(category.getId());
        responseDTO.setName(category.getName());
        return responseDTO;
    }
}
