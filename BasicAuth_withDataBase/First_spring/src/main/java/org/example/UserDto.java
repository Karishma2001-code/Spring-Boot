package org.example;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    private int id;
    @NotBlank(message = "Name is required")
    private String name;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
    @JsonIgnore
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private int age;
    private String role;
}
