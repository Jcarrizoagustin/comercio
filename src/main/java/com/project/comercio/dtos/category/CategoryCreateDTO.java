package com.project.comercio.dtos.category;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoryCreateDTO {
    @Getter @Setter
    @NotBlank(message = "Name can't be blank") @NotNull(message = "Name is required") @NotEmpty(message = "Name can't be empty")
    private String name;
}
