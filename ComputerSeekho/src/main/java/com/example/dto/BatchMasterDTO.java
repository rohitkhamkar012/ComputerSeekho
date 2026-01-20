package com.example.dto;

import java.time.LocalDate;

public class BatchMasterDTO {

    // ===== Identifiers =====
    private Integer batchId;     // null during create
    private Integer courseId;    // mandatory for create
    private String courseName;   // response-only (ignore in request)

    // ===== Batch Details =====
    private String batchName;
    private String batchStartTime;   // "09:00"
    private String batchEndTime;     // "12:00"

    // ===== Fee Details =====
    private Integer courseFees;
    private LocalDate courseFeesFrom;
    private LocalDate courseFeesTo;

    // ===== Status =====
    private Boolean batchIsActive;   // response-only (default true)

    // ===== Getters & Setters =====

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchStartTime() {
        return batchStartTime;
    }

    public void setBatchStartTime(String batchStartTime) {
        this.batchStartTime = batchStartTime;
    }

    public String getBatchEndTime() {
        return batchEndTime;
    }

    public void setBatchEndTime(String batchEndTime) {
        this.batchEndTime = batchEndTime;
    }

    public Integer getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(Integer courseFees) {
        this.courseFees = courseFees;
    }

    public LocalDate getCourseFeesFrom() {
        return courseFeesFrom;
    }

    public void setCourseFeesFrom(LocalDate courseFeesFrom) {
        this.courseFeesFrom = courseFeesFrom;
    }

    public LocalDate getCourseFeesTo() {
        return courseFeesTo;
    }

    public void setCourseFeesTo(LocalDate courseFeesTo) {
        this.courseFeesTo = courseFeesTo;
    }

    public Boolean getBatchIsActive() {
        return batchIsActive;
    }

    public void setBatchIsActive(Boolean batchIsActive) {
        this.batchIsActive = batchIsActive;
    }
}
