package com.tutorialq.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImmigrationDetail extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOCUMENT_UPLOAD_ID", unique = true, nullable = false)
    private long immiDetailsId;
    private String currentStatus;
    private String receiptNumber;
    private String lcaNumber;
    private BigDecimal currentWage;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate endDate;
    private String dscComments;

    private String greenCardStatus;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate gcStartDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @JsonIgnore
    private Employee employee;

    //Audit Information
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDate dateApproved;
    private String nameCreated;
    private String nameLastModified;
    private String nameApproved;
	public long getImmiDetailsId() {
		return immiDetailsId;
	}
	public void setImmiDetailsId(long immiDetailsId) {
		this.immiDetailsId = immiDetailsId;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public String getLcaNumber() {
		return lcaNumber;
	}
	public void setLcaNumber(String lcaNumber) {
		this.lcaNumber = lcaNumber;
	}
	public BigDecimal getCurrentWage() {
		return currentWage;
	}
	public void setCurrentWage(BigDecimal currentWage) {
		this.currentWage = currentWage;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getDscComments() {
		return dscComments;
	}
	public void setDscComments(String dscComments) {
		this.dscComments = dscComments;
	}
	public String getGreenCardStatus() {
		return greenCardStatus;
	}
	public void setGreenCardStatus(String greenCardStatus) {
		this.greenCardStatus = greenCardStatus;
	}
	public LocalDate getGcStartDate() {
		return gcStartDate;
	}
	public void setGcStartDate(LocalDate gcStartDate) {
		this.gcStartDate = gcStartDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public LocalDate getDateApproved() {
		return dateApproved;
	}
	public void setDateApproved(LocalDate dateApproved) {
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
