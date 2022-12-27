package com.project.comercio.mappers.product;

import com.project.comercio.dtos.product.ProductCreateDTO;
import com.project.comercio.dtos.product.ProductResponseDTO;
import com.project.comercio.entities.Category;
import com.project.comercio.entities.Product;
import com.project.comercio.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper{
    @Autowired
    private CategoryService service;

    @Override
    public Product productCreateDTOToProduct(ProductCreateDTO dto) {
        Product product = new Product();
        Category category = service.findById(dto.getCategoryID());
        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setStock(dto.getStock());
        product.setDescription(dto.getDescription());
        product.setCostPrice(dto.getCostPrice());
        product.setSalePrice(dto.getSalePrice());
        product.setCategory(category);
        return product;
    }

    @Override
    public ProductResponseDTO productToProductResponseDTO(Product product) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setId(product.getId());
        responseDTO.setName(product.getName());
        responseDTO.setBrand(product.getBrand());
        responseDTO.setCategory(product.getCategory().getName());
        responseDTO.setDesciption(product.getDescription());
        responseDTO.setAvailableStock(product.getStock());
        responseDTO.setPrice(product.getSalePrice());
        return responseDTO;
    }
}
