package com.example.xsis;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MovieEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String title;
    private String description;
    private float rating;
    private String image;

    private Date createdAt;
    private Date updatedAt;
}
