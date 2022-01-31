package com.hackathon.grievanceCell.controllers;

import com.hackathon.grievanceCell.payload.request.LoginRequest;
import com.hackathon.grievanceCell.payload.response.JwtResponse;
import com.hackathon.grievanceCell.repository.RoleRepository;
import com.hackathon.grievanceCell.repository.UserRepository;
import com.hackathon.grievanceCell.security.jwt.JwtUtils;
import com.hackathon.grievanceCell.security.services.UserDetailsImpl;
import com.hackathon.grievanceCell.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    LoginService loginService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(loginService.result(loginRequest));
    }
}
