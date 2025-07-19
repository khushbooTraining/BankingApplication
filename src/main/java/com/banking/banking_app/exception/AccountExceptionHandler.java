package com.banking.banking_app.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import com.khushboo.rest.webservices.restful_web_services.exception.ErrorDetails;



@RestControllerAdvice
public class AccountExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception){
		
		return new ResponseEntity<String>("id doesnot exist,please use another id",HttpStatus.BAD_GATEWAY);
		
	}
       
	/*@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleException(Exception exception){
		
		ErrorMessage errorMessage=new ErrorMessage(LocalDateTime.now(),exception.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
}*/
	
	/*@ExceptionHandler(AccountNotFound.class)
	public ResponseEntity<ErrorMessage> handleAllException(Exception exception){
		ErrorMessage errorMessage=new ErrorMessage(LocalDateTime.now(),exception.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
	}*/
	
	
	/*@ExceptionHandler(AccountNotFound.class)
	public ResponseEntity<ErrorMessage> handleCustomException(
			Exception e) {
            ErrorMessage error=new ErrorMessage(LocalDateTime.now(),e.getMessage());
		
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}*/
	
   // @ExceptionHandler(MethodArgumentNotValidException.class)
   /* public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        String errors = ex.getBindingResult().getFieldErrors().stream()
            .map(err -> err.getField() + ": " + err.getDefaultMessage())
            .collect(Collectors.joining(", "));

        ErrorMessage error = new ErrorMessage(LocalDateTime.now(), errors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }*/

    @Override
	 protected ResponseEntity<Object> handleMethodArgumentNotValid(
				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//+"2nd "+ex.getFieldError().getDefaultMessage()
		 ErrorMessage errorDetails=new ErrorMessage(LocalDateTime.now(),
				 "total error: "+ex.getErrorCount()+ "First "+ex.getFieldError().getDefaultMessage()
				);

			return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
		}
}