package com.project.comercio.mappers.category;

import com.project.comercio.dtos.category.CategoryCreateDTO;
import com.project.comercio.dtos.category.CategoryResponseDTO;
import com.project.comercio.entities.Category;



public interface CategoryMapper {

    Category categoryCreateDTOToCategory(CategoryCreateDTO create);

    CategoryResponseDTO categoryToCategoryResponseDTO(Category category);
}
