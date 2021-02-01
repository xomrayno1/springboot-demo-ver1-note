package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleException  extends ResponseEntityExceptionHandler{
	
	 @ExceptionHandler(ApplicationException.class)
	 public ResponseEntity<Object> handleApplicationException(ApplicationException exception,
			 						WebRequest request){
		 ErrorDetail errorDetail = new ErrorDetail(exception.getMessage(),
				 								 request.getDescription(false),
				 								 new Date());
		 return new ResponseEntity<Object>(errorDetail,HttpStatus.BAD_REQUEST); 
	 }
	 
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 ErrorDetail errorDetail = new ErrorDetail("Validation failed",	
				 		ex.getBindingResult().toString(),
					 new Date());
		 return new ResponseEntity<Object>(errorDetail,HttpStatus.INTERNAL_SERVER_ERROR);
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}
}
