package com.jinu.jwt.dto.request;

import lombok.Data;

@Data
public class GenerateJwtTokenRequest {
private String username;
private String password;
}
