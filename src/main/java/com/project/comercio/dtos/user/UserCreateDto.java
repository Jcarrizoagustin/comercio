package com.project.comercio.dtos.user;

import lombok.Data;

import java.util.List;


@Data
public class UserCreateDto {

    private String username;
    private String password;

    private List<Long> authoritiesId;

}
