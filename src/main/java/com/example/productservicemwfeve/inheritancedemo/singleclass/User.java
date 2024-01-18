package com.example.productservicemwfeve.inheritancedemo.singleclass;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "userType",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
