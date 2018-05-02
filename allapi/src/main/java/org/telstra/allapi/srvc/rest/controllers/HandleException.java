/**
 * 
 */
package org.telstra.allapi.srvc.rest.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(FibonacciException.class)
	public ResponseEntity<String> handleException(HttpServletRequest request, FibonacciException fibEx) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).cacheControl(CacheControl.noCache())
				.body(fibEx.getMessage());
	}

	/**
	 * Method added to handle RevWordException
	 * 
	 * @param request
	 * @param rwEx
	 */
	@ExceptionHandler(RevWordException.class)
	public ResponseEntity<String> handleException(HttpServletRequest request, RevWordException rwEx) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).cacheControl(CacheControl.noCache())
				.body("Exception occurred during the generation of reverse word.");
	}

	/**
	 * Method added to handle TriangleTypeException
	 * 
	 * @param request
	 * @param ttex
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(TriangleTypeException.class)
	public ResponseEntity<String> handleException(HttpServletRequest request, TriangleTypeException ttex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).cacheControl(CacheControl.noCache())
				.body(ttex.getMessage());
	}

	/**
	 * Method added to handle MakeArrayException
	 * 
	 * @param request
	 * @param maEx
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(MakeArrayException.class)
	public ResponseEntity<String> handleException(HttpServletRequest request, MakeArrayException maEx) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).cacheControl(CacheControl.noCache())
				.body(maEx.getMessage());
	}

	/**
	 * Method added to handle Exception
	 * 
	 * @param request
	 * @param ex
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(HttpServletRequest request, Exception ex) {
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).cacheControl(CacheControl.noCache())
				.body("HTTP request is not supported");
	}

}
