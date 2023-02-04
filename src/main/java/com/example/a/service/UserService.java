package com.example.a.service;

import com.example.a.entity.UserEntity;
import com.example.a.model.ApiResponse;
import com.example.a.model.ResponseMessage;
import com.example.a.model.dto.request.UserRequestDto;
import com.example.a.model.dto.response.UserResponseDto;
import com.example.a.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<UserRequestDto> {

    private final UserRepository userRepository;

    @Override
    public ApiResponse add(UserRequestDto userRequestDto) {
        Optional<UserEntity> userEntity = userRepository.findByPhoneNumber(userRequestDto.getPhoneNumber());

        if (userEntity.isPresent()) {
            return new ApiResponse(
                    ResponseMessage.ERROR_USER_ALREADY_EXIST.getStatus_code(),
                    ResponseMessage.ERROR_USER_ALREADY_EXIST.getMessage()
            );
        }
        userRepository.save(getUser(userRequestDto));

        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatus_code(),
                ResponseMessage.SUCCESS.getMessage()
        );
    }

    @Override
    public ApiResponse getList() {
        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatus_code(),
                ResponseMessage.SUCCESS.getMessage(),
                userRepository.findAll().stream().map((this::getUserDto)).toList()
        );
    }

    @Override
    public ApiResponse delete(int id) {
        userRepository.deleteById(id);
        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatus_code(),
                ResponseMessage.SUCCESS.getMessage()
        );
    }

    @Override
    public ApiResponse update(int id, UserRequestDto userRequestDto) {
        getUserEntity(id, userRequestDto);


        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatus_code(),
                ResponseMessage.SUCCESS.getMessage()
        );
    }

    private UserEntity getUserEntity(int id, UserRequestDto userRequestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(userEntity.getName());
        userEntity.setPassword(userEntity.getPassword());
        userEntity.setPhoneNumber(userEntity.getPhoneNumber());
        return userEntity;
    }


    private UserEntity getUser(UserRequestDto userRequestDto) {
        return new UserEntity(
                userRequestDto.getName(),
                userRequestDto.getPassword(),
                userRequestDto.getPhoneNumber()
        );
    }

    private UserResponseDto getUserDto(UserEntity userEntity) {
        return UserResponseDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .phoneNumber(userEntity.getPhoneNumber())
                .password(userEntity.getPassword())
                .laptopEntityList(userEntity.getLaptopEntityList())
                .build();
    }
}
