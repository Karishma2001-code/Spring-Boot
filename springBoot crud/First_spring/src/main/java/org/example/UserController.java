package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @PostMapping("/create")
    public String requestBody(@RequestBody User u) {
        userRepo.save(u);
        return "user " + u.getName() + " created successfully";
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> pathVariable(@PathVariable int id) {

        return ResponseEntity.ok(userRepo.findById(id).orElse(null));
    }



    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String name) {
        List<User> users = userRepo.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMapping(@PathVariable int id) {
        return  userRepo.findById(id).map(existUser -> {
            userRepo.delete(existUser);
            return "user deleted successfulllllllly";
        }).orElse(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@RequestBody User user,@PathVariable int id) {
        return userRepo.findById(id).map(existUser -> {
            existUser.setName(user.getName());
            existUser.setEmail(user.getEmail());
            userRepo.save(existUser);
            return ResponseEntity.ok(existUser);
        }).orElse(null);

    }
        @GetMapping("/getAll")
        public List<User> geAllUser(){
            return userRepo.findAll();
        }

}
