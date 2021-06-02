package com.vnnews.common.rest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Utility {
	
	private static   ObjectMapper mapper = null  ;
	private static MessageDigest messageDigest = null;
	
	
	
	
	private static ObjectMapper getMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		return mapper;
	}
	
	public static String getSHA_256(String string) throws NoSuchAlgorithmException{
		if(messageDigest == null) {
			messageDigest = MessageDigest.getInstance("SHA-256");
			
		}
		return new String(messageDigest.digest(string.getBytes(StandardCharsets.UTF_8)));
	}

	public static  String toJson(Object object) throws JsonProcessingException {
		if(mapper == null) {
			mapper = getMapper();
		}
		
		return mapper.writeValueAsString(object);
	}

	public static <T> T fromJson(String jsonString, Class<T> clazz) throws JsonMappingException, JsonProcessingException {
		if(mapper == null) {
			mapper = getMapper();
		}
		
		return mapper.readValue(jsonString, clazz);

	}
	
	public static String encodeBase64(String string) throws UnsupportedEncodingException {
		
		if(string == null || string.isEmpty()) {
			return "";
		}
		
		return Base64.getEncoder().encodeToString(string.getBytes("utf-8"));
	}
	
	public static String decodeBase64(String string) throws UnsupportedEncodingException {
		if(string == null || string.isEmpty()) {
			return "";
		}
		
		return new String (Base64.getDecoder().decode(string.getBytes("utf-8")));
	}
	
	public static String validateEmptyString(String string) {
		String validateString = string;
		try {
			validateString = string.replaceAll("/\\s+/", "");
		}
		catch (Exception e) {
				
		}
		return validateString;
	}
	
	public static boolean checkPhoneNumber(String phoneString) {
		String phoneRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
		return phoneString.matches(phoneRegex);
	}
	
}
