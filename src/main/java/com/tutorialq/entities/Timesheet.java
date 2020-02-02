package com.tutorialq.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Maintains Timesheet Information.
 */
@Data
@Entity
@EqualsAndHashCode(exclude = {"employee", "timesheetId"})
@NoArgsConstructor
@AllArgsConstructor
public class Timesheet extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TIMESHEET_ID", unique = true, nullable = false)
    private long timesheetId;
    private String timesheetType;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate fromDate;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate toDate;
    private String timesheetStatus;
    //Timesheet Information
    private double regularHours;
    private double extraHours;
    private String employeeName;
    private String clientName; //Employee Client Name while submitting the Timesheet.
    //File Upload Information
    @Transient
    private MultipartFile uploadFile; //Just to get the uploaded file.
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 1048576)
    private byte[] blobContent; //Byte stream of the file saved in the database.
    private String dscFileName;
    private long fileSize;
    private String dscComments;
    private String reviewerComments;
    /* Mapping*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Employee employee;
    //Audit Information
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime dateSubmitted;
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime dateApproved;
    private String nameCreated; //Name of the user Uploaded the timesheet.
    private String nameLastModified;
    private String nameApproved;
	public long getTimesheetId() {
		return timesheetId;
	}
	public void setTimesheetId(long timesheetId) {
		this.timesheetId = timesheetId;
	}
	public String getTimesheetType() {
		return timesheetType;
	}
	public void setTimesheetType(String timesheetType) {
		this.timesheetType = timesheetType;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getTimesheetStatus() {
		return timesheetStatus;
	}
	public void setTimesheetStatus(String timesheetStatus) {
		this.timesheetStatus = timesheetStatus;
	}
	public double getRegularHours() {
		return regularHours;
	}
	public void setRegularHours(double regularHours) {
		this.regularHours = regularHours;
	}
	public double getExtraHours() {
		return extraHours;
	}
	public void setExtraHours(double extraHours) {
		this.extraHours = extraHours;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public byte[] getBlobContent() {
		return blobContent;
	}
	public void setBlobContent(byte[] blobContent) {
		this.blobContent = blobContent;
	}
	public String getDscFileName() {
		return dscFileName;
	}
	public void setDscFileName(String dscFileName) {
		this.dscFileName = dscFileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getDscComments() {
		return dscComments;
	}
	public void setDscComments(String dscComments) {
		this.dscComments = dscComments;
	}
	public String getReviewerComments() {
		return reviewerComments;
	}
	public void setReviewerComments(String reviewerComments) {
		this.reviewerComments = reviewerComments;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public LocalDateTime getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(LocalDateTime dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public LocalDateTime getDateApproved() {
		return dateApproved;
	}
	public void setDateApproved(LocalDateTime dateApproved) {
		this.dateApproved = dateApproved;
	}
	public String getNameCreated() {
		return nameCreated;
	}
	public void setNameCreated(String nameCreated) {
		this.nameCreated = nameCreated;
	}
	public String getNameLastModified() {
		return nameLastModified;
	}
	public void setNameLastModified(String nameLastModified) {
		this.nameLastModified = nameLastModified;
	}
	public String getNameApproved() {
		return nameApproved;
	}
	public void setNameApproved(String nameApproved) {
		this.nameApproved = nameApproved;
	}

    
    
    
    
    
    
    
    
}
