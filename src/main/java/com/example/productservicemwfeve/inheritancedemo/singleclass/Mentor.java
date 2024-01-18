package com.example.productservicemwfeve.inheritancedemo.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue(value = "1")
public class Mentor extends User {
    private double averageRating;
}
