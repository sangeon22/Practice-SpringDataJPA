package com.example.bookmanager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test(){
        User user = new User();
        user.setEmail("adsad@naver.com");
        user.setName("dsdsd");
        System.out.println(">>>"+user);
    }
}