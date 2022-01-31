package com.hackathon.grievanceCell.service;

import com.hackathon.grievanceCell.payload.request.SignupRequest;

public interface UserAuthService {

    Boolean saveUser(SignupRequest userRequest);
}
