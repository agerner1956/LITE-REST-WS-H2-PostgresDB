package com.lifeimage.lite.ws.server.controllers;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lifeimage.lite.ws.server.beans.TransactionEntity;
import com.lifeimage.lite.ws.server.repositories.TransactionRepository;
import com.lifeimage.lite.ws.server.utils.Constants;
import com.lifeimage.lite.ws.server.utils.Misc;

@RestController
@RequestMapping("/li/lite/ws")

public class TransactionController {

	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	private TransactionRepository transactionRepository;
	   
	@GetMapping("/transactions")
	public List<TransactionEntity> getTransactions(@Valid @RequestBody TransactionEntity transaction) {
		List<TransactionEntity> transactions = transactionRepository.getTransactions(transaction.getInstanceUid(), transaction.getConnectionName(),transaction.getPatientMrn(),
				transaction.getAccessionNumber(), transaction.getStudyUid(), transaction.getSeriesUid(), transaction.getSopUid());
		return transactions;	}

	@GetMapping("/transaction/{id}")
	public ResponseEntity<TransactionEntity> getTransactionById(@PathVariable(value = "id") Long transId) throws Exception {

		TransactionEntity transaction = transactionRepository.findById(transId)
				.orElseThrow(() -> new Exception("Transaction " + transId + " not found"));
		return ResponseEntity.ok().body(transaction);
	}
	
	@PostMapping("/transaction")
	public TransactionEntity createTransaction(@Valid @RequestBody TransactionEntity transaction) {
		logger.debug("createTransaction" + Constants.messageStarted);
		List<TransactionEntity> transactions = transactionRepository.getTransactionsByStatus(transaction.getInstanceUid(), transaction.getConnectionName(),transaction.getPatientMrn(),
				transaction.getAccessionNumber(), transaction.getStudyUid(), transaction.getSeriesUid(), transaction.getSopUid(),Constants.statusSuccess);
		logger.info("transactions" + transactions.size());
		Misc misc = new Misc();
		String timestampNow=misc.getTimestamp();
		transaction.setTransStarted(timestampNow);
		if (transactions.size()>0) {
			long tsLast = 0;
		
			for (TransactionEntity trans : transactions) {
				Long ts=misc.convertTimestampToLong(trans.getTransStarted());
				if (ts>tsLast) tsLast=ts;
			}
			long tsNow = misc.convertTimestampToLong(timestampNow);
			
			if ((tsNow-tsLast)<=Constants.duplicatesEliminateInterval) {
		    	transaction.setTransFinished(timestampNow);
			   	transaction.setTransStatus(Constants.statusFailure);
			    transaction.setErrorCode("ERROR_00051101");
			    transaction.setErrorMessage(Constants.ERROR_00051101);
		   } 
		} else { 	
			transaction.setTransStatus(Constants.statusInit);
		}
		return transactionRepository.save(transaction);
		
	}

	@PutMapping("/transaction/{id}")
	public ResponseEntity<TransactionEntity> updateTransaction(@PathVariable(value = "id") Long transId,
			@Valid @RequestBody TransactionEntity transactionDetails) throws Exception {
		TransactionEntity transaction = transactionRepository.findById(transId)
				.orElseThrow(() -> new Exception("Transaction " + transId + " not found"));
		Misc misc = new Misc();
		transaction.setTransFinished(misc.getTimestamp());
		transaction.setTransStatus(transactionDetails.getTransStatus());
		if (transactionDetails.getTransStatus().equals(Constants.statusFailure)
				|| transactionDetails.getTransStatus().equals(Constants.statusFatal)) {
			transaction.setErrorCode(transactionDetails.getErrorCode());
			transaction.setErrorMessage(transactionDetails.getErrorMessage());
		}
		final TransactionEntity updatedTransaction = transactionRepository.save(transaction);
		return ResponseEntity.ok(updatedTransaction);
	}

	@DeleteMapping("/transaction/{id}")
	public Map<String, Boolean> deleteTransaction(@PathVariable(value = "id") Long transId) throws Exception {
		TransactionEntity transaction = transactionRepository.findById(transId)
				.orElseThrow(() -> new Exception("Transaction " + transId + " not found"));

		transactionRepository.delete(transaction);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	

}
