package com.bbarros.protobuff;

import lombok.Data;

@Data
public class PersonRequest {
    private String name;
    private int age;
    private String email;
}
