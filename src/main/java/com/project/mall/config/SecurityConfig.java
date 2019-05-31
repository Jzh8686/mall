package com.project.mall.config;

import com.project.mall.repository.UserRepository;
import com.project.mall.service.CustomUserDetailsService;
import com.project.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }
    @Bean
    public UserDetailsService customUserDetail(){
        return new CustomUserDetailsService();

    }
    @Autowired
    SuccessHandler successHandler;
  /*  @Bean
    public SuccessHandler successHandler(){
        return new SuccessHandler();
    }*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/order","/register","/good/showcart","/collection").hasRole("login")
                .anyRequest().permitAll()
                .and().logout().logoutUrl("/mylogout").logoutSuccessUrl("/").permitAll();

        http.formLogin().loginPage("/mylogin").successHandler(successHandler).permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetail()).passwordEncoder(passwordEncoder());
    }

}
