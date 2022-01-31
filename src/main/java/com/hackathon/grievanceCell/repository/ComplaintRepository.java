package com.hackathon.grievanceCell.repository;

import com.hackathon.grievanceCell.models.Complaint;
import com.hackathon.grievanceCell.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
