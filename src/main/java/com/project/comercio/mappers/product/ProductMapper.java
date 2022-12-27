package com.project.comercio.mappers.product;

import com.project.comercio.dtos.product.ProductCreateDTO;
import com.project.comercio.dtos.product.ProductResponseDTO;
import com.project.comercio.entities.Product;

public interface ProductMapper {
    Product productCreateDTOToProduct(ProductCreateDTO dto);

    ProductResponseDTO productToProductResponseDTO(Product product);
}
