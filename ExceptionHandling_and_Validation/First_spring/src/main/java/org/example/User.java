package org.example;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 @NotBlank(message = "name is required")
    private String name;
 @NotBlank(message = "email is required")
    private String email;
@Min(value = 18,message = "Age must be at least 18")
 private int age;

}

