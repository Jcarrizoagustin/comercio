package com.project.comercio.services;

import com.project.comercio.entities.Product;
import com.project.comercio.exceptions.EntityNotFoundException;
import com.project.comercio.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product product){
        return repository.save(product);
    }

    public Product findById(UUID id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("No existe el producto para el id: "+id);
        }
        return repository.findById(id).get();
    }

    public List<Product> allProducts(){
        return repository.findAll();
    }
}
