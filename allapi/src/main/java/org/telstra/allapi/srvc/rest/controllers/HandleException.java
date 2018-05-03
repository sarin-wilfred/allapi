/**
 * 
 */
package org.telstra.allapi.srvc.rest.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOG = LoggerFactory.getLogger(HandleException.class);

	/**
	 * Method added to handle FibonacciException
	 * 
	 * @param request
	 * @param fibEx
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(FibonacciException.class)
	public ResponseEntity<String> handleException(HttpServletRequest request, FibonacciException fibEx) {
		LOG.error("Fibanocci error: {}", fibEx.getMessage());
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
		LOG.error("Reverse word error: {}", rwEx.getMessage());
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
		LOG.error("Triangle type error: {}", ttex.getMessage());
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
		LOG.error("Make array error: {}", maEx.getMessage());
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
		LOG.error("Error: {}", ex.getMessage());
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).cacheControl(CacheControl.noCache())
				.body(ex.getMessage());
	}

}
