package com.project.comercio.controllers;

import com.project.comercio.dtos.category.CategoryCreateDTO;
import com.project.comercio.dtos.category.CategoryResponseDTO;
import com.project.comercio.entities.Category;
import com.project.comercio.mappers.category.CategoryMapper;
import com.project.comercio.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @Autowired
    private CategoryMapper mapper;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAll(){
        List<Category> categoryList = service.listAll();
        List<CategoryResponseDTO> responseDTOS = categoryList.stream()
                .map(category -> mapper.categoryToCategoryResponseDTO(category))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getById(@PathVariable UUID id){
        Category category = service.findById(id);
        return ResponseEntity.ok(mapper.categoryToCategoryResponseDTO(category));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> postCategory(@RequestBody CategoryCreateDTO dto){
        Category category = mapper.categoryCreateDTOToCategory(dto);
        Category created = service.postCategory(category);
        return ResponseEntity.ok(mapper.categoryToCategoryResponseDTO(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable UUID id, @RequestBody CategoryCreateDTO dto){
        service.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
