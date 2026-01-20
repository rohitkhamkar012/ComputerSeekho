package com.example.service;

import com.example.dto.BatchMasterDTO;
import java.util.List;

public interface BatchService {

    /**
     * Create a new batch for a course
     * Used in Admin Panel → Table Maintenance
     */
    BatchMasterDTO createBatch(BatchMasterDTO dto);

    /**
     * Update existing batch details
     * (timing, fees, active status etc.)
     */
    BatchMasterDTO updateBatch(Integer batchId, BatchMasterDTO dto);

    /**
     * Get all active batches
     * Used for dropdowns and student registration
     */
    List<BatchMasterDTO> getAllActiveBatches();

    /**
     * Get all batches of a specific course
     * Used in Course → Batch mapping
     */
    List<BatchMasterDTO> getBatchesByCourse(Integer courseId);

    /**
     * Soft delete (deactivate) a batch
     * NEVER hard delete batches
     */
    void deactivateBatch(Integer batchId);
}
