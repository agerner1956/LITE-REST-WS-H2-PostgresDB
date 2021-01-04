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
@Table(name = "transactions")   
@EntityListeners(AuditingEntityListener.class)

public class TransactionEntity {
  
  /**
   * The attributes of the image transaction
   */
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
  
  @Column(name = "trans_direction", nullable = false)
  private String transDirection;
  
  @Column(name = "trans_size", nullable = false)
  private int transSize;  
  
  @Column(name = "patient_mrn", nullable = false)
  private String patientMrn;  
  
  @Column(name = "accession_number", nullable = false)
  private String accessionNumber;  
  
  @Column(name = "study_uid", nullable = false)
  private String studyUid;    

  @Column(name = "series_uid", nullable = false)
  private String seriesUid;   
  
  
  @Column(name = "sop_uid", nullable = false)
  private String sopUid;
  
  @Column(name = "trans_status", nullable = false)
  private String transStatus;    

  
  @Column(name = "error_code", nullable = true)
  private String errorCode;    

  @Column(name = "error_message", nullable = true)
  private String errorMessage;
  
  @Column(name = "trans_started", nullable = false)
  private String transStarted;

  @Column(name = "trans_finished", nullable = true)
  private String transFinished;
  
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

public String getTransDirection() {
	return transDirection;
}

public void setTransDirection(String transDirection) {
	this.transDirection = transDirection;
}

public int getTransSize() {
	return transSize;
}

public void setTransSize(int transSize) {
	this.transSize = transSize;
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

public String getStudyUid() {
	return studyUid;
}

public void setStudyUid(String studyUid) {
	this.studyUid = studyUid;
}

public String getSeriesUid() {
	return seriesUid;
}

public void setSeriesUid(String seriesUid) {
	this.seriesUid = seriesUid;
}

public String getSopUid() {
	return sopUid;
}

public void setSopUid(String sopUid) {
	this.sopUid = sopUid;
}

public String getTransStatus() {
	return transStatus;
}

public void setTransStatus(String transStatus) {
	this.transStatus = transStatus;
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

public String getTransStarted() {
	return transStarted;
}

public void setTransStarted(String transStarted) {
	this.transStarted = transStarted;
}

public String getTransFinished() {
	return transFinished;
}

public void setTransFinished(String transFinished) {
	this.transFinished = transFinished;
}

public int getRetryAttempt() {
	return retryAttempt;
}

public void setRetryAttempt(int retryAttempt) {
	this.retryAttempt = retryAttempt;
}


}
