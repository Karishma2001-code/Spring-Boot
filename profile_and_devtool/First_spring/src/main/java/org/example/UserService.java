package org.example;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Profile("dev")
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User createUser( User u) {
        userRepo.save(u);
        return u;
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User Not found with :" + id));
    }

    public List<User> searchUsers(String name) {

        return userRepo.findByNameContainingIgnoreCase(name);
    }
    public User deleteMapping(int id) {
        return  userRepo.findById(id).map(existUser -> {
            userRepo.delete(existUser);
            return existUser;
        }).orElseThrow(()-> new ResourceNotFoundException("User Not found with :" + id));
    }
    public ResponseEntity<User> update(@Valid UserDto userDto, int id) {
        return userRepo.findById(id).map(existUser -> {
            existUser.setName(userDto.getName());
            existUser.setEmail(userDto.getEmail());
            existUser.setAge(userDto.getAge());
            userRepo.save(existUser);
            return ResponseEntity.ok(existUser);
        }).orElseThrow(()-> new ResourceNotFoundException("User Not found with :" + id));

    }
    public List<User> geAllUser(){
        return userRepo.findAll();
    }
}
