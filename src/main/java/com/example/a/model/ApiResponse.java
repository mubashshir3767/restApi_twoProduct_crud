package com.example.a.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    @JsonProperty("status_code")
    private int status_code;
    private String message;
    private Object data;

    public ApiResponse(int status_code, String message) {
        this.status_code = status_code;
        this.message = message;
    }

}
