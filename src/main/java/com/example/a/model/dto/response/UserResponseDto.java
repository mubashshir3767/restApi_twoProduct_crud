package com.example.a.model.dto.response;

import com.example.a.entity.LaptopEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    private int id;
    private String name;
    private String phoneNumber;
    private String password;
    private List<LaptopEntity> laptopEntityList;
}
