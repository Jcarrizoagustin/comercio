package com.project.comercio.mappers.client;

import com.project.comercio.dtos.client.ClientCreationDTO;
import com.project.comercio.dtos.client.ClientResponseDTO;
import com.project.comercio.entities.Client;

public interface ClientMapper {
    Client clientCreationDTOToClient(ClientCreationDTO dto);
    ClientResponseDTO clientToClientResponseDTO(Client client);
}
