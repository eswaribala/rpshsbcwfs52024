package com.hsbc.hospitalmanagementapi.dtos;

import lombok.Data;

@Data
public class ResponseWrapper<T> {
    private T object;
    private String message;


    public ResponseWrapper(T object) {
        this.object = object;
    }

    public ResponseWrapper(String message) {
        this.message = message;
    }
}
