package com.homeland.utils;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CalculatorUtil {

	
	private static final String KEY = "stresidheciljeta";
	
	public static String encodeBASE64(byte[] bytes)
	{
		if(bytes == null || bytes.length == 0) return null;
		
		return Base64.getEncoder().encodeToString(bytes);
		
	}
	
	
	public static byte[] decodeBASE64(String byteStr)
	{
		if(!StringUtil.isValid(byteStr)) return null;
		
		return Base64.getDecoder().decode(byteStr);
		
	}
	
	
	public static String enca(String noizy)
	{
		try {
			
			Key aesKey = new SecretKeySpec(KEY.getBytes(),"AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(noizy.getBytes());
			return encodeBASE64(encrypted);
 			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String noizy(String enca)
	{
		try {
			
			Key aesKey = new SecretKeySpec(KEY.getBytes(),"AES");
			Cipher cipher = Cipher.getInstance("AES");
			byte[] encrypted = decodeBASE64(enca);
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			String decrypted = new String(cipher.doFinal(encrypted));
 			
			return decrypted;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
