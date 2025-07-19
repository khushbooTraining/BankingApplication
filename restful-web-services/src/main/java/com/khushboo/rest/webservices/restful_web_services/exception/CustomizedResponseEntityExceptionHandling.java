package com.khushboo.rest.webservices.restful_web_services.exception;

import java.time.LocalDateTime;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.khushboo.rest.webservices.restful_web_services.user.UserNotFoundException;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandling extends ResponseEntityExceptionHandler{
	
	 @ExceptionHandler(Exception.class)  
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		 ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		 
		 return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 
	 @ExceptionHandler(UserNotFoundException.class)  
		public final ResponseEntity<ErrorDetails> handleAllUserException(Exception ex, WebRequest request) throws Exception {
			
			 ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
			 
			 return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
		}
	 
	 @Override
	 protected ResponseEntity<Object> handleMethodArgumentNotValid(
				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
// +"2nd "+ex.getFieldError().getDefaultMessage()
		 ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
				 "total error: "+ex.getErrorCount()+ "First "+ex.getFieldError().getDefaultMessage()
				,request.getDescription(false));

			return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
		}
}
