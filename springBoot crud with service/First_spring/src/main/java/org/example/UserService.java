package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public String createUser( User u) {
        userRepo.save(u);
        return "user " + u.getName() + " created successfully";
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> searchUsers(String name) {
        return userRepo.findByNameContainingIgnoreCase(name);
    }
    public String deleteMapping(int id) {
        return  userRepo.findById(id).map(existUser -> {
            userRepo.delete(existUser);
            return "user deleted successfulllllllly";
        }).orElse(null);
    }
    public ResponseEntity<User> update(User user,int id) {
        return userRepo.findById(id).map(existUser -> {
            existUser.setName(user.getName());
            existUser.setEmail(user.getEmail());
            userRepo.save(existUser);
            return ResponseEntity.ok(existUser);
        }).orElse(null);

    }
    public List<User> geAllUser(){
        return userRepo.findAll();
    }
}
