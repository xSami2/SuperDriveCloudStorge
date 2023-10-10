package com.SuperDriveCloudStorge.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/h2-console/**", "/signup", "/css/**", "/js/**")

                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
