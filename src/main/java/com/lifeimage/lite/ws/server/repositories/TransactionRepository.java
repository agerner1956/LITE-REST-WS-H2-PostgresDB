package com.lifeimage.lite.ws.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.lifeimage.lite.ws.server.beans.TransactionEntity;
import com.lifeimage.lite.ws.server.utils.Constants;

import org.springframework.stereotype.Repository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {
	@Query(value = "SELECT tr.id,tr.instance_uid,tr.organization_code,tr.service_name," + 
			       "tr.connection_name,tr.trans_direction,tr.trans_size,tr.patient_mrn," + 
			       "tr.accession_number, tr.study_uid,tr.series_uid,sop_uid," + 
			       "tr.trans_status, tr.error_code,tr.error_message," + 
			       "tr.trans_started, tr.trans_finished,tr.retry_attempt " + 
			       "FROM transactions tr " + 
			       "where tr.instance_uid = ?1 " + 
			       "and tr.connection_name = ?2 " + 
			       "and tr.patient_mrn = ?3 " + 
			       "and tr.accession_number = ?4 " + 
			       "and tr.study_uid = ?5 " + 
			       "and tr.series_uid = ?6 " + 
			       "and tr.sop_uid = ?7",
            nativeQuery = true)
	List<TransactionEntity> getTransactions(String instanceUid, String connectionName, String patientMrn, String accessionNumber,
			String studyUid, String seriesUid, String sopUid);
	
	@Query(value = "SELECT tr.id,tr.instance_uid,tr.organization_code,tr.service_name," + 
		       "tr.connection_name,tr.trans_direction,tr.trans_size,tr.patient_mrn," + 
		       "tr.accession_number, tr.study_uid,tr.series_uid,sop_uid," + 
		       "tr.trans_status, tr.error_code,tr.error_message," + 
		       "tr.trans_started, tr.trans_finished,tr.retry_attempt " + 
		       "FROM transactions tr " + 
		       "where tr.instance_uid = ?1 " + 
		       "and tr.connection_name = ?2 " + 
		       "and tr.patient_mrn = ?3 " + 
		       "and tr.accession_number = ?4 " + 
		       "and tr.study_uid = ?5 " + 
		       "and tr.series_uid = ?6 " + 
		       "and tr.sop_uid = ?7 " +
		       "and tr.trans_status = ?8",
             nativeQuery = true)
    List<TransactionEntity> getTransactionsByStatus(String instanceUid, String connectionName, String patientMrn, String accessionNumber,
		    String studyUid, String seriesUid, String sopUid, String transStatus);
	
	
}
