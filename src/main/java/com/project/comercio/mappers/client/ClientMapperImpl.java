package com.project.comercio.mappers.client;

import com.project.comercio.dtos.client.ClientCreationDTO;
import com.project.comercio.dtos.client.ClientResponseDTO;
import com.project.comercio.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImpl implements ClientMapper{

    @Override
    public Client clientCreationDTOToClient(ClientCreationDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setSurname(dto.getSurname());
        client.setPhone(dto.getPhone());
        client.setDni(dto.getDni());
        client.setEmail(dto.getEmail());
        return client;
    }

    @Override
    public ClientResponseDTO clientToClientResponseDTO(Client client) {
        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setSurname(client.getSurname());
        dto.setPhone(client.getPhone());
        dto.setDni(client.getDni());
        dto.setEmail(client.getEmail());
        return dto;
    }
}
