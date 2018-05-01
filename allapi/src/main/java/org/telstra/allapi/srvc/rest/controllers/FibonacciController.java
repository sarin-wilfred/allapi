/**
 * 
 */
package org.telstra.allapi.srvc.rest.controllers;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.telstra.allapi.srvc.rest.exceptions.FibonacciException;
import org.telstra.allapi.srvc.rest.services.FibonacciService;

/**
 * @author Sarin
 *
 */
@RestController
public class FibonacciController {

	private static final Logger LOG = LoggerFactory.getLogger(FibonacciController.class);

	@Autowired
	private FibonacciService fibonacciService;

	/**
	 * This method is used to find the fibonacci number by index
	 * 
	 * @param number
	 * @return ResponseEntity<BigInteger>
	 * @throws FibonacciException
	 */
	@GetMapping("/api/Fibonacci")
	public ResponseEntity<BigInteger> findFibonacciNumber(@RequestParam("n") Long number) throws FibonacciException {
		LOG.info("STARTS - findFibonacciNumber");
		LOG.info("Limit: {}", number);
		BigInteger result = fibonacciService.calculate(number);
		LOG.info("ENDS - findFibonacciNumber");
		return ResponseEntity.ok().cacheControl(CacheControl.noCache())
				.body(result);

	}

}
