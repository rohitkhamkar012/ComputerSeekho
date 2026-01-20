package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.StaffMaster;

@Repository
public interface StaffRepository extends JpaRepository<StaffMaster, Integer> {

    // Used during login
    Optional<StaffMaster> findByStaffUsername(String staffUsername);

    // Used to check duplicate username
    boolean existsByStaffUsername(String staffUsername);
}
