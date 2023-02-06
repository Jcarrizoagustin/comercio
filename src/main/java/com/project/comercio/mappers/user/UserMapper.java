package com.project.comercio.mappers.user;

import com.project.comercio.dtos.user.UserCreateDto;
import com.project.comercio.entities.User;

public interface UserMapper {

    User userCreateDtoToUser(UserCreateDto dto);


}
