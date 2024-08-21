package com.hsbc.hospitalmanagementapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}
