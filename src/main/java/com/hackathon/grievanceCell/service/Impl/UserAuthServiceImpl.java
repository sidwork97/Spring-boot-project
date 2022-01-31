package com.hackathon.grievanceCell.service.Impl;

import com.hackathon.grievanceCell.models.ERole;
import com.hackathon.grievanceCell.models.Role;
import com.hackathon.grievanceCell.models.User;
import com.hackathon.grievanceCell.payload.request.SignupRequest;
import com.hackathon.grievanceCell.repository.RoleRepository;
import com.hackathon.grievanceCell.repository.UserRepository;
import com.hackathon.grievanceCell.security.jwt.JwtUtils;
import com.hackathon.grievanceCell.service.UserAuthService;
import com.hackathon.grievanceCell.service.exceptions.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserAuthServiceImpl implements UserAuthService {
    private final Logger log = LoggerFactory.getLogger(UserAuthServiceImpl.class);
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

    @Override
    public Boolean saveUser(SignupRequest userRequest) {

        if (userRepository.existsByUsername(userRequest.getUsername())) {
            log.debug("User already exist with email.");
            String message = "User already registered! with username:" + userRequest.getUsername();
            throw new RuntimeException(message);

        }

        if (userRepository.existsByEmail(userRequest.getEmail())) {
            log.debug("User already exist with email.");
            String message = "User already registered! with email:" + userRequest.getEmail();
            throw new RuntimeException(message);
        }

        // Create new user's account
        User user = new User(userRequest.getUsername(),
                userRequest.getEmail(),
                encoder.encode(userRequest.getPassword()),
                userRequest.getMobileNumber());

        Set<String> strRoles = userRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new BadRequestException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new BadRequestException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "employee":
                        Role modRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE)
                                .orElseThrow(() -> new BadRequestException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new BadRequestException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        User userSaved = userRepository.save(user);
        if(userSaved != null){
            user.setActive(true);
            return true;
        }
        return false;
    }
}
