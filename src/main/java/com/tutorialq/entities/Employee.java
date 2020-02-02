package com.tutorialq.entities;

import com.tutorialq.constants.ApplicationConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@ToString(exclude = {"empPassword", "empPassword2"})
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id", unique = true, nullable = false)
    private long employeeId; //Unique Id and the primary key for Employee table.
    @Column(unique = true, nullable = false)
    private String employeeEmailId; //Primary EmailId/User Name of the user.
    @Column(nullable = false)
    private String empPassword; //This will be stored as a Hash value.
    @Transient
    private String empPassword2; //Just a confirmation field used for validation. Not saved/updated.
    private String assignedEmployeeId; // assigned Identifier.
    @Column(nullable = false)
    private String employeeFirstName;
    @Column(nullable = false)
    private String employeeLastName;
    @Transient
    private String employeeFullName;
    private String employeeMiddleName;
    private String employeeTitle; //Description of the Employee Title.
    private Integer employeeRoleId; //Foreign Reference for Employee_Roles table.
    private String employeeRoleDesc;
    private String employeePhone;
    private String employeePhoneExt;
    private String skillSet;
    private String companyName;
    private String employmentType;
    private String referredBy;
    private Integer currentSalaryPerc;
    private Integer salaryDiscount;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate employmentStartDate;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate employeeStartDate; //Account Created Date.
    private String accountStatusFlag; //Flag to check if the account is ACTIVE or INACTIVE.
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateInactivated;
    private String nameUserInactivated; // Who inactivated this user

    public String getEmployeeFullName() {
        return (StringUtils.isNotBlank(this.employeeFirstName) ? this.employeeFirstName : "") +
                " " + (StringUtils.isNotBlank(this.employeeLastName) ? this.employeeLastName : "");
    }

    //Audit Information
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime dateApproved;
    private String nameCreated;
    private String nameLastModified;
    private String nameApproved;

    public boolean isEmployeeRole() {
        return this.employeeRoleId == ApplicationConstants.USER_ROLE_EMPLOYEE_ID;
    }

    public boolean isSupervisorRole() {
        return this.employeeRoleId == ApplicationConstants.USER_ROLE_SUPERVISOR_ID;
    }

    public boolean isAdminRole() {
        return this.employeeRoleId == ApplicationConstants.USER_ROLE_ADMIN_ID;
    }

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeEmailId() {
		return employeeEmailId;
	}

	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpPassword2() {
		return empPassword2;
	}

	public void setEmpPassword2(String empPassword2) {
		this.empPassword2 = empPassword2;
	}

	public String getAssignedEmployeeId() {
		return assignedEmployeeId;
	}

	public void setAssignedEmployeeId(String assignedEmployeeId) {
		this.assignedEmployeeId = assignedEmployeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeMiddleName() {
		return employeeMiddleName;
	}

	public void setEmployeeMiddleName(String employeeMiddleName) {
		this.employeeMiddleName = employeeMiddleName;
	}

	public String getEmployeeTitle() {
		return employeeTitle;
	}

	public void setEmployeeTitle(String employeeTitle) {
		this.employeeTitle = employeeTitle;
	}

	public Integer getEmployeeRoleId() {
		return employeeRoleId;
	}

	public void setEmployeeRoleId(Integer employeeRoleId) {
		this.employeeRoleId = employeeRoleId;
	}

	public String getEmployeeRoleDesc() {
		return employeeRoleDesc;
	}

	public void setEmployeeRoleDesc(String employeeRoleDesc) {
		this.employeeRoleDesc = employeeRoleDesc;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeePhoneExt() {
		return employeePhoneExt;
	}

	public void setEmployeePhoneExt(String employeePhoneExt) {
		this.employeePhoneExt = employeePhoneExt;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public Integer getCurrentSalaryPerc() {
		return currentSalaryPerc;
	}

	public void setCurrentSalaryPerc(Integer currentSalaryPerc) {
		this.currentSalaryPerc = currentSalaryPerc;
	}

	public Integer getSalaryDiscount() {
		return salaryDiscount;
	}

	public void setSalaryDiscount(Integer salaryDiscount) {
		this.salaryDiscount = salaryDiscount;
	}

	public LocalDate getEmploymentStartDate() {
		return employmentStartDate;
	}

	public void setEmploymentStartDate(LocalDate employmentStartDate) {
		this.employmentStartDate = employmentStartDate;
	}

	public LocalDate getEmployeeStartDate() {
		return employeeStartDate;
	}

	public void setEmployeeStartDate(LocalDate employeeStartDate) {
		this.employeeStartDate = employeeStartDate;
	}

	public String getAccountStatusFlag() {
		return accountStatusFlag;
	}

	public void setAccountStatusFlag(String accountStatusFlag) {
		this.accountStatusFlag = accountStatusFlag;
	}

	public LocalDate getDateInactivated() {
		return dateInactivated;
	}

	public void setDateInactivated(LocalDate dateInactivated) {
		this.dateInactivated = dateInactivated;
	}

	public String getNameUserInactivated() {
		return nameUserInactivated;
	}

	public void setNameUserInactivated(String nameUserInactivated) {
		this.nameUserInactivated = nameUserInactivated;
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

	public void setEmployeeFullName(String employeeFullName) {
		this.employeeFullName = employeeFullName;
	}
    
    
    

}
