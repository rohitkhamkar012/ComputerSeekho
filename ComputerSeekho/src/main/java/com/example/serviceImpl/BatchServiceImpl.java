package com.example.serviceImpl;

import com.example.dto.BatchMasterDTO;
import com.example.entity.BatchMaster;
import com.example.entity.CourseMaster;
import com.example.repository.BatchMasterRepository;
import com.example.repository.CourseMasterRepository;
import com.example.service.BatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchMasterRepository batchRepository;

    @Autowired
    private CourseMasterRepository courseRepository;

    // ================= CREATE BATCH =================
    @Override
    public BatchMasterDTO createBatch(BatchMasterDTO dto) {

        // 1️⃣ Validate Course
        CourseMaster course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Invalid Course ID"));

        // 2️⃣ Create Entity
        BatchMaster batch = new BatchMaster();
        batch.setBatchName(dto.getBatchName());
        batch.setBatchStartTime(LocalTime.parse(dto.getBatchStartTime()));
        batch.setBatchEndTime(LocalTime.parse(dto.getBatchEndTime()));
        batch.setCourse(course);
        batch.setCourseFees(dto.getCourseFees());
        batch.setCourseFeesFrom(dto.getCourseFeesFrom());
        batch.setCourseFeesTo(dto.getCourseFeesTo());

        // Force default values (DO NOT trust client)
        batch.setBatchIsActive(true);

        // 3️⃣ Save
        BatchMaster savedBatch = batchRepository.save(batch);

        // 4️⃣ Return DTO
        return mapToDTO(savedBatch);
    }

    // ================= UPDATE BATCH =================
    @Override
    public BatchMasterDTO updateBatch(Integer batchId, BatchMasterDTO dto) {

        BatchMaster batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        // Course change NOT allowed
        if (dto.getBatchName() != null)
            batch.setBatchName(dto.getBatchName());
        if(dto.getBatchIsActive()!=null)
        	batch.setBatchIsActive(dto.getBatchIsActive());

        if (dto.getBatchStartTime() != null)
            batch.setBatchStartTime(LocalTime.parse(dto.getBatchStartTime()));

        if (dto.getBatchEndTime() != null)
            batch.setBatchEndTime(LocalTime.parse(dto.getBatchEndTime()));

        if (dto.getCourseFees() != null)
            batch.setCourseFees(dto.getCourseFees());

        batch.setCourseFeesFrom(dto.getCourseFeesFrom());
        batch.setCourseFeesTo(dto.getCourseFeesTo());

        BatchMaster updatedBatch = batchRepository.save(batch);

        return mapToDTO(updatedBatch);
    }

    // ================= GET ACTIVE BATCHES =================
    @Override
    public List<BatchMasterDTO> getAllActiveBatches() {
        return batchRepository.findByBatchIsActiveTrue()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ================= GET BATCHES BY COURSE =================
    @Override
    public List<BatchMasterDTO> getBatchesByCourse(Integer courseId) {

        return batchRepository
                .findByCourse_CourseIdAndBatchIsActiveTrue(courseId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ================= DEACTIVATE BATCH (SOFT DELETE) =================
    @Override
    public void deactivateBatch(Integer batchId) {

        BatchMaster batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        batch.setBatchIsActive(false);
        batchRepository.save(batch);
    }

    // ================= MAPPER =================
    private BatchMasterDTO mapToDTO(BatchMaster batch) {

        BatchMasterDTO dto = new BatchMasterDTO();
        dto.setBatchId(batch.getBatchId());
        dto.setBatchIsActive(batch.getBatchIsActive());
        dto.setBatchName(batch.getBatchName());
        dto.setBatchStartTime(batch.getBatchStartTime().toString());
        dto.setBatchEndTime(batch.getBatchEndTime().toString());

        dto.setCourseId(batch.getCourse().getCourseId());
        dto.setCourseName(batch.getCourse().getCourseName());

        dto.setCourseFees(batch.getCourseFees());
        dto.setCourseFeesFrom(batch.getCourseFeesFrom());
        dto.setCourseFeesTo(batch.getCourseFeesTo());

        dto.setBatchIsActive(batch.getBatchIsActive());

        return dto;
    }
}
