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
@Table(name = "emails")   
@EntityListeners(AuditingEntityListener.class)
public class EmailEntity {
  
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
  
  @Column(name = "email_from", nullable = false)
  private String EmailFrom; 
  
  @Column(name = "email_to", nullable = false)
  private String EmailTo; 

  @Column(name = "email_subject", nullable = false)
  private String EmailSubject; 
    
  @Column(name = "email_text", nullable = false)
  private String EmailText; 

  @Column(name = "email_timestamp", nullable = false)
  private String EmailTimestamp;
  
  @Column(name = "email_status", nullable = false)
  private String EmailStatus;

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

public String getEmailFrom() {
	return EmailFrom;
}

public void setEmailFrom(String emailFrom) {
	EmailFrom = emailFrom;
}

public String getEmailTo() {
	return EmailTo;
}

public void setEmailTo(String emailTo) {
	EmailTo = emailTo;
}

public String getEmailSubject() {
	return EmailSubject;
}

public void setEmailSubject(String emailSubject) {
	EmailSubject = emailSubject;
}

public String getEmailText() {
	return EmailText;
}

public void setEmailText(String emailText) {
	EmailText = emailText;
}

public String getEmailTimestamp() {
	return EmailTimestamp;
}

public void setEmailTimestamp(String emailTimestamp) {
	EmailTimestamp = emailTimestamp;
}

public String getEmailStatus() {
	return EmailStatus;
}

public void setEmailStatus(String emailStatus) {
	EmailStatus = emailStatus;
}


  
  



}
