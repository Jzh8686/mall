package com.project.mall;

import com.project.mall.entity.User;
import com.project.mall.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {
@Autowired
    UserService userService;
    @Test
    public void contextLoads() {
        User user=new User();
        user.setUsername("wang");
        user.setPassword(new BCryptPasswordEncoder().encode("321"));
        userService.insertUser(user);
    }
    @Test
    public void testuser(){
        System.out.println(userService.fingByName("li").getPassword());
    }
}
