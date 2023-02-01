package com.project.comercio.security;

import com.project.comercio.entities.Authority;
import com.project.comercio.utils.AuthorityName;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
    private Authority authority;
    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
