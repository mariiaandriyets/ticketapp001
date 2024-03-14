package org.ticket.com.model;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {


    ADMIN("ADMIN"),
    USER("USER");

    private final String value;

    @Override
    public java.lang.String getAuthority() {
        return value;
    }
}
