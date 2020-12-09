package com.azl.lararestfulapi.exception;

import java.io.IOException;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.azl.lararestfulapi.utile.ErrorMessage;
import com.azl.lararestfulapi.utile.MessageConstants;



@ControllerAdvice
public class GlobalExceptionHundelerMethod {

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullException(NullPointerException ex) {
		// Do something additional if required
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(MessageConstants.STATUS_ERROR_MESSAGE);
		modelAndView.addObject(MessageConstants.MESSAGE, ex.getMessage());
		return modelAndView;
	}
	
	  /*@ResponseBody
	  @ExceptionHandler(SQLException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String sqlHandler(SQLException ex) {
	    return ex.getMessage();
	  }*/

	@ExceptionHandler(IOException.class)
	public ResponseEntity<Object> handleIOException(IOException ex, WebRequest request) {
		return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
		/*
		 * String msg ="Unknown Exception: "+ex.getMessage();
		 * System.out.println(msg);
		 */
		String errorMessageDescription = ex.getLocalizedMessage();
		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * @ExceptionHandler(BotException.class) public ResponseEntity<Object>
	 * handleEmployeeNotFoundException(BotException ex, WebRequest request) { String
	 * errorMessageDescription = ex.getLocalizedMessage(); if
	 * (errorMessageDescription == null) errorMessageDescription = ex.toString();
	 * 
	 * ErrorMessage errorMessage = new ErrorMessage(new Date(),
	 * errorMessageDescription); return new ResponseEntity<>(errorMessage, new
	 * HttpHeaders(), HttpStatus.NOT_FOUND);
	 * }
	 */
	}