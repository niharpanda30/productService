package com.example.productservicemwfeve.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    private Date createdAt;

    private Date lastUpdatedAt;

    private boolean isDeleted;

}