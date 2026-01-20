package com.example.dto;

import java.time.LocalDate;

public class StudentDTO {

    private Integer studentId;
    private String studentName;
    private String studentAddress;
    private String studentGender;
    private LocalDate studentDob;
    private String studentQualification;
    private Long studentMobile;
    private Integer courseFee;
    private Integer courseId;
    private Integer batchId;
    private String studentUsername;

    // ===== Getters & Setters =====
    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getStudentAddress() { return studentAddress; }
    public void setStudentAddress(String studentAddress) { this.studentAddress = studentAddress; }
    public String getStudentGender() { return studentGender; }
    public void setStudentGender(String studentGender) { this.studentGender = studentGender; }
    public LocalDate getStudentDob() { return studentDob; }
    public void setStudentDob(LocalDate studentDob) { this.studentDob = studentDob; }
    public String getStudentQualification() { return studentQualification; }
    public void setStudentQualification(String studentQualification) { this.studentQualification = studentQualification; }
    public Long getStudentMobile() { return studentMobile; }
    public void setStudentMobile(Long studentMobile) { this.studentMobile = studentMobile; }
    public Integer getCourseFee() { return courseFee; }
    public void setCourseFee(Integer courseFee) { this.courseFee = courseFee; }
    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
    public Integer getBatchId() { return batchId; }
    public void setBatchId(Integer batchId) { this.batchId = batchId; }
    public String getStudentUsername() { return studentUsername; }
    public void setStudentUsername(String studentUsername) { this.studentUsername = studentUsername; }
}
