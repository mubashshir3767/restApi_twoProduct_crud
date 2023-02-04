package com.example.a.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LaptopResponseDto {
    private int id;
    private String name;
    private String  brand;
    private double price;
    private int userId;
}
