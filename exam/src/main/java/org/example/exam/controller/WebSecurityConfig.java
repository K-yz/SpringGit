package org.example.exam.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http, HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeRequests(registry->{
            registry.requestMatchers("/users/list").permitAll();
            registry.requestMatchers("/users/showFormForAdd").hasRole("ADMIN");
            registry.requestMatchers("/users/showFormForUpdate").hasRole("USER");
            registry.anyRequest().authenticated();
                })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User.builder()
                .username("Nam")
                .password("$2a$12$0gR6XWqOMy7PloRR7GGHGOfH44p4SRKPHlGu/EG1wsdD4Z9ujKwPy")
                .roles("USER")
                .build();
        UserDetails adminUser = User.builder()
                .username("Admin")
                .password("$2a$12$XBQwez5pbk8hDZOixgC0gOSXBwDe3FDuJXDubKc24Mul/.dsxKNdG")
                .roles("ADMIN", "USER")
                .build();
        return new InMemoryUserDetailsManager(normalUser, adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
