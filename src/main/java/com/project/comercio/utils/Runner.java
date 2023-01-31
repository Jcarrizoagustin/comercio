package com.project.comercio.utils;

import com.project.comercio.entities.Authority;
import com.project.comercio.entities.User;
import com.project.comercio.repositories.AuthorityRepository;
import com.project.comercio.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Runner implements CommandLineRunner {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.authorityRepository.count() ==0){
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.USER)
            ));
        }

        if(this.userRepository.count() ==0){
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            this.userRepository.saveAll(List.of(
                    new User("derkho",encoder.encode("derkho123456"),List.of(this.authorityRepository.findByName(AuthorityName.USER).get())),
                    new User("duke",encoder.encode("duke123456"),List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get(),this.authorityRepository.findByName(AuthorityName.USER).get()))
            ));
        }
    }
}
