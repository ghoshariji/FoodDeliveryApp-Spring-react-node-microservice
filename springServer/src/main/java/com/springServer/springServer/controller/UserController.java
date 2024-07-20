package com.springServer.springServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springServer.springServer.dbinterface.UserRepository;
import com.springServer.springServer.modal.UserModal;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registeUser(@RequestBody UserModal user) {
        try {
            if (userRepository.existsByEmail(user.getEmail())) {
                return new ResponseEntity<>("User Already Exists", HttpStatus.BAD_REQUEST);
            }
            if (user.getEmail().isEmpty() || user.getName().isEmpty() || user.getPassword().isEmpty()
                    || user.getPhone().isEmpty()) {
                return new ResponseEntity<>("All fields are required", HttpStatus.BAD_REQUEST);
            }
            UserModal newUser = new UserModal();
            newUser.setName(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            newUser.setPhone(user.getPhone());
            userRepository.save(newUser);
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserModal post) {
        try {
            if (!userRepository.existsByEmail(post.getEmail())) {
                return new ResponseEntity<>("User Don't Exists", HttpStatus.BAD_REQUEST);
            }
            UserModal user = userRepository.findByEmail(post.getEmail());
            if (!bCryptPasswordEncoder.matches(post.getPassword(), user.getPassword())) {
                return new ResponseEntity<>("Pssword Don't matches", HttpStatus.OK);
            }
            return new ResponseEntity<>("Login Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody UserModal post) {
        try {
            if (!userRepository.existsByEmail(post.getEmail())) {
                return new ResponseEntity<>("User Dont't Exists", HttpStatus.BAD_REQUEST);
            }
            UserModal user = userRepository.findByEmail(post.getEmail());
            user.setPassword(bCryptPasswordEncoder.encode(post.getPassword()));
            userRepository.save(user);
            return new ResponseEntity<>("Password Change Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-account")
    public ResponseEntity<?> deleteAccount(@RequestBody UserModal post) {
        try {
            if (!userRepository.existsByEmail(post.getEmail())) {
                return new ResponseEntity<>("User Dont't Exists", HttpStatus.BAD_REQUEST);
            }
            UserModal user = userRepository.findByEmail(post.getEmail());
            if (!bCryptPasswordEncoder.matches(post.getPassword(), user.getPassword())) {
                return new ResponseEntity<>("Enter the Valid Password", HttpStatus.OK);
            }
            userRepository.delete(user);
            return new ResponseEntity<>("Account Deleted Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }
}
