/**
 * 
 */
package org.telstra.allapi.srvc.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> findTriangleType(@RequestParam("a") Integer a, @RequestParam("b") Integer b,
			@RequestParam("c") Integer c) throws TriangleTypeException {
		LOG.info("STARTS - findTriangleType");
		LOG.info("Sides a:{}, b:{}, c:{}", a, b, c);
		TriangleType result = triangleTypeService.process(a, b, c);
		LOG.info("ENDS - findTriangleType");
		return ResponseEntity.ok().cacheControl(CacheControl.noCache())
				.body(result.getValue());

	}

}
