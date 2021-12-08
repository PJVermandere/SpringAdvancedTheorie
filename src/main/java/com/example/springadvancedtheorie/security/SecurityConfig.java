package com.example.springadvancedtheorie.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.oauth2Login();
        http.csrf().disable();
        http.authorizeRequests(req -> req.mvcMatchers("/", "/filialen").permitAll().mvcMatchers("/beveiligd/**").authenticated());
    }
}
