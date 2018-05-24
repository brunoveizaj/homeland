package com.homeland.ui.utils;

public interface PhotoUtil {

	
	public static final String NO_IMAGE = "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";

	
}
