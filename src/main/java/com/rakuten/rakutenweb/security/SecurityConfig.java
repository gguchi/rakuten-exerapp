package com.rakuten.rakutenweb.security;

import com.rakuten.rakutenweb.service.UserServices;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/userLogin")
//                .permitAll();
//
//                .authorizeRequests()
//                .antMatchers("/userLogin","/userRegister")
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/userLogin")
//                .permitAll();
    }
}
