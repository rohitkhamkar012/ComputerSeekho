package com.example.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
    name = "enquiry",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "enquirer_email_id")
    }
)
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enquiry_id")
    private Integer enquiryId;

    @Column(name = "enquirer_name", length = 100)
    private String enquirerName;

    @Column(name = "enquirer_address", length = 300)
    private String enquirerAddress;

    @Column(name = "enquirer_mobile")
    private Long enquirerMobile;

    @Column(name = "enquirer_alternate_mobile")
    private Long enquirerAlternateMobile;

    @Column(name = "enquirer_email_id", length = 100, unique = true)
    private String enquirerEmailId;

    @Column(name = "enquiry_date")
    private LocalDate enquiryDate;

    @Column(name = "enquirer_query", length = 500)
    private String enquirerQuery;

    // ✅ Foreign Key Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "closure_reason_id")
    private ClosureReasonMaster closureReason;

    @Column(name = "enquiry_processed_flag", columnDefinition = "TINYINT(1)")
    private Boolean enquiryProcessedFlag = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private CourseMaster course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", updatable = false)
    private StaffMaster staff;

    @Column(name = "student_name", length = 100)
    private String studentName;

    @Column(name = "inquiry_counter")
    private Integer inquiryCounter;

    @Column(name = "followup_date")
    private LocalDate followUpDate;

    // ===== Lifecycle Callback =====
    @PrePersist
    public void prePersist() {
        if (enquiryDate == null) {
            enquiryDate = LocalDate.now();
        }
        if (followUpDate == null) {
            followUpDate = enquiryDate.plusDays(3);
        }
        if (inquiryCounter == null) {
            inquiryCounter = 1;
        }
    }

    // ===== Getters & Setters =====

    public Integer getEnquiryId() { return enquiryId; }
    public void setEnquiryId(Integer enquiryId) { this.enquiryId = enquiryId; }

    public String getEnquirerName() { return enquirerName; }
    public void setEnquirerName(String enquirerName) { this.enquirerName = enquirerName; }

    public String getEnquirerAddress() { return enquirerAddress; }
    public void setEnquirerAddress(String enquirerAddress) { this.enquirerAddress = enquirerAddress; }

    public Long getEnquirerMobile() { return enquirerMobile; }
    public void setEnquirerMobile(Long enquirerMobile) { this.enquirerMobile = enquirerMobile; }

    public Long getEnquirerAlternateMobile() { return enquirerAlternateMobile; }
    public void setEnquirerAlternateMobile(Long enquirerAlternateMobile) { this.enquirerAlternateMobile = enquirerAlternateMobile; }

    public String getEnquirerEmailId() { return enquirerEmailId; }
    public void setEnquirerEmailId(String enquirerEmailId) { this.enquirerEmailId = enquirerEmailId; }

    public LocalDate getEnquiryDate() { return enquiryDate; }
    public void setEnquiryDate(LocalDate enquiryDate) { this.enquiryDate = enquiryDate; }

    public String getEnquirerQuery() { return enquirerQuery; }
    public void setEnquirerQuery(String enquirerQuery) { this.enquirerQuery = enquirerQuery; }

    public ClosureReasonMaster getClosureReason() { return closureReason; }
    public void setClosureReason(ClosureReasonMaster closureReason) { this.closureReason = closureReason; }

    public Boolean getEnquiryProcessedFlag() { return enquiryProcessedFlag; }
    public void setEnquiryProcessedFlag(Boolean enquiryProcessedFlag) { this.enquiryProcessedFlag = enquiryProcessedFlag; }

    public CourseMaster getCourse() { return course; }
    public void setCourse(CourseMaster course) { this.course = course; }

    public StaffMaster getStaff() { return staff; }
    public void setStaff(StaffMaster staff) { this.staff = staff; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public Integer getInquiryCounter() { return inquiryCounter; }
    public void setInquiryCounter(Integer inquiryCounter) { this.inquiryCounter = inquiryCounter; }

    public LocalDate getFollowUpDate() { return followUpDate; }
    public void setFollowUpDate(LocalDate followUpDate) { this.followUpDate = followUpDate; }
}
