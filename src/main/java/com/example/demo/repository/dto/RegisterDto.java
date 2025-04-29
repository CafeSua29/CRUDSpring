package com.example.demo.repository.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    @NotEmpty(message = "Username is require")
    private String username;

    @NotEmpty(message = "Password is require")
    @Min(value = 8, message = "Password need at least 8 or more char")
    private String password;

    @NotEmpty(message = "Password is require")
    private String cfPassword;
}
