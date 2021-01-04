package com.lifeimage.lite.ws.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lifeimage.lite.ws.server.beans.HL7Entity;

	public interface HL7Repository extends CrudRepository<HL7Entity, Long> {
		@Query(value = "SELECT hl7.id,hl7.instance_uid,hl7.organization_code,hl7.service_name," + 
			       "hl7.connection_name,hl7.patient_mrn, hl7.accession_number," + 
			       "hl7.hl7_status, hl7.error_code,hl7.error_message," + 
			       "hl7.hl7_timestamp,hl7.retry_attempt " + 
			       "FROM hl7 hl7 " + 
			       "where hl7.instance_uid = ?1 " + 
			       "and hl7.connection_name = ?2 " + 
			       "and hl7.patient_mrn = ?3 " + 
			       "and hl7.accession_number = ?4",
		        nativeQuery = true)
		List<HL7Entity> getHL7s(String instanceUid, String connectionName, String patientMrn, String accessionNumber);
		
		@Query(value = "SELECT hl7.id,hl7.instance_uid,hl7.organization_code,hl7.service_name," + 
			       "hl7.connection_name,hl7.patient_mrn, hl7.accession_number," + 
			       "hl7.hl7_status, hl7.error_code,hl7.error_message," + 
			       "hl7.hl7_timestamp,hl7.retry_attempt " + 
			       "FROM hl7 hl7 " + 
			       "where hl7.instance_uid = ?1 " + 
			       "and hl7.connection_name = ?2 " + 
			       "and hl7.patient_mrn = ?3 " + 
			       "and hl7.accession_number = ?4 " + 
			       "and hl7.hl7_status = ?5",
	             nativeQuery = true)
	    List<HL7Entity> getHL7sByStatus(String instanceUid, String connectionName, String patientMrn, String accessionNumber,  String hl7Status);
		
		
	}
  

