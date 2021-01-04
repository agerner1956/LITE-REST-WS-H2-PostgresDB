package com.lifeimage.lite.ws.server.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class Misc {

	public String getTimestamp() {
		String timeStamp = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
		return timeStamp;
	}

	public String encryptPassword(String password) {

		String encodedString = Base64.getEncoder().encodeToString(password.getBytes());
		return encodedString;

	}

	public String decryptPassword(String encodedString) {

		String password = new String(Base64.getDecoder().decode(encodedString));
		return password;

	}

	public Long convertTimestampToLong(String timestamp) {
		long ts = 0;
		try {
			ts = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(timestamp).getTime() ;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ts;

	}
}
