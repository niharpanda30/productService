package com.example.productservicemwfeve.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tbc_instructor")
public class Instructor extends User {
    private String favouriteStudent;
}
