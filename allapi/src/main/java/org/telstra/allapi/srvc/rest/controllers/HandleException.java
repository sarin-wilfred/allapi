/**
 * 
 */
package org.telstra.allapi.srvc.rest.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.telstra.allapi.srvc.rest.exceptions.FibonacciException;
import org.telstra.allapi.srvc.rest.exceptions.MakeArrayException;
import org.telstra.allapi.srvc.rest.exceptions.RevWordException;
import org.telstra.allapi.srvc.rest.exceptions.TriangleTypeException;

/**
 * @author Sarin
 *
 */
@RestControllerAdvice
public class HandleException {
	
	/**
	 * Method added to handle FibonacciException
	 * 
	 * @param request
	 * @param fibEx
	 */
	@ExceptionHandler(FibonacciException.class)
	@ResponseStatus(code=HttpStatus.CONFLICT, reason="Exception occurred during the calculation of fibanocci number.")
	public void handleException(HttpServletRequest request, FibonacciException fibEx) {
	}
	
	/**
	 * Method added to handle RevWordException
	 * 
	 * @param request
	 * @param rwEx
	 */
	@ExceptionHandler(RevWordException.class)
	@ResponseStatus(code=HttpStatus.CONFLICT, reason="Exception occurred during the generation of reverse word.")
	public void handleException(HttpServletRequest request, RevWordException rwEx) {
	}
	
	/**
	 * Method added to handle TriangleTypeException
	 * 
	 * @param request
	 * @param ttex
	 */
	@ExceptionHandler(TriangleTypeException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Exception occurred while finding triangle type.")
	public void handleException(HttpServletRequest request, TriangleTypeException ttex) {
	}
	
	/**
	 * Method added to handle MakeArrayException
	 * 
	 * @param request
	 * @param maEx
	 */
	@ExceptionHandler(MakeArrayException.class)
	@ResponseStatus(code=HttpStatus.CONFLICT, reason="Exception occurred during the generation array.")
	public void handleException(HttpServletRequest request, MakeArrayException maEx) {
	}
	
	
	/**
	 * Method added to handle NumberFormatException
	 * 
	 * @param request
	 * @param nfEx
	 */
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(code=HttpStatus.METHOD_NOT_ALLOWED, reason="Null not expected.")
	public void handleException(HttpServletRequest request, NumberFormatException nfEx) {
	}
	
	/**
	 *  Method added to handle Exception
	 *  
	 * @param request
	 * @param ex
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code=HttpStatus.METHOD_NOT_ALLOWED, reason="All api Application Error.")
	public void handleException(HttpServletRequest request, Exception ex) {
	}

}
