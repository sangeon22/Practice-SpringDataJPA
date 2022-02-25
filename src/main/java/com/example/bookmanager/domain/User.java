package com.example.bookmanager.domain;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class User {
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



}
