package com.project.mall.service;


import com.project.mall.entity.User;
import com.project.mall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
   UserService userService;
    @Autowired
    HttpServletRequest httpServletRequest;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.fingByName(username);
        String role="ROLE_login";
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        System.out.println(user.getUsername()+user.getPassword());
        authorities.add(new SimpleGrantedAuthority(role));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

}
