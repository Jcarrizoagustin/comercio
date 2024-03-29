package com.project.comercio.controllers;

import com.project.comercio.dtos.client.ClientCreationDTO;
import com.project.comercio.dtos.client.ClientResponseDTO;
import com.project.comercio.dtos.sale.SaleResponseDTO;
import com.project.comercio.entities.Client;
import com.project.comercio.entities.Sale;
import com.project.comercio.mappers.client.ClientMapper;
import com.project.comercio.mappers.sale.SaleMapper;
import com.project.comercio.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    @Autowired
    private ClientService service;
    @Autowired
    private ClientMapper mapper;
    @Autowired
    private SaleMapper saleMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable UUID id){
        return ResponseEntity.ok(mapper.clientToClientResponseDTO(service.getClientById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllClients(){
        List<ClientResponseDTO> dtos = service.getAll().stream()
                .map(client -> mapper.clientToClientResponseDTO(client))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> postClient(@RequestBody ClientCreationDTO dto){
        Client created = service.saveClient(mapper.clientCreationDTOToClient(dto));
        return ResponseEntity.ok(mapper.clientToClientResponseDTO(created));
    }

    //Todas las compras de un cliente por su id
    @GetMapping("/{id}/orders")
    public ResponseEntity<List<SaleResponseDTO>> salesForClient(@PathVariable UUID id){
        Client client = service.getClientById(id);
        List<Sale> sales = service.getAllSalesForClient(client);
        List<SaleResponseDTO> responseDTOS = sales.stream()
                .map(sale -> saleMapper.saleToSaleResponseDTO(sale))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }
}
