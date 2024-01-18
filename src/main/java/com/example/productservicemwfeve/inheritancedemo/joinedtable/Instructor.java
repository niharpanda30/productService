package com.example.productservicemwfeve.inheritancedemo.joinedtable;

import lombok.Data;

@Data
public class Instructor extends User{
    private String favouriteStudent;
}
