package com.example.dto;

public class StaffDTO {

    private Integer staffId;
    private String staffName;
    private String photoUrl;
    private Long staffMobile;
    private String staffEmail;
    private String staffUsername;
    private String staffRole;

    // getters & setters
    public Integer getStaffId() {
        return staffId;
    }
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    public Long getStaffMobile() {
        return staffMobile;
    }
    public void setStaffMobile(Long staffMobile) {
        this.staffMobile = staffMobile;
    }
    public String getStaffEmail() {
        return staffEmail;
    }
    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }
    public String getStaffUsername() {
        return staffUsername;
    }
    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }
    public String getStaffRole() {
        return staffRole;
    }
    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }
}
