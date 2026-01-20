package com.example.controller;

import com.example.dto.BatchMasterDTO;
import com.example.service.BatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
@CrossOrigin(origins = "*")   // For React frontend
public class BatchController {

    @Autowired
    private BatchService batchService;

    // ================= CREATE BATCH =================
    // Admin Panel → Table Maintenance → Add Batch
    @PostMapping
    public ResponseEntity<BatchMasterDTO> createBatch(
            @RequestBody BatchMasterDTO dto) {

        BatchMasterDTO createdBatch = batchService.createBatch(dto);
        return ResponseEntity.ok(createdBatch);
    }

    // ================= UPDATE BATCH =================
    // Admin Panel → Edit Batch
    @PutMapping("/{batchId}")
    public ResponseEntity<BatchMasterDTO> updateBatch(
            @PathVariable Integer batchId,
            @RequestBody BatchMasterDTO dto) {

        BatchMasterDTO updatedBatch =
                batchService.updateBatch(batchId, dto);
        return ResponseEntity.ok(updatedBatch);
    }

    // ================= GET ALL ACTIVE BATCHES =================
    // Used for dropdowns, student registration
    @GetMapping("/active")
    public ResponseEntity<List<BatchMasterDTO>> getAllActiveBatches() {

        return ResponseEntity.ok(batchService.getAllActiveBatches());
    }

    // ================= GET BATCHES BY COURSE =================
    // Course → Batch dropdown
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<BatchMasterDTO>> getBatchesByCourse(
            @PathVariable Integer courseId) {

        return ResponseEntity.ok(
                batchService.getBatchesByCourse(courseId)
        );
    }

    // ================= DEACTIVATE BATCH =================
    // Soft delete (never hard delete)
    @PutMapping("/{batchId}/deactivate")
    public ResponseEntity<String> deactivateBatch(
            @PathVariable Integer batchId) {

        batchService.deactivateBatch(batchId);
        return ResponseEntity.ok("Batch deactivated successfully");
    }
}
