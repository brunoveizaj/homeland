package com.homeland.exceptions;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class ApiExceptionHandler {
	
    @ExceptionHandler({ EntityExistsException.class, InvalidTokenException.class, GeneralException.class, Exception.class })
    public final ResponseEntity<?> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        
        if (ex instanceof EntityExistsException) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            EntityExistsException ve = (EntityExistsException) ex;
            return handleEntityExistsException(ve, headers, status, request);
            
        } else if (ex instanceof InvalidTokenException) {
            HttpStatus status = HttpStatus.UNAUTHORIZED;
            InvalidTokenException ite = (InvalidTokenException) ex;
            return handleInvalidTokenException(ite, headers, status, request);
            
        }else if (ex instanceof GeneralException) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            GeneralException ite = (GeneralException) ex;
            return handleGeneralException(ite, headers, status, request);
            
        }
        else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleException(ex, headers, status, request);
        }
    }


    
    protected ResponseEntity<?> handleEntityExistsException(EntityExistsException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return handleExceptionInternal(ex, new ApiException(ex.getMessage(),status.value(),2,"ENTITY_EXISTS_EXCEPTION",errors), headers, status, request);
    }
    
    protected ResponseEntity<?> handleGeneralException(GeneralException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return handleExceptionInternal(ex, new ApiException(ex.getMessage(),status.value(),2,"GENERAL_EXCEPTION",errors), headers, status, request);
    }
      
    
    protected ResponseEntity<?> handleInvalidTokenException(InvalidTokenException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return handleExceptionInternal(ex,  new ApiException(ex.getMessage(),status.value(),3,"INVALID_TOKEN",errors), headers, status, request);
    }

    protected ResponseEntity<?> handleException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    	List<String> errors = Collections.singletonList(ex.getMessage());
        
        System.out.println("********* ASP EXCEPTION (HANDLER) ************\n"+ex.getMessage()+"\n"+errors);
        
        return handleExceptionInternal(ex, new ApiException("Gabim i brendshem ",status.value(),4,"HL_EXCEPTION",errors), headers, status, request);
    }
   

    /** A single place to customize the response body of all Exception types. */
    protected ResponseEntity<?> handleExceptionInternal(Exception ex, ApiException body, HttpHeaders headers, HttpStatus status, WebRequest request) {
    	
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }
}