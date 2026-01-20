package com.example.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.StaffMaster;
import com.example.repository.StaffRepository;
import com.example.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public StaffMaster authenticate(String username, String password) {

        // 1. Fetch staff by username
        StaffMaster staff = staffRepository
                .findByStaffUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid username"));

        // 2. Check password (PLAIN for now)
        if (!staff.getStaffPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        // 3. Authentication success
        return staff;
    } 
}
