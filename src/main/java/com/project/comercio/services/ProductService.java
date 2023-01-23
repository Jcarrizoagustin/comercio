package com.project.comercio.services;

import com.project.comercio.dtos.product.ProductCreateDTO;
import com.project.comercio.entities.Product;
import com.project.comercio.exceptions.EntityNotFoundException;
import com.project.comercio.exceptions.StockConflictException;
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

    public void delete(UUID id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("No existe el producto para el id: "+id);
        }
        repository.deleteById(id);
    }

    public Product update(UUID id, Product dto){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("No existe el producto para el id: "+id);
        }
        Product product = repository.findById(id).get();
        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setBrand(dto.getBrand());
        product.setDescription(dto.getDescription());
        product.setCostPrice(dto.getCostPrice());
        product.setSalePrice(dto.getSalePrice());
        product.setStock(dto.getStock());
        return repository.save(product);
    }

    public List<Product> allProducts(){
        return repository.findAll();
    }

    //Chequea si hay stock para un producto en particular
    private boolean checkStock(Integer units,UUID productId){
        if(repository.existsById(productId)){
            Product product = repository.findById(productId).get();
            if(units <= product.getStock() ){
                return true;
            }else{
                return false;
            }
        }else{
            throw new EntityNotFoundException("No existe el producto para el id: " + productId.toString());
        }
    }

    public void updateStock(Integer units, UUID productId){
        Integer stock = repository.findById(productId).get().getStock();
        if(this.checkStock(units,productId)){
            Integer newStock = stock - units;
            Product product = repository.findById(productId).get();
            product.setStock(newStock);
            repository.save(product);
        }else{
            throw new StockConflictException("No hay stock. Stock solicitado: " + units + ", stock disponible: " + stock);
        }
    }
}
