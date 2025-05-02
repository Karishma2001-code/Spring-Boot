package org.example;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/fail")
    public String failTest() {
        // This will cause a RuntimeException (Uncaught exception)
        throw new RuntimeException("Something broke!");
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid  @RequestBody User u) {
       User savedUser= userService.createUser(u);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable  @Min(1) int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String name) {
        return userService.searchUsers(name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMapping(@PathVariable int id) {
        return  userService.deleteMapping(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@Valid @RequestBody User user,@PathVariable int id) {
        return userService.update(user,id);
    }
        @GetMapping("/getAll")
        public List<User> geAllUser(){
            return userService.geAllUser();
        }

}
