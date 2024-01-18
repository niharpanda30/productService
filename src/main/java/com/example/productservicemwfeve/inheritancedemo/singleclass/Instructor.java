package com.example.productservicemwfeve.inheritancedemo.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue(value = "2")
public class Instructor extends User {
    private String favouriteStudent;
}
