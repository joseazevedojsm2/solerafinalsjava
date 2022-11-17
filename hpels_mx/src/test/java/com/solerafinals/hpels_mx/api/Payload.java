package com.solerafinals.hpels_mx.api;

public class Payload {
	public static String AddUser() {
		return "{\r\n" + 
				"  \"first_name\": \"First\",\r\n" + 
				"  \"last_name\": \"Last\",\r\n" + 
				"  \"phone_number\": \"912345678\",\r\n" + 
				"  \"email\": \"test@email.com\"\r\n" + 
				"}\r\n";
	}
	
	public static String EditUser() {
		return "{\r\n" + 
				"  \"first_name\": \"First\",\r\n" + 
				"  \"last_name\": \"LastUpdated\",\r\n" + 
				"  \"phone_number\": \"912345678\",\r\n" + 
				"  \"email\": \"test@email.com\"\r\n" + 
				"}\r\n";
	}
}
