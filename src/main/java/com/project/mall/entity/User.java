package com.project.mall.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userid;
    @Column(name = "username")
    String username;
    @Column(name="userbirthday")
    String userbirthday;
    @Column(name = "userapprance")
    String userapprance;
    @Column(name = "password")
    String password;
    @Column(name = "shoppingcart")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserbirthday() {
        return userbirthday;
    }

    public void setUserbirthday(String userbirthday) {
        this.userbirthday = userbirthday;
    }

    public String getUserapprance() {
        return userapprance;
    }

    public void setUserapprance(String userapprance) {
        this.userapprance = userapprance;
    }
}
