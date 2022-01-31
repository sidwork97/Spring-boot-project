package com.hackathon.grievanceCell.service.Impl;

import com.hackathon.grievanceCell.models.Complaint;
import com.hackathon.grievanceCell.payload.request.ComplaintRequest;
import com.hackathon.grievanceCell.repository.ComplaintRepository;
import com.hackathon.grievanceCell.service.ComplaintService;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.support.SecurityWebApplicationContextUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;
    @Override
    public Complaint complaintSave(ComplaintRequest complaintRequest) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Complaint complaint =  new Complaint();
        complaint.setComplaintName(complaintRequest.getIssueName());
        complaint.setDescription(complaintRequest.getDescription());
        complaint.setImageUrl(complaintRequest.getImageUrl());
        complaint.setCreatedBy(((UserDetails)principal).getUsername());
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getIssue() {
        return complaintRepository.findAll();
    }
}
