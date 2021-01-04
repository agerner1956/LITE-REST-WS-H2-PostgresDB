
# LITE-REST-WS-H2-PostgresDB 
LITE Transactions/HL7 Tracking Interface

Developer (Alexander Gerner)

- WS Server (CLOUD Layer): Java 11, Spring Boot 4-4.5.1, Connection Pool Manager: Hibernate, 1-4.199 DBMS: PostgreSQL 12. 
- WS Observer Client (LITE Layer):  C#

 PostgreSQL 12 Tables
-	transactions ==> Columns: id (identity), varchar  instance_uid, varchar organization_code, varchar service_name,varchar connection_name,
                         varchar trans_direction, integer trans_size, varchar patient_mrn, varchar accession_number, 
                         varchar study_uid, varchar series_uid, varchar sop_uid, varchar trans_status, varchar error_code, varchar error_message,
                         varchar trans_started, varchar trans_finished, integer retry_attempt

-	hl7s ==> Columns: id (identity), varchar  instance_uid, varchar organization_code, varchar service_name,varchar connection_name,
                         varchar patient_mrn, varchar accession_number, varchar hl7_status, varchar error_code, varchar error_message,
                         varchar hl7_timestamp, integer retry_attempt                       
                        
-	emails ==> Columns: id (identity), varchar  instance_uid, varchar organization_code, varchar service_name,varchar connection_name,
                 varchar email_from, varchar email_to, varchar email_subject, varchar email_text, varchar email_timestamp  


REST WS mplementation includes but not limited to the following methods:

	GetToken (Generates Bearer session token for the LITE user authenticated by the CLOUD API - tokenExpirationInterval = 3600000 - 1 hour)
-	POST localhost:8080/user
-	X-www-form-urlencoded
-	Body - JSON
-	Input Paremeters: 
o	User (default.json)
o	Password  (default.json) – encrypted.
-  Output Parameters: token (Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiZG9ub3RyZXBseSthbGV4ZGV2MWFnZW50MjAyMDA2MTIwODUzMjlAbGlmZWltYWdlLmNvbSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MDk3MjA2NTksImV4cCI6MTYwOTcyNDI1OX0.YW6dYfRpGjobrGsI4rr5nwFm98SQ21IIACGIGaXGf2zB6LYrQMKkjt1e4H7zottrnlsYK_TtwjNRACt2ENv9EQ )

	NewTransaction (Inserts new transaction/study record in transactions table, initiating unique id. Algorithm includes verification of the duplicate transactions vs transactions table. If within duplicatesEliminateInterval = 600000; // 10 minutes a successful transaction, matching basic parameters of this transaction, was found, the response includes the following error code   - ERROR_00051101 = "DICOM/DCMTK inbound duplicate record" or similar)
-	Bearer Token
-	POST localhost:8080/li/lite/ws/transaction
-	Input Paremeters:  Strng instanceUid, String organizationCode, String serviceName, String coonectionName, String transDirection, int transSize,
                     String patientMrn, String accessionNumber, String studyUid, String seriesUid, String sopUid, String transStatus (init), 
                     String errorCode, String errorMessage, String transStarted (null), String transFinished (null),
                     int retryAttemps (0)
-	Output Paremeters: long id, Strng instanceUid, String organizationCode, String serviceName, String coonectionName, String transDirection, int transSize,
                     String patientMrn, String accessionNumber, String studyUid, String seriesUid, String sopUid, 
                     String transStatus (init, success, failure, fatal),String errorCode, String errorMessage, 
                     String transStarted ("YYYY-MM-DD HH:mm:SS"), String transFinished ("YYYY-MM-DD HH:mm:SS"), int retryAttemps
                     
	updateTransaction (Updates transaction/study record in LITE transactions table passing unique id as an argument. If transaction fails transStatus=”failure”, errorCode and errorMessage to be provided in the body. If transaction failed after max number of the allowed retry attempts than transStatus=”fatal”. Number of the retry attempts is reported in retryAttempt parameter.)
- Token (see above)
- PUT localhost:8080/li/lite/ws/transaction/{id}
-	Input Paremeters:  Strng instanceUid, String organizationCode, String serviceName, String coonectionName, String transDirection, int transSize,
                     String patientMrn, String accessionNumber, String studyUid, String seriesUid, String sopUid, String transStatus (init), 
                     String errorCode, String errorMessage, String transStarted (null), String transFinished (null),
                     int retryAttemps (0)
-	Output Paremeters: long id, Strng instanceUid, String organizationCode, String serviceName, String coonectionName, String transDirection, int transSize,
                     String patientMrn, String accessionNumber, String studyUid, String seriesUid, String sopUid, 
                     String transStatus (init, success, failure, fatal),String errorCode, String errorMessage,
                     String transStarted ("YYYY-MM-DD HH:mm:SS"), String transFinished ("YYYY-MM-DD HH:mm:SS"),int retryAttemps
                     
	getTransactions (Retrieves list of the studies/transactions from transactions table, that match input parameters.)
- Token (see above)
- GET localhost:8080/li/lite/ws/transactions
-	Input Paremeters:  Strng instanceUid, String organizationCode, String serviceName, String coonectionName, String transDirection, int transSize,
                     String patientMrn, String accessionNumber, String studyUid, String seriesUid, String sopUid, String transStatus (init), 
                     String errorCode, String errorMessage, String transStarted (null), String transFinished (null),
                     int retryAttemps
-	Output Paremeters List of Objects:
                     long id, Strng instanceUid, String organizationCode, String serviceName, String coonectionName, String transDirection, int transSize,
                     String patientMrn, String accessionNumber, String studyUid, String seriesUid, String sopUid,
                     String transStatus (init, success, failure, fatal), String errorCode, String errorMessage, 
                     String transStarted ("YYYY-MM-DD HH:mm:SS"), String transFinished ("YYYY-MM-DD HH:mm:SS"),int retryAttemps                  
                     
	NewHL7 (Inserts new hl7 record in hl7 table, initiating unique id. Algorithm includes verification of the duplicate hl7 records vs hl7 table. If within duplicatesEliminateInterval = 600000; // 10 minutes a successful hl7 record, matching basic parameters of this record, was found, the response includes the following error code   - ERROR_00052101 = "HL7 inbound duplicate record" or similar)
-	Bearer Token
-	POST localhost:8080/li/lite/ws/hl7
-	Input Paremeters:  Strng instanceUid, String organizationCode, String serviceName, String coonectionName,
                     String patientMrn, String accessionNumber, String hl7Status (init), 
                     String errorCode, String errorMessage, String hl7Timestamp (null),int retryAttemps (0)
-	Output Paremeters: long id, Strng instanceUid, String organizationCode, String serviceName, String coonectionName,
                     String patientMrn, String accessionNumber, String hl7Status (init, success, failure, fatal), 
                     String errorCode, String errorMessage, String hl7Timestamp ("YYYY-MM-DD HH:mm:SS"), int retryAttemps
                     
 UpdateHL7 (Updates hl7 record in LITE hl7 table passing unique id as an argument. If operation fails hl7Status=”failure”, errorCode and errorMessage to be provided in the body. If operation failed after max number of the allowed retry attempts than hl7Status=”fatal”. Number of the retry attempts is reported in retryAttempt parameter.)
- Token (see above)
- PUT localhost:8080/li/lite/ws/hl7/{id}
-	Input Paremeters:  Strng instanceUid, String organizationCode, String serviceName, String coonectionName,
                     String patientMrn, String accessionNumber, String hl7Status (init), 
                     String errorCode, String errorMessage, String hl7Timestamp (null),int retryAttemps (0)
-	Output Paremeters: long id, Strng instanceUid, String organizationCode, String serviceName, String coonectionName,
                     String patientMrn, String accessionNumber, String hl7Status (init, success, failure, fatal), 
                     String errorCode, String errorMessage, String hl7Timestamp ("YYYY-MM-DD HH:mm:SS"), int retryAttemps
                     
	getTransactions (Retrieves list of the hl7 records from hl7 table, that match input parameters.)
- Token (see above)
- GET localhost:8080/li/lite/ws/hl7s
-	Input Paremeters:  Strng instanceUid, String organizationCode, String serviceName, String coonectionName,
                     String patientMrn, String accessionNumber, String hl7Status (init), 
                     String errorCode, String errorMessage, String hl7Timestamp (null),int retryAttemps (0)
  -	Output Paremeters List of Objects:
                     long id, Strng instanceUid, String organizationCode, String serviceName, String coonectionName,
                     String patientMrn, String accessionNumber, String hl7Status (init, success, failure, fatal), 
                     String errorCode, String errorMessage, String hl7Timestamp ("YYYY-MM-DD HH:mm:SS"), int retryAttemps             
                     
	sendEmail (Sends email to the recepient client and initiate correspondent record in email table.)
- Token (see above)
- GET localhost:8080/li/lite/ws/hl7s
-	Input Paremeters:  Strng instanceUid, String organizationCode, String serviceName, String coonectionName,
                     String emailTo, String emailSubject, String emailText, 
                     String emailTimestamp (null)
  -	Output Paremeters: "email is sent" or "email failed"                                  
                     
