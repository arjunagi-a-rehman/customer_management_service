package com.example.Customer_Managment_service.controller;

import com.example.Customer_Managment_service.dto.UserDto;
import com.example.Customer_Managment_service.dto.UserLoginDto;
import com.example.Customer_Managment_service.sevice.JwtService;
import com.example.Customer_Managment_service.sevice.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v0/user",produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {
    @Autowired
    private UserServices userServices;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserDto userDto){
        userServices.registerUser(userDto);
        return new ResponseEntity<>("created user", HttpStatus.CREATED);
    }
    @GetMapping("/check/login")
    public ResponseEntity<String> checkLogin(){
        return ResponseEntity.ok("is logged in");
    }
    @PostMapping("/generate")
    public String authenticateAndGetToken(@RequestBody UserLoginDto authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getEmail());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}
