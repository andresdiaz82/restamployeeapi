package com.oracle.employee.utils;

import org.apache.commons.codec.binary.Base64;

public class HeaderValidator {
//Added basic base64 encoding decoding for the authorization header on the delete operaion
	
	public static boolean isAuthorized(String auth) {
		String decoded = "";
		String[] parts = auth.split("\\s+");
		String info = parts[1];
		String[] data = null;
		byte[] bytes = null;
		try {
			bytes = new Base64().decode(info.getBytes());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		decoded = new String(bytes);
		data = decoded.split(":");
		if(data[0].equals("us3r") && data[1].equals("p4ssw0rd")) {
			return true;
		}
		return false;	
	}
	
	protected static String encodedCreds(String user, String password) {
		Base64 b64 = new Base64();
		return new String(b64.encode((user+":"+password).getBytes()));
	}
	
	public static void main(String[] args) {
		System.out.println(HeaderValidator.encodedCreds("us3r", "p4ssw0rd"));
	}
}
