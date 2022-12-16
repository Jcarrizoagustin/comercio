package com.project.comercio.services;

import com.project.comercio.dtos.category.CategoryCreateDTO;
import com.project.comercio.entities.Category;
import com.project.comercio.exceptions.EntityNotFoundException;
import com.project.comercio.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> listAll(){
        return repository.findAll();
    }

    public Category findById(UUID id){
        Optional<Category> optional = repository.findById(id);
        if(!optional.isPresent()){
            throw new EntityNotFoundException("No se encuentra la categoria con el id proporcionado: "+ id);
        }
        return repository.findById(id).get();
    }

    public Category postCategory(Category category){

        return repository.save(category);
    }

    public void update(UUID id, CategoryCreateDTO dto){
        if(repository.existsById(id)){
            Category category = findById(id);
            category.setName(dto.getName());
            repository.save(category);
        }else {
            throw new EntityNotFoundException("No se encuentra la categoria con el id proporcionado: "+ id);
        }

    }

    public void delete(UUID id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new EntityNotFoundException("No se encuentra la categoria con el id proporcionado: "+ id);
        }

    }
}
