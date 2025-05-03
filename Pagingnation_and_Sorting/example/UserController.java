package org.example;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Page;


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
    public ResponseEntity<org.example.ApiResponses<User>>createUser(@Valid  @RequestBody User user) {
       User savedUser= userService.createUser(user);
        return ResponseEntity.ok(new org.example.ApiResponses(true, "User created : ", savedUser));

    }

    @GetMapping("/admin/{id}")
    @Parameter(name = "id", description = "User ID", required = true)

    public ResponseEntity<org.example.ApiResponses<UserDto>> getUserById(@PathVariable  @Min(1) int id) {
        User user=userService.getUserById(id);
        UserDto userDto=modelMapper.map(user,UserDto.class);
        return ResponseEntity.ok(new org.example.ApiResponses<>(true,"user Found",userDto));
    }

    @GetMapping("/admin/search")
    public ResponseEntity<org.example.ApiResponses<List<UserDto>>> searchUsers(@RequestParam String name) {
       List<User> users=userService.searchUsers(name);
       List<UserDto> userDtos =users.stream().map(user-> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok(new org.example.ApiResponses<>(true,"User Found",userDtos));
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<org.example.ApiResponses<UserDto>> deleteMapping(@PathVariable int id) {
        User user=userService.deleteMapping(id);
        UserDto userDto=modelMapper.map(user,UserDto.class);
        return ResponseEntity.ok(new org.example.ApiResponses<>(true,"user deleted :",userDto));
    }

    @PutMapping("/admin/update/{id}")
    public ResponseEntity<org.example.ApiResponses<UserDto>> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable int id) {
        User updatedUser = userService.update(userDto, id).getBody();
        UserDto responseDto = modelMapper.map(updatedUser, UserDto.class);
        return ResponseEntity.ok(new org.example.ApiResponses<>(true,"user Updated : ",responseDto));
    }
    @GetMapping("/admin/getAll")
    public ResponseEntity<org.example.ApiResponses<PageResponse<User>>> getAllUsers(
            @RequestParam(defaultValue = "0") int page, // First page by default
            @RequestParam(defaultValue = "2") int size, // 2 users per page
            @RequestParam(defaultValue = "id") String sortBy, // Sort by 'id' by default
            @RequestParam(defaultValue = "asc") String sortDir) { // Ascending order by default

        // Get paginated and sorted users from the service
        Page<User> users = userService.getAllUser(page, size, sortBy, sortDir);

        // Create PageResponse using the Page object
        PageResponse<User> pagedResponse = new PageResponse<>(users);

        // Wrap the response in a CustomApiResponse
        org.example.ApiResponses<PageResponse<User>> response = new org.example.ApiResponses<>(true, "Fetched users", pagedResponse);

        return ResponseEntity.ok(response); // Return OK response with the CustomApiResponse
    }
}
