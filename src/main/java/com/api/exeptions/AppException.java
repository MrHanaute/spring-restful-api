package com.api.exeptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handlerAnyExeption(Exception ex, WebRequest req){
		
		String msg = ex.getLocalizedMessage();
		
		if(msg == null) msg = ex.toString();
		
		MessageError objError = new MessageError(new Date(), msg);
		
		return new ResponseEntity<>(objError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handlerNullExeption(NullPointerException ex, WebRequest req){
		
		String msg = ex.getLocalizedMessage();
		
		if(msg == null) msg = ex.toString();
		
		MessageError objError = new MessageError(new Date(), msg);
		
		return new ResponseEntity<>(objError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
