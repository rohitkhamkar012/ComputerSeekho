package com.example.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.StaffDTO;
import com.example.entity.StaffMaster;
import com.example.repository.StaffRepository;
import com.example.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    private StaffDTO mapToDTO(StaffMaster staff) {
        StaffDTO dto = new StaffDTO();
        dto.setStaffId(staff.getStaffId());
        dto.setStaffName(staff.getStaffName());
        dto.setPhotoUrl(staff.getPhotoUrl());
        dto.setStaffMobile(staff.getStaffMobile());
        dto.setStaffEmail(staff.getStaffEmail());
        dto.setStaffUsername(staff.getStaffUsername());
        dto.setStaffRole(staff.getStaffRole());
        return dto;
    }

    private StaffMaster mapToEntity(StaffDTO dto) {
        StaffMaster staff = new StaffMaster();
        staff.setStaffName(dto.getStaffName());
        staff.setPhotoUrl(dto.getPhotoUrl());
        staff.setStaffMobile(dto.getStaffMobile());
        staff.setStaffEmail(dto.getStaffEmail());
        staff.setStaffUsername(dto.getStaffUsername());
        staff.setStaffRole(dto.getStaffRole());
        staff.setStaffPassword("default123"); // temp, bcrypt later
        return staff;
    }

    @Override
    public StaffDTO createStaff(StaffDTO dto) {
        StaffMaster staff = mapToEntity(dto);
        return mapToDTO(staffRepository.save(staff));
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        return staffRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StaffDTO getStaffById(Integer id) {
        StaffMaster staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        return mapToDTO(staff);
    }

    @Override
    public StaffDTO updateStaff(Integer id, StaffDTO dto) {
        StaffMaster staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        staff.setStaffName(dto.getStaffName());
        staff.setPhotoUrl(dto.getPhotoUrl());
        staff.setStaffMobile(dto.getStaffMobile());
        staff.setStaffEmail(dto.getStaffEmail());
        staff.setStaffRole(dto.getStaffRole());

        return mapToDTO(staffRepository.save(staff));
    }

    @Override
    public void deleteStaff(Integer id) {
        staffRepository.deleteById(id);
    }
}
