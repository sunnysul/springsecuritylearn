package com.example.springsecuritylearn.Security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class SecurityClass {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.requestMatchers("/login", "/register").permitAll();
                    authorizeRequests.anyRequest().hasRole("ADMIN");
                });

        http.csrf((csrf) -> {
            csrf.disable();
        });

        http.sessionManagement((sessionManagement) -> {
            sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        http.httpBasic((httpBasic) -> {
        });

        http.cors((cors) -> {
        });
        return http.build();
    }

    // @Bean
    // UserDetailsService users() {
    // UserDetails user = User.builder()
    // .username("user")
    // .password("{noop}password")
    // .roles("USER")
    // .build();
    // return new InMemoryUserDetailsManager(user);
    // }

    @Bean
    UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);

    }

}
