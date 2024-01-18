package com.example.productservicemwfeve.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name="jt_mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User{
    private double averageRating;
}
