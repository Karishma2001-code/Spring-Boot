package org.example;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    @Schema(description = "User ID", example = "1")

    private int id;
    @NotBlank(message = "Name is required")
    @Schema(description = "User's full name", example = "Alice")

    private String name;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Schema(description = "Email address", example = "alice@example.com")

    private String email;
    @JsonIgnore
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    @Schema(description = "Age of the user", example = "30")

    private int age;
    @Schema(description = "Role of the user", example = "ADMIN")

    private String role;
}
