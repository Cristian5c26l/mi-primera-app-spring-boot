package com.ipn.mx.miprimeraappspringboot.security;

import com.ipn.mx.miprimeraappspringboot.model.UserInfo;
import com.ipn.mx.miprimeraappspringboot.repository.UserInfoRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserInfoRepo userInfoRepo; // instancia inyectada que es un bean (@Service y @Repository son beans).

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = this.userInfoRepo.findByUsername(username);

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();// build para terminar la construccion del objeto User de spring security basado en el userinfo, con determinado username, que viene de la tabla userinfo de la base de datos (accedida a traves del repositorio UserInfoRepo)
    }
}
