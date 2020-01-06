package com.bae.universalapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * SecurityConfiguration
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    // @Bean
    // public BCryptPasswordEncoder bCryptPasswordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated()
            .and().formLogin()
            .loginPage("/signin.html")
            .defaultSuccessUrl("/")
            .permitAll();
        
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
        auth.userDetailsService(userDetailsService);
    }  
}

