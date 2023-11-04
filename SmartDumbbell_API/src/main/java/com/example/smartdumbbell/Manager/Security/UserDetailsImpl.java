package com.example.smartdumbbell.Manager.Security;


import com.example.smartdumbbell.Manager.Domain.Manager;
import com.example.smartdumbbell.Manager.Model.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private static final String ROLE_PREFIX = "ROLE_";
    private final Manager manager;
    private final boolean isApproved; // 승인 여부를 저장하는 필드

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role role = manager.getRole();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ROLE_PREFIX + role.toString());
        Collection<GrantedAuthority> authorities = new ArrayList<>(); //List인 이유 : 여러개의 권한을 가질 수 있다
        authorities.add(authority);

        return authorities;
    }

    @Override
    public String getPassword() {
        return manager.getPassword();
    }

    @Override
    public String getUsername() {
        return manager.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return manager.getName();
    }
    public boolean isApproved() {
        return isApproved;
    }
}