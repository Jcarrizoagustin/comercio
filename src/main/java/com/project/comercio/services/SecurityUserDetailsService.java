package com.project.comercio.services;

import com.project.comercio.entities.User;
import com.project.comercio.repositories.UserRepository;
import com.project.comercio.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByUsername(username);
        if(user.isPresent()){
            return new SecurityUser(user.get());
        }
        throw new UsernameNotFoundException("No se encuentra el usuario "+ username);
    }
}
