package com.example.a.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class LaptopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private double price;

    @ManyToOne
    @JsonIgnore
    private UserEntity userEntity;

    public LaptopEntity(String name, String brand, double price,UserEntity userEntity) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.userEntity = userEntity;
    }
}
