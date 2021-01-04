
# LITE-REST-WS-H2-PostgresDB 
LITE Transactions/HL7 Tracking Interface
Developer (Alexander Gerner)

- WS Server (CLOUD Layer): Java 11, Spring Boot, Connection Pool Manager: Hibernate, DBMS: Postgres. 
- WS Observer Client (LITE Layer):  C#

Implementation of the above- mentioned interfaces includes but not limited to the following methods:

	GetToken (Generates Bearer session token for the LITE user authenticated by the CLOUD API - tokenExpirationInterval = 3600000 - 1 hour)
-	POST localhost:8080/user
-	X-www-form-urlencoded
-	Body - JSON
-	Input Paremeters: 
o	User (default.json)
o	Password  (default.json) – encrypted.
-  Output Parameters: token (Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiZG9ub3RyZXBseSthbGV4ZGV2MWFnZW50MjAyMDA2MTIwODUzMjlAbGlmZWltYWdlLmNvbSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MDk3MjA2NTksImV4cCI6MTYwOTcyNDI1OX0.YW6dYfRpGjobrGsI4rr5nwFm98SQ21IIACGIGaXGf2zB6LYrQMKkjt1e4H7zottrnlsYK_TtwjNRACt2ENv9EQ }

	NewTransaction (Inserts new transaction/study record in transactions table, initiating unique id. Algorithm includes verification of the duplicate transactions vs transactions table in LITE DB. If within duplicatesEliminateInterval = 600000; // 10 minutes a successful transaction, matching basic parameters of this transaction, was found, the response includes the following error code   - ERROR_00051101 = "DICOM/DCMTK inbound duplicate record" or similar)
-	Bearer Token
-	Input Paremeters:  Strng instanceUid, String organizationCode, String serviceName, String coonectionName, String transDirection, int transSize,
                     String patientMrn, String accessionNumebr, String studyUid, String seriesUid, String sopUid, transStatus (init), 
                     String errorCode, String errorMessage, String transStarted (null), String transFinished (null),
                     int retryAttemps (0)
-	Output Paremeters: long id, Strng instanceUid, String organizationCode, String serviceName, String coonectionName, String transDirection, int transSize,
                     String patientMrn, String accessionNumebr, String studyUid, String seriesUid, String sopUid, transStatus (init, success, failure, fatal), 
                     String errorCode, String errorMessage, String transStarted ("YYYY-MM-DD HH:mm:SS"), String transFinished ("YYYY-MM-DD HH:mm:SS"),
                     int retryAttemps
