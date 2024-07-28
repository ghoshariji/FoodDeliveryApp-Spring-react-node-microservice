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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import com.springServer.springServer.dbinterface.UserRepository;
import com.springServer.springServer.modal.Authorize;
import com.springServer.springServer.modal.UserModal;
import com.springServer.springServer.response.Response;
import com.springServer.springServer.utils.JwtAuth;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtAuth jwtAuth;

    @PostMapping("/register")
    public ResponseEntity<?> registeUser(@RequestBody UserModal user) {
        try {
            System.out.println(user);
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
            newUser.setAuthorize(Authorize.USER);
            userRepository.save(newUser);
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserModal post) {
        try {
            System.out.println(post);
            if (!userRepository.existsByEmail(post.getEmail())) {
                return new ResponseEntity<>("User Don't Exists", HttpStatus.BAD_REQUEST);
            }
            UserModal user = userRepository.findByEmail(post.getEmail());
            if (!bCryptPasswordEncoder.matches(post.getPassword(), user.getPassword())) {
                return new ResponseEntity<>("Pssword Don't matches", HttpStatus.OK);
            }
            String token = jwtAuth.generatetoken(user.getName());
            Response response = new Response(token, user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error" + e);
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

    @PostMapping("/validate-token")
    public ResponseEntity<?> validateToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        try {
            if (token == null || !token.startsWith("Bearer ")) {
                return new ResponseEntity<>("Authorization header missing or invalid", HttpStatus.BAD_REQUEST);
            }
            String newToken = token.substring(7);
            boolean isValid = jwtAuth.validateToken(newToken);
            if (isValid) {
                return new ResponseEntity<>("Token is valid", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Token is invalid", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }
}
