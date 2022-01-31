package com.hackathon.grievanceCell.controllers;

import com.hackathon.grievanceCell.payload.request.ComplaintRequest;
import com.hackathon.grievanceCell.payload.response.MessageResponse;
import com.hackathon.grievanceCell.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ComplaintController {

	@Autowired
	ComplaintService complaintService;



	@PostMapping("/addComplaint")
	//@PreAuthorize("hasRole('USER') or hasRole('EMPLOYEE')")
	public ResponseEntity<?> complaintAdded(@Valid @RequestBody ComplaintRequest complaintRequest) {
        complaintService.complaintSave(complaintRequest);
		return ResponseEntity.ok(new MessageResponse("Complaint registered successfully!"));

	}
	@GetMapping("/getAll")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllComplaints() {
		return ResponseEntity.ok(complaintService.getIssue());

	}
}
