package org.example;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Profile("dev")
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepo;

    public User createUser( User u) {
        logger.info("creating user : "+u.getName());
        userRepo.save(u);
        logger.info("created user "+u.getName()+" successfully");
        return u;
    }

    public User getUserById(int id) {
        logger.info("Fetching user with ID: {}", id);
        return userRepo.findById(id).orElseThrow(() -> {
            logger.error("User not found with ID: {}", id);
            return new ResourceNotFoundException("User not found with ID: " + id);
        });
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
