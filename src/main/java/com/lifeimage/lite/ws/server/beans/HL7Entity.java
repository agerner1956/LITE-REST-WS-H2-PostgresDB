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
	  private long id;    
	  
	  @Column(name = "instance_uid", nullable = true)
	  private String instanceUid;  // property in default.json "username": "donotreply+alexdev1agent20200612085329@lifeimage.com"
	
	  @Column(name = "organization_code", nullable = true)
	  private String organizationCode;  // property in default.json
	  
	  @Column(name = "service_name", nullable = true)
	  private String serviceName;  // property in default.json
	  
	  @Column(name = "connection_name", nullable = false)
	  private String connectionName; // property in default.json
	  
	  @Column(name = "patient_mrn", nullable = false)
	  private String patientMrn;  
	  
	  @Column(name = "accession_number", nullable = false)
	  private String accessionNumber; 
	  
	  @Column(name = "hl7_status", nullable = false)
	  private String hl7Status;    

	  
	  @Column(name = "error_code", nullable = true)
	  private String errorCode;    

	  @Column(name = "error_message", nullable = true)
	  private String errorMessage;
	  
	  @Column(name = "hl7_timestamp", nullable = false)
	  private String hl7Timestamp;
	  
	  @Column(name = "retry_attempt", nullable = true)
	  private int retryAttempt;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInstanceUid() {
		return instanceUid;
	}

	public void setInstanceUid(String instanceUid) {
		this.instanceUid = instanceUid;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public String getPatientMrn() {
		return patientMrn;
	}

	public void setPatientMrn(String patientMrn) {
		this.patientMrn = patientMrn;
	}

	public String getAccessionNumber() {
		return accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public String getHl7Status() {
		return hl7Status;
	}

	public void setHl7Status(String hl7Status) {
		this.hl7Status = hl7Status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getHl7Timestamp() {
		return hl7Timestamp;
	}

	public void setHl7Timestamp(String hl7Timestamp) {
		this.hl7Timestamp = hl7Timestamp;
	}

	public int getRetryAttempt() {
		return retryAttempt;
	}

	public void setRetryAttempt(int retryAttempt) {
		this.retryAttempt = retryAttempt;
	}

	
	
	
}
