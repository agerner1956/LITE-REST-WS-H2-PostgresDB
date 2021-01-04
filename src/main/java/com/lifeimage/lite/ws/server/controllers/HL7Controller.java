package com.lifeimage.lite.ws.server.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lifeimage.lite.ws.server.beans.HL7Entity;
import com.lifeimage.lite.ws.server.beans.TransactionEntity;
import com.lifeimage.lite.ws.server.repositories.HL7Repository;
import com.lifeimage.lite.ws.server.utils.Constants;
import com.lifeimage.lite.ws.server.utils.Misc;

@RestController
@RequestMapping("/li/lite/ws")

public class HL7Controller {

	private static final Logger logger = LoggerFactory.getLogger(HL7Controller.class);

	@Autowired
	private HL7Repository hl7Repository;

	@GetMapping("/hl7s")
	public List<HL7Entity> getHL7s(@Valid @RequestBody HL7Entity hl7) {
		List<HL7Entity> hl7s = hl7Repository.getHL7s(hl7.getInstanceUid(), hl7.getConnectionName(), hl7.getPatientMrn(),
				hl7.getAccessionNumber());
		return hl7s;
	}

	@GetMapping("/hl7/{id}")
	public ResponseEntity<HL7Entity> getHL7ById(@PathVariable(value = "id") Long hl7Id) throws Exception {

		HL7Entity hL7 = hl7Repository.findById(hl7Id).orElseThrow(() -> new Exception("HL7 " + hl7Id + " not found"));
		return ResponseEntity.ok().body(hL7);
	}

	@PostMapping("/hl7")
  public HL7Entity createHL7(@Valid @RequestBody HL7Entity hl7) {
	  logger.debug("createHL7"+ Constants.messageStarted);
		List<HL7Entity> hl7s =  hl7Repository.getHL7sByStatus(hl7.getInstanceUid(), hl7.getConnectionName(), hl7.getPatientMrn(), hl7.getAccessionNumber(),Constants.statusSuccess);
		Misc misc = new Misc();
		String timestampNow=misc.getTimestamp();
		hl7.setHl7Timestamp(timestampNow);
		long tsLast = 0;
		
			for (HL7Entity hl7t : hl7s) {
				Long ts=misc.convertTimestampToLong(hl7t.getHl7Timestamp());
				if (ts>tsLast) tsLast=ts;
			}
			long tsNow = misc.convertTimestampToLong(timestampNow);
			if ((tsNow-tsLast)<=Constants.duplicatesEliminateInterval) {
		       	hl7.setHl7Status(Constants.statusFailure);
			    hl7.setErrorCode("ERROR_00052101");
			    hl7.setErrorMessage(Constants.ERROR_00052101);
		   } 
					
		  return hl7Repository.save(hl7);
		
	}

	@PutMapping("/hl7/{id}")
	public ResponseEntity<HL7Entity> updateHL7(@PathVariable(value = "id") Long hl7Id,
			@Valid @RequestBody HL7Entity hl7Details) throws Exception {

		HL7Entity hL7 = hl7Repository.findById(hl7Id).orElseThrow(() -> new Exception("HL7 " + hl7Id + " not found"));

		final HL7Entity updatedTransaction = hl7Repository.save(hL7);
		return ResponseEntity.ok(updatedTransaction);
	}

	@DeleteMapping("/hl7/{id}")
	public Map<String, Boolean> deleteHL7(@PathVariable(value = "id") Long hl7Id) throws Exception {
		HL7Entity hl7 = hl7Repository.findById(hl7Id).orElseThrow(() -> new Exception("HL7 " + hl7Id + " not found"));

		hl7Repository.delete(hl7);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
