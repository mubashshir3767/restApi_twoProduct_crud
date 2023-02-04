package com.example.a.service;

import com.example.a.entity.LaptopEntity;
import com.example.a.entity.UserEntity;
import com.example.a.model.ApiResponse;
import com.example.a.model.ResponseMessage;
import com.example.a.model.dto.request.LaptopRequestDto;
import com.example.a.model.dto.response.LaptopResponseDto;
import com.example.a.repository.LaptopRepository;
import com.example.a.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopService implements BaseService<LaptopRequestDto> {

    private final LaptopRepository laptopRepository;
    private final UserRepository userRepository;

    @Override
    public ApiResponse add(LaptopRequestDto laptopRequestDto) {
        UserEntity byId = userRepository.findById(laptopRequestDto.getUserId());

        if (byId == null) {
            return new ApiResponse(
                    ResponseMessage.ERROR_USER_NOT_FOUND.getStatus_code(),
                    ResponseMessage.ERROR_USER_NOT_FOUND.getMessage()
            );
        }

        laptopRepository.save(getLaptopEntity(byId, laptopRequestDto));

        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatus_code(),
                ResponseMessage.SUCCESS.getMessage()
        );
    }

    private LaptopEntity getLaptopEntity(UserEntity userEntity, LaptopRequestDto laptopRequestDto) {

        return new LaptopEntity(
                laptopRequestDto.getName(),
                laptopRequestDto.getBrand(),
                laptopRequestDto.getPrice(),
                userEntity
        );
    }

    @Override
    public ApiResponse getList() {
        List<LaptopResponseDto> laptopResponseDto = laptopRepository.findAll().stream().map((this::getLaptop)).toList();

        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatus_code(),
                ResponseMessage.SUCCESS.getMessage(),
                laptopResponseDto
        );
    }

    private LaptopResponseDto getLaptop(LaptopEntity laptopEntity) {
        return LaptopResponseDto.builder()
                .price(laptopEntity.getPrice())
                .id(laptopEntity.getId())
                .name(laptopEntity.getName())
                .brand(laptopEntity.getBrand())
                .userId(laptopEntity.getUserEntity()
                        .getId()).build();
    }

    @Override
    public ApiResponse delete(int id) {
        laptopRepository.deleteById(id);

        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatus_code(),
                ResponseMessage.SUCCESS.getMessage()
        );
    }


    @Override
    public ApiResponse update(int id, LaptopRequestDto laptopRequestDto) {
        laptopRepository.save(getLaptopUpdate(id, laptopRequestDto));

        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatus_code(),
                ResponseMessage.SUCCESS.getMessage()
        );
    }

    private LaptopEntity getLaptopUpdate(int id, LaptopRequestDto laptopRequestDto) {
        LaptopEntity laptopEntity = new LaptopEntity(
                laptopRequestDto.getName(),
                laptopRequestDto.getBrand(),
                laptopRequestDto.getPrice(),
                userRepository.findById(laptopRequestDto.getUserId())
        );
        laptopEntity.setId(id);
        return laptopEntity;
    }

}
