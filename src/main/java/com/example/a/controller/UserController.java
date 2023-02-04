package com.example.a.controller;

import com.example.a.model.ApiResponse;
import com.example.a.model.dto.request.UserRequestDto;
import com.example.a.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody UserRequestDto userRequestDto
            ){
       return ResponseEntity.status(HttpStatus.CREATED).body(userService.add(userRequestDto));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getList(){
      return ResponseEntity.ok(userService.getList());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(
            @RequestParam int id,
            @RequestBody UserRequestDto userRequestDto
    ){
        return ResponseEntity.ok(userService.update(id,userRequestDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(
            @RequestParam int id
    ){
        return ResponseEntity.ok(userService.delete(id));
    }

}
