package com.example.service;

import java.util.List;
import com.example.dto.StaffDTO;

public interface StaffService {

    StaffDTO createStaff(StaffDTO dto);

    List<StaffDTO> getAllStaff();

    StaffDTO getStaffById(Integer id);

    StaffDTO updateStaff(Integer id, StaffDTO dto);

    void deleteStaff(Integer id);
}
