package com.project.mall.service;

import com.project.mall.entity.User;
import com.project.mall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User getOneById(int id){
       return userRepository.findByUserid(id);
    }
    public void insertUser(User user){
        userRepository.save(user);
    }
    public User fingByName(String username){
        return userRepository.findByUsername(username);
    }
}
