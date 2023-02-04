package com.example.a.service;

import com.example.a.model.ApiResponse;

public interface BaseService<T> {

    ApiResponse add(T t);
    ApiResponse getList();
    ApiResponse delete(int id);
    ApiResponse update(int id,T t);
}
