package com.project.comercio.mappers.user;

import com.project.comercio.dtos.user.UserCreateDto;
import com.project.comercio.entities.Authority;
import com.project.comercio.entities.User;
import com.project.comercio.repositories.AuthorityRepository;
import com.project.comercio.utils.AuthorityName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements UserMapper{

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public User userCreateDtoToUser(UserCreateDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        List<Authority> authorities = dto.getAuthoritiesId().stream()
                .map(auth -> authorityRepository.findById(auth).get())
                .collect(Collectors.toList());
        user.setAuthorities(authorities);
        return user;
    }
}
