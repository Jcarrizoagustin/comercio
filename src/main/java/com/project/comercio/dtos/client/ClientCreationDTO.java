package com.project.comercio.dtos.client;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ClientCreationDTO {
    @NotEmpty @NotNull
    private String name;
    @NotEmpty @NotNull
    private String surname;
    private String phone;
    @Max(8)
    private String dni;
    private String email;
}
