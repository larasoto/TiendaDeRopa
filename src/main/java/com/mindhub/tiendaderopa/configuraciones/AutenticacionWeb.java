package com.mindhub.tiendaderopa.configuraciones;

import com.mindhub.tiendaderopa.modelos.Cliente;
import com.mindhub.tiendaderopa.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AutenticacionWeb extends GlobalAuthenticationConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inputName -> {
            Cliente cliente = clienteRepositorio.findByEmail(inputName);
            if (cliente != null) {
                if (cliente.getEmail().equals("admin@admin.com")) {
                    return new User(cliente.getEmail(), cliente.getPassword(),
                            AuthorityUtils.createAuthorityList("ADMIN"));
                }
                return new User(cliente.getEmail(), cliente.getPassword(),
                        AuthorityUtils.createAuthorityList("CLIENT"));
            } else {
                throw new UsernameNotFoundException("Unknown user:" + inputName);
            }
        });
    }
}
