package com.example.productservicemwfeve.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "ms_mentor")
public class Mentor extends User {
//    @Id
//    private Long id;
    private double averageRating;
}
