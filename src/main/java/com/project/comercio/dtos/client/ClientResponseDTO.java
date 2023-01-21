package com.project.comercio.dtos.client;

import lombok.Data;

import java.util.UUID;
@Data
public class ClientResponseDTO {

    private UUID id;
    private String name;
    private String surname;
    private String phone;
    private String dni;
    private String email;
}
