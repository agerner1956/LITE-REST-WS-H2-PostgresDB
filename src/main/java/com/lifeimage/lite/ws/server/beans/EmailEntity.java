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
  private long id;    
  
  @Column(name = "instance_uid", nullable = true)
  private String instanceUid;  // property in default.json "username": "donotreply+alexdev1agent20200612085329@lifeimage.com"
  
  @Column(name = "organization_code", nullable = true)
  private String organizationCode;  // property in default.json
  
  @Column(name = "service_name", nullable = true)
  private String serviceName;  // property in default.json
  
  @Column(name = "connection_name", nullable = false)
  private String connectionName; // property in default.json
  
  @Column(name = "email_from", nullable = false)
  private String emailFrom; 
  
  @Column(name = "email_to", nullable = false)
  private String emailTo; 

  @Column(name = "email_subject", nullable = false)
  private String emailSubject; 
    
  @Column(name = "email_text", nullable = false)
  private String emailText; 

  @Column(name = "email_timestamp", nullable = false)
  private String emailTimestamp;

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

public String getEmailTo() {
	return emailTo;
}

public void setEmailTo(String emailTo) {
	this.emailTo = emailTo;
}

public String getEmailFrom() {
	return emailFrom;
}

public void setEmailFrom(String emailFrom) {
	this.emailFrom = emailFrom;
}

public String getEmailSubject() {
	return emailSubject;
}

public void setEmailSubject(String emailSubject) {
	this.emailSubject = emailSubject;
}

public String getEmailText() {
	return emailText;
}

public void setEmailText(String emailText) {
	this.emailText = emailText;
}

public String getEmailTimestamp() {
	return emailTimestamp;
}

public void setEmailTimestamp(String emailTimestamp) {
	this.emailTimestamp = emailTimestamp;
} 
  
  



}
