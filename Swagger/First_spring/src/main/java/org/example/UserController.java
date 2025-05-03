package org.example;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Tag(name = "User Controller", description = "Handles user operations like create, update, delete, search")
@Validated
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/fail")
    public String failTest() {
        // This will cause a RuntimeException (Uncaught exception)
        throw new RuntimeException("Something broke!");
    }

    @Operation(summary = "Create a new user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Validation error")
    })
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid  @RequestBody User user) {
       User savedUser= userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/admin/{id}")
    @Parameter(name = "id", description = "User ID", required = true)

    public ResponseEntity<UserDto> getUserById(@PathVariable  @Min(1) int id) {
        User user=userService.getUserById(id);
        UserDto userDto=modelMapper.map(user,UserDto.class);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/admin/search")
    public ResponseEntity<List<UserDto>> searchUsers(@RequestParam String name) {
       List<User> users=userService.searchUsers(name);
       List<UserDto> userDtos =users.stream().map(user-> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<UserDto> deleteMapping(@PathVariable int id) {
        User user=userService.deleteMapping(id);
        UserDto userDto=modelMapper.map(user,UserDto.class);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/admin/update/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable int id) {
        User updatedUser = userService.update(userDto, id).getBody();
        UserDto responseDto = modelMapper.map(updatedUser, UserDto.class);
        return ResponseEntity.ok(responseDto);
    }
        @GetMapping("/admin/getAll")
        public ResponseEntity<List<UserDto>> geAllUser(){
            List<User> users= userService.geAllUser();;
            List<UserDto> userDtos = users.stream().map(user->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
            return ResponseEntity.ok(userDtos);
        }

}
