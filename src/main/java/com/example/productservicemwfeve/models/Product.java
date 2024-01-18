package com.example.productservicemwfeve.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    @Id
    private Long id;
    private String title;
    private double price;
    @ManyToOne
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
