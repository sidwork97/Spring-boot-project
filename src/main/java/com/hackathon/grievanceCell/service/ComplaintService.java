package com.hackathon.grievanceCell.service;

import com.hackathon.grievanceCell.models.Complaint;
import com.hackathon.grievanceCell.payload.request.ComplaintRequest;

import java.util.List;

public interface ComplaintService {
    Complaint complaintSave(ComplaintRequest complaintRequest);
    List<Complaint> getIssue();
}
