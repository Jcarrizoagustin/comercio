package com.project.comercio.services;

import com.project.comercio.entities.Client;
import com.project.comercio.exceptions.EntityNotFoundException;
import com.project.comercio.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client getClientById(UUID id){
        if (repository.existsById(id)){
           return repository.findById(id).get();
        }
        throw new EntityNotFoundException("No existe el cliente con id: " + id.toString());
    }

    public Client saveClient(Client client){
        return repository.save(client);
    }

    public List<Client> getAll(){
        return repository.findAll();
    }



}
