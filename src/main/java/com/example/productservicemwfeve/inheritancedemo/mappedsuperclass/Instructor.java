package com.example.productservicemwfeve.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "ms_instructor")
public class Instructor extends User {
//    @Id
//    private Long id;
    private String favouriteStudent;
}
