package com.example.productservicemwfeve.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tbc_mentor")
public class Mentor extends User {
    private double averageRating;
}
