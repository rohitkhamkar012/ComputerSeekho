package com.example.service;

import com.example.entity.StaffMaster;

public interface AuthService {

    // Used during login
    StaffMaster authenticate(String username, String password);

}
