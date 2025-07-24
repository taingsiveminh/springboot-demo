package com.minh.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserReponseDto {
    @JsonProperty("user_id")
    private Long Id;
    @JsonProperty("username")
    private String name;
    private Integer age;
    @JsonProperty("location")
    private String address;
    private String email;
    private String role ="user";
}
