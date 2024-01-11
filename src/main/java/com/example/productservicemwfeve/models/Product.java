package com.example.productservicemwfeve.models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private double price;
    private Category category;
    private String description;
    private String imageUrl;
//    private int sachinQuestionsAsked;
}

//  1     ->     1
// Product : Category
//  m     <-     1
// --------------------
//   m      :    1
