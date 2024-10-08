package com.example.demo.service.Components.main;

import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CustomUser {
    private String username;
    private Collection<SimpleGrantedAuthority> grantedAuthorities;
    private Long depotId;
}
