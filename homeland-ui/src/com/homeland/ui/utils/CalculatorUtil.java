package com.homeland.ui.utils;

import java.util.Base64;

public class CalculatorUtil {

	
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
	
	
	
	
	
}
