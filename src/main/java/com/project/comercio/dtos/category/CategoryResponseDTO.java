package com.project.comercio.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor @NoArgsConstructor
public class CategoryResponseDTO {
    @Getter @Setter
    private UUID id;
    @Getter @Setter
    private String name;
}
