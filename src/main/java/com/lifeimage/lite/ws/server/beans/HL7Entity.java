package com.lifeimage.lite.ws.server.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "hl7")   
@EntityListeners(AuditingEntityListener.class)
public class HL7Entity {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long Id;    
	  
	  @Column(name = "instance_uid", nullable = true)
	  private String InstanceUid;  // property in default.json "username": "donotreply+alexdev1agent20200612085329@lifeimage.com"
	
	  @Column(name = "organization_code", nullable = true)
	  private String OrganizationCode;  // property in default.json
	  
	  @Column(name = "service_name", nullable = true)
	  private String ServiceName;  // property in default.json
	  
	  @Column(name = "connection_name", nullable = false)
	  private String ConnectionName; // property in default.json
	  
	  @Column(name = "patient_mrn", nullable = false)
	  private String PatientMrn;  
	  
	  @Column(name = "accession_number", nullable = false)
	  private String AccessionNumber; 
	  
	  @Column(name = "hl7_status", nullable = false)
	  private String Hl7Status;    

	  
	  @Column(name = "error_code", nullable = true)
	  private String ErrorCode;    

	  @Column(name = "error_message", nullable = true)
	  private String ErrorMessage;
	  
	  @Column(name = "hl7_timestamp", nullable = false)
	  private String Hl7Timestamp;
	  
	  @Column(name = "retry_attempt", nullable = true)
	  private int RetryAttempt;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getInstanceUid() {
		return InstanceUid;
	}

	public void setInstanceUid(String instanceUid) {
		InstanceUid = instanceUid;
	}

	public String getOrganizationCode() {
		return OrganizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		OrganizationCode = organizationCode;
	}

	public String getServiceName() {
		return ServiceName;
	}

	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}

	public String getConnectionName() {
		return ConnectionName;
	}

	public void setConnectionName(String connectionName) {
		ConnectionName = connectionName;
	}

	public String getPatientMrn() {
		return PatientMrn;
	}

	public void setPatientMrn(String patientMrn) {
		PatientMrn = patientMrn;
	}

	public String getAccessionNumber() {
		return AccessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		AccessionNumber = accessionNumber;
	}

	public String getHl7Status() {
		return Hl7Status;
	}

	public void setHl7Status(String hl7Status) {
		Hl7Status = hl7Status;
	}

	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public String getHl7Timestamp() {
		return Hl7Timestamp;
	}

	public void setHl7Timestamp(String hl7Timestamp) {
		Hl7Timestamp = hl7Timestamp;
	}

	public int getRetryAttempt() {
		return RetryAttempt;
	}

	public void setRetryAttempt(int retryAttempt) {
		RetryAttempt = retryAttempt;
	}

	
	

	
	
	
}
