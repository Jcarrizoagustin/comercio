package com.project.comercio.controllers;

import com.project.comercio.dtos.sale.SaleCreationDTO;
import com.project.comercio.dtos.sale.SaleResponseDTO;
import com.project.comercio.entities.Sale;
import com.project.comercio.mappers.sale.SaleMapper;
import com.project.comercio.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {
    @Autowired
    private SaleService service;

    @Autowired
    private SaleMapper mapper;

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> getAllSales(){
        List<SaleResponseDTO> responseDTOS = service.allSales().stream()
                .map(sale -> mapper.saleToSaleResponseDTO(sale))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @PostMapping
    public ResponseEntity<SaleResponseDTO> postSale(@RequestBody SaleCreationDTO dto) {
        Sale sale = mapper.saleCreationDTOToSale(dto);
        Sale saleSaved = service.saveSale(sale);
        return ResponseEntity.ok(mapper.saleToSaleResponseDTO(saleSaved));
    }
}
