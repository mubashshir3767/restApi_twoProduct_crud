package com.example.a.controller;

import com.example.a.model.dto.request.LaptopRequestDto;
import com.example.a.model.dto.request.UserRequestDto;
import com.example.a.service.LaptopService;
import com.example.a.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/laptop")
public class LaptopController {
    private final LaptopService laptopService;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody LaptopRequestDto laptopRequestDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(laptopService.add(laptopRequestDto));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok(laptopService.getList());
    }

    @PutMapping("update")
    public ResponseEntity<?> update(
            @RequestParam int id,
            @RequestBody LaptopRequestDto laptopRequestDto
    ){
        return ResponseEntity.ok(laptopService.update(id,laptopRequestDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(
            @RequestParam int id
    ){
        return ResponseEntity.ok(laptopService.delete(id));
    }
}
