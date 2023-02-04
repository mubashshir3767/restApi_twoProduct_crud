package com.example.a.model.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LaptopRequestDto {
    @Size(min = 2,max = 10)
    private String name;
    private String brand;
    private double price;
    private int userId;
}
