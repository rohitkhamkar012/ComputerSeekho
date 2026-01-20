package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.dto.LoginRequestDTO;
import com.example.dto.LoginResponseDTO;
import com.example.entity.StaffMaster;
import com.example.security.JwtUtil;
import com.example.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {

        // Authenticate user
        StaffMaster staff = authService.authenticate(
                request.getUsername(),
                request.getPassword()
        );

        // Generate JWT token
        String token = jwtUtil.generateToken(
                staff.getStaffUsername(),
                staff.getStaffRole()
        );

        // Return token in response
        return new LoginResponseDTO(
                token,
                staff.getStaffUsername(),
                staff.getStaffRole()
        );
    }
}
