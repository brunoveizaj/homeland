package com.homeland.ui.utils;

public class StringUtil {

	
	
	public static boolean isValid(String value)
	{
		return value != null && !"".equals(value.trim());
	}
	
	public static String formatSQ(String value)
	{		
		if(isValid(value))
		{			
			return value.trim().toUpperCase().replace("Ë","E").replace("Ç", "C");
		}
		return null;
	}
}
