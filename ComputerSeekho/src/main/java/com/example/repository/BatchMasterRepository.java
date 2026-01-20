package com.example.repository;

import com.example.entity.BatchMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchMasterRepository extends JpaRepository<BatchMaster, Integer> {

    // 1️⃣ Get all active batches
    List<BatchMaster> findByBatchIsActiveTrue();

    // 2️⃣ Get all batches for a given course (active only)
    List<BatchMaster> findByCourse_CourseIdAndBatchIsActiveTrue(Integer courseId);

    // 3️⃣ Get all batches for a given course (active + inactive)
    List<BatchMaster> findByCourse_CourseId(Integer courseId);
}
