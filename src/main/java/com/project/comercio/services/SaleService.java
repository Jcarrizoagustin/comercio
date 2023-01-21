package com.project.comercio.services;

import com.project.comercio.entities.Item;
import com.project.comercio.entities.Sale;
import com.project.comercio.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public Sale saveSale(Sale sale){
        sale.calcTotal();
        return repository.save(sale);
    }

    public List<Sale> allSales(){
        return repository.findAll();
    }
}
