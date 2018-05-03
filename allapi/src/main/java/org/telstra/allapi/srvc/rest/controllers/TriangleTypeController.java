/**
 * 
 */
package org.telstra.allapi.srvc.rest.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.telstra.allapi.srvc.rest.enums.TriangleType;
import org.telstra.allapi.srvc.rest.exceptions.TriangleTypeException;
import org.telstra.allapi.srvc.rest.services.TriangleTypeService;

/**
 * @author Sarin
 *
 */
@RestController
public class TriangleTypeController {

	private static final Logger LOG = LoggerFactory.getLogger(TriangleTypeController.class);

	@Autowired
	private TriangleTypeService triangleTypeService;

	/**
	 * This method is used to find the fibonacci number by index
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return ResponseEntity<String>
	 * @throws TriangleTypeException
	 */
	@GetMapping("/api/TriangleType")
	public ResponseEntity<String> findTriangleType(@RequestParam("a") Float a, @RequestParam("b") Float b,
			@RequestParam("c") Float c) throws TriangleTypeException {
		LOG.info("STARTS - findTriangleType");
		LOG.info("Sides a:{}, b:{}, c:{}", a, b, c);
		TriangleType result = triangleTypeService.process(a, b, c);
		LOG.info("ENDS - findTriangleType");
		return ResponseEntity.ok().cacheControl(CacheControl.noCache())
				.body(result.getValue());

	}
	
	/**
	 * Method added to handle NumberFormatException
	 * 
	 * @param request
	 * @param nfEx
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<String> handleException(HttpServletRequest request, NumberFormatException nfEx) {
		LOG.error("Triangle type error: {}", nfEx.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).cacheControl(CacheControl.noCache()).body("Sides should be digits.");
	}

}
