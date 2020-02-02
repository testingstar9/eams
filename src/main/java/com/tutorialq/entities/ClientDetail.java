package com.tutorialq.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(exclude = {"employee", "clientDetailsId"})
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientDetail extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENT_DETAILS_ID", unique = true, nullable = false)
    private long clientDetailsId;
    private String clientName; //Name of the Client.
    private String clientStreet;
    private String clientCity;
    private String clientState;
    private String clientZip;
    private String contractCompany;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate contractStartDate;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate contractEndDate;
    //Vendor Contact Details
    private String vendorCompany;
    private String vendorContactName;
    private String vendorPhone;
    private String vendorEmail;
    private String paymentTerms;
    //Invoice Details
    private String invoiceContactName;
    private String invoiceContactPhone;
    private String invoiceContactEmail;
    private String invoiceFrequency;
    private String comments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @JsonIgnore
    private Employee employee;
    //Audit Information
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime dateApproved;
    private String nameCreated;
    private String nameLastModified;
    private String nameApproved;
    @Transient
    private String clientAddress;//Address of the Client.

    public String getClientAddress() {
        return (StringUtils.isNotBlank(this.clientStreet) ? (this.clientStreet + " ") : "")
                + (StringUtils.isNotBlank(this.clientCity) ? (this.clientCity + " ") : "")
                + (StringUtils.isNotBlank(this.clientState) ? (this.clientState + " ") : "")
                + (StringUtils.isNotBlank(this.clientZip) ? (this.clientZip + " ") : "");
    }

	public long getClientDetailsId() {
		return clientDetailsId;
	}

	public void setClientDetailsId(long clientDetailsId) {
		this.clientDetailsId = clientDetailsId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientStreet() {
		return clientStreet;
	}

	public void setClientStreet(String clientStreet) {
		this.clientStreet = clientStreet;
	}

	public String getClientCity() {
		return clientCity;
	}

	public void setClientCity(String clientCity) {
		this.clientCity = clientCity;
	}

	public String getClientState() {
		return clientState;
	}

	public void setClientState(String clientState) {
		this.clientState = clientState;
	}

	public String getClientZip() {
		return clientZip;
	}

	public void setClientZip(String clientZip) {
		this.clientZip = clientZip;
	}

	public String getContractCompany() {
		return contractCompany;
	}

	public void setContractCompany(String contractCompany) {
		this.contractCompany = contractCompany;
	}

	public LocalDate getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(LocalDate contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public LocalDate getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(LocalDate contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getVendorCompany() {
		return vendorCompany;
	}

	public void setVendorCompany(String vendorCompany) {
		this.vendorCompany = vendorCompany;
	}

	public String getVendorContactName() {
		return vendorContactName;
	}

	public void setVendorContactName(String vendorContactName) {
		this.vendorContactName = vendorContactName;
	}

	public String getVendorPhone() {
		return vendorPhone;
	}

	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public String getInvoiceContactName() {
		return invoiceContactName;
	}

	public void setInvoiceContactName(String invoiceContactName) {
		this.invoiceContactName = invoiceContactName;
	}

	public String getInvoiceContactPhone() {
		return invoiceContactPhone;
	}

	public void setInvoiceContactPhone(String invoiceContactPhone) {
		this.invoiceContactPhone = invoiceContactPhone;
	}

	public String getInvoiceContactEmail() {
		return invoiceContactEmail;
	}

	public void setInvoiceContactEmail(String invoiceContactEmail) {
		this.invoiceContactEmail = invoiceContactEmail;
	}

	public String getInvoiceFrequency() {
		return invoiceFrequency;
	}

	public void setInvoiceFrequency(String invoiceFrequency) {
		this.invoiceFrequency = invoiceFrequency;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
    
    
    

}
