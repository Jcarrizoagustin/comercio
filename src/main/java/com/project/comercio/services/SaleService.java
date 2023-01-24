package com.project.comercio.services;

import com.project.comercio.entities.Client;
import com.project.comercio.entities.Item;
import com.project.comercio.entities.Sale;
import com.project.comercio.exceptions.EntityNotFoundException;
import com.project.comercio.exceptions.NotFoundException;
import com.project.comercio.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;
    @Transactional
    public Sale saveSale(Sale sale){
        sale.calcTotal();
        return repository.save(sale);
    }

    public List<Sale> allSales(){
        return repository.findAll();
    }

    public Sale findById(UUID id){
        if(repository.existsById(id)){
            return repository.findById(id).get();
        }
        throw new EntityNotFoundException("No existe la venta para el id: " + id.toString());
    }

    public List<Sale> allSalesForClient(Client client){
        List<Sale> sales = repository.findSaleByClient(client);
        if(sales.isEmpty()){
            throw new NotFoundException("No se encontraron ventas para el idCliente proporcionado: "+client.getId().toString());
        }
        return sales;
    }
}
