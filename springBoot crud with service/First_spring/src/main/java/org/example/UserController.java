package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public String createUser(@RequestBody User u) {
       return userService.createUser(u);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
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
    public ResponseEntity<User> update(@RequestBody User user,@PathVariable int id) {
        return userService.update(user,id);
    }
        @GetMapping("/getAll")
        public List<User> geAllUser(){
            return userService.geAllUser();
        }

}
