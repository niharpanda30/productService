package com.example.productservicemwfeve.inheritancedemo.joinedtable;

import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import jakarta.persistence.Entity;

@Data
@Entity(name = "jt_instructor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User{

    private String favouriteStudent;
}
