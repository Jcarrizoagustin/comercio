package com.project.comercio.controllers;

import com.project.comercio.dtos.product.ProductCreateDTO;
import com.project.comercio.dtos.product.ProductResponseDTO;
import com.project.comercio.entities.Product;
import com.project.comercio.mappers.product.ProductMapper;
import com.project.comercio.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<Product> products = service.allProducts();
        List<ProductResponseDTO> responseDTOS = products.stream()
                .map(product -> mapper.productToProductResponseDTO(product))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> postProduct(@Valid @RequestBody ProductCreateDTO dto){
        Product product = mapper.productCreateDTOToProduct(dto);
        Product created = service.save(product);
        return ResponseEntity.ok(mapper.productToProductResponseDTO(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable UUID id){
        Product product = service.findById(id);
        return ResponseEntity.ok(mapper.productToProductResponseDTO(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeProduct(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable UUID id, @RequestBody ProductCreateDTO dto){
        Product product = mapper.productCreateDTOToProduct(dto);
        ProductResponseDTO responseDTO = mapper.productToProductResponseDTO(service.update(id,product));
        return ResponseEntity.ok(responseDTO);
    }
}
