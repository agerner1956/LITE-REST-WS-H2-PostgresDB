package com.lifeimage.lite.ws.server.utils;

public class Constants {
	private Constants() { } // Prevents instantiation 
	public static final String messageStarted = " Started";
	public static final String messageFinished = " Finished";
	public static final String statusSuccess = "success";
	public static final String statusFailure = "failure";
	public static final String statusFatal = "fatal";
	public static final String statusInit = "init";
	public static final String tokenProvider = "LifeImageJWT";
	public static final long duplicatesEliminateInterval = 600000; // 10 minutes
	public static final long tokenExpirationInterval = 3600000; //  1 hour
	
	
	public static final String ERROR_00011000 = "Security";
	public static final String ERROR_00011100 = "Authentication";
	public static final String ERROR_00011200 = "Authorization";
	public static final String ERROR_00012000 = "Properties";
	public static final String ERROR_00012100 = "Data Integrity";
	public static final String ERROR_00012200 = "Configuaration Conflict";
	
	public static final String ERROR_00021000 = "LITE Start Service";
	public static final String ERROR_00022000 = "LITE Stop Service";
	public static final String ERROR_00023100 = "DICOM Stop Service";
	public static final String ERROR_00023200 = "DCMTK Stop Service";
	public static final String ERROR_00023300 = "HL7 Stop Service";
	
	public static final String ERROR_00041000 = "WS Server not responding";
	public static final String ERROR_00042000 = "WS request failure";
	public static final String ERROR_00043000 = "WS response failure";
	
	public static final String ERROR_00051000 = "DICOM/DCMTK inbound";
	public static final String ERROR_00051101 = "DICOM/DCMTK inbound duplicate record";
	public static final String ERROR_00051201 = "DICOM/DCMTK outbound duplicate record";
	public static final String ERROR_00052000 = "HL7";
	public static final String ERROR_00052101 = "HL7 inbound duplicate record";
	public static final String ERROR_00053000 = "FileConnector";
	public static final String ERROR_00053101 = "FileConnectorinbound duplicate record";
	public static final String ERROR_00053201 = "FileConnector outbound duplicate record";
}
