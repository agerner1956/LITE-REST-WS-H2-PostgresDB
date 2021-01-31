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
  private long Id;    
  
  @Column(name = "instance_uid", nullable = true)
  private String InstanceUid;  // property in default.json "username": "donotreply+alexdev1agent20200612085329@lifeimage.com"
  
  @Column(name = "organization_code", nullable = true)
  private String OrganizationCode;  // property in default.json
  
  @Column(name = "service_name", nullable = true)
  private String ServiceName;  // property in default.json
  
  @Column(name = "connection_name", nullable = false)
  private String ConnectionName; // property in default.json
  
  @Column(name = "trans_direction", nullable = false)
  private String TransDirection;
  
  @Column(name = "trans_size", nullable = false)
  private int TransSize;  
  
  @Column(name = "patient_mrn", nullable = false)
  private String PatientMrn;  
  
  @Column(name = "accession_number", nullable = false)
  private String AccessionNumber;  
  
  @Column(name = "study_uid", nullable = false)
  private String StudyUid;    

  @Column(name = "series_uid", nullable = false)
  private String SeriesUid;   
  
  
  @Column(name = "sop_uid", nullable = false)
  private String SopUid;
  
  @Column(name = "trans_status", nullable = false)
  private String TransStatus;    

  
  @Column(name = "error_code", nullable = true)
  private String ErrorCode;    

  @Column(name = "error_message", nullable = true)
  private String ErrorMessage;
  
  @Column(name = "trans_started", nullable = false)
  private String TransStarted;

  @Column(name = "trans_finished", nullable = true)
  private String TransFinished;
  
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

public String getTransDirection() {
	return TransDirection;
}

public void setTransDirection(String transDirection) {
	TransDirection = transDirection;
}

public int getTransSize() {
	return TransSize;
}

public void setTransSize(int transSize) {
	TransSize = transSize;
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

public String getStudyUid() {
	return StudyUid;
}

public void setStudyUid(String studyUid) {
	StudyUid = studyUid;
}

public String getSeriesUid() {
	return SeriesUid;
}

public void setSeriesUid(String seriesUid) {
	SeriesUid = seriesUid;
}

public String getSopUid() {
	return SopUid;
}

public void setSopUid(String sopUid) {
	SopUid = sopUid;
}

public String getTransStatus() {
	return TransStatus;
}

public void setTransStatus(String transStatus) {
	TransStatus = transStatus;
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

public String getTransStarted() {
	return TransStarted;
}

public void setTransStarted(String transStarted) {
	TransStarted = transStarted;
}

public String getTransFinished() {
	return TransFinished;
}

public void setTransFinished(String transFinished) {
	TransFinished = transFinished;
}

public int getRetryAttempt() {
	return RetryAttempt;
}

public void setRetryAttempt(int retryAttempt) {
	RetryAttempt = retryAttempt;
}





}
