package com.example.demo.repository.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @NotEmpty(message = "Username is require")
    private String username;

    @NotEmpty(message = "Password is require")
    private String password;
}
