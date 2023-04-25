package com.example.demo.Service;

import com.example.demo.Helper.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtUtil jwtUtil;

    @Async
    public String generateToken(String name, String password) {
        return jwtUtil.generateToken(adminService.loadUserByUsername(name));
    }
}
