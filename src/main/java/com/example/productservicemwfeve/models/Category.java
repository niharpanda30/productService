package com.example.productservicemwfeve.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Category extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

//    public String getName() {
//        System.out.println( userName + " has called this method.");
//        System.out.println("nothi");
//    }
}

// categories
// name | base_model_id

// basemodels
// id | created_at | last_updated_at | is_deleted