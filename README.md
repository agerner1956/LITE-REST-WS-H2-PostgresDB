
# LITE-REST-WS-H2-PostgresDB
LITE Transactions Tracking Interface

o	Transactions/Studies Tracking, HL7 Tracking and Email REST WS (to be implemented).
•	REST WS Server (CLOUD Layer): Java 11, Spring Boot, Connection Pool Manager: Hibernate, DBMS: Postgres. 
•	REST WS Observer Client (LITE Layer):  C#

Implementation of the above- mentioned interfaces includes but not limited to the following methods:

	GetToken (Generates Bearer session token for the LITE user authenticated by the CLOUD API - tokenExpirationInterval = 3600000 - 1 hour)
-	POST localhost:8080/user
-	X-www-form-urlencoded
-	Body - JSON
o	User (default.json)
o	Password  (default.json) – encrypted.


	NewTransaction (Inserts new transaction/study record in transactions table, initiating unique id. Algorithm includes verification of the duplicate transactions vs transactions table in LITE DB. If within duplicatesEliminateInterval = 600000; // 10 minutes a successful transaction, matching basic parameters of this transaction, was found, the response includes the following error code   - ERROR_00051101 = "DICOM/DCMTK inbound duplicate record" or similar)
-	Bearer Token
-	Input Paremeters: String instanceUid, String connectionName, String patientMrn, String accessionNumber,	String studyUid, String seriesUid, String sopUid
-	Output Paremeters: (new Transaction Object) 
