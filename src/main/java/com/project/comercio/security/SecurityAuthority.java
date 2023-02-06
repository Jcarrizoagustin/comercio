package com.project.comercio.security;

import com.project.comercio.entities.Authority;
import com.project.comercio.utils.AuthorityName;
import org.springframework.security.core.GrantedAuthority;

public class SecurityAuthority implements GrantedAuthority {
    private Authority authority;

    public SecurityAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
