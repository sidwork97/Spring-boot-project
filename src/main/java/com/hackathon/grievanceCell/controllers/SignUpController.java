package com.hackathon.grievanceCell.controllers;

import com.hackathon.grievanceCell.payload.request.SignupRequest;
import com.hackathon.grievanceCell.payload.response.MessageResponse;
import com.hackathon.grievanceCell.security.services.AuthoritiesConstants;
import com.hackathon.grievanceCell.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SignUpController {

	@Autowired
	UserAuthService userAuthService;

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
			 return ResponseEntity.ok(userAuthService.saveUser(signUpRequest));
	}
}
