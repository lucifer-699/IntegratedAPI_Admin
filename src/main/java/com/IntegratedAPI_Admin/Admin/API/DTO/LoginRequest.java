package com.IntegratedAPI_Admin.Admin.API.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String userId;
    private String username;
    private String password;
}