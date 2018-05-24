package com.homeland.ui.api.security;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.homeland.ui.utils.StringUtil;

public class ApiErrorHandler implements ResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
    	
    	int severity = 3;
    	HttpStatus code = response.getStatusCode();
    	if(code.is5xxServerError())
    	{
    		severity = 4;
    	}
    	
    	String message = "";
    	
    	if(response.getBody() != null)
    	{
    	   InputStream is = response.getBody();
    	   message = StringUtil.toString(is);
    	}
    	    	
    	throw new ApiException(message,severity);
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
    	    	
    	HttpStatus.Series series = response.getStatusCode().series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series)
                || HttpStatus.Series.SERVER_ERROR.equals(series));
    }
}