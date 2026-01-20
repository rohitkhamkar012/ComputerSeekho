package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.dto.StaffDTO;
import com.example.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping
    public StaffDTO create(@RequestBody StaffDTO dto) {
        return staffService.createStaff(dto);
    }

    @GetMapping
    public List<StaffDTO> getAll() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public StaffDTO getById(@PathVariable Integer id) {
        return staffService.getStaffById(id);
    }

    @PutMapping("/{id}")
    public StaffDTO update(@PathVariable Integer id, @RequestBody StaffDTO dto) {
        return staffService.updateStaff(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        staffService.deleteStaff(id);
    }
}
