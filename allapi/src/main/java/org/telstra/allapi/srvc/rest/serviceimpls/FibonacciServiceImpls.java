/**
 * 
 */
package org.telstra.allapi.srvc.rest.serviceimpls;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telstra.allapi.srvc.rest.exceptions.FibonacciException;
import org.telstra.allapi.srvc.rest.services.FibonacciService;

/**
 * @author Sarin
 *
 */
@Service
public class FibonacciServiceImpls implements FibonacciService {

	private static final Logger LOG = LoggerFactory.getLogger(FibonacciServiceImpls.class);

	/**
	 * This method used to calculate the fibonacci number based on the limit (index)
	 * 
	 * @param number
	 * @return BigInteger
	 * @throws FibonacciException
	 */
	@Override
	public BigInteger calculate(Long number) throws FibonacciException {
		LOG.info("STARTS - calculate");
		BigInteger result = null;
		if (Long.compare(number, 0L) == 0) {
			result = new BigInteger("0");
		} else {
			try {
				result = Stream
						.iterate(new BigInteger[] { BigInteger.ZERO, BigInteger.ONE },
								fib -> new BigInteger[] { fib[1], fib[0].add(fib[1]) })
						.limit(number).reduce((a, b) -> b).get()[1];
			} catch (Exception exception) {
				LOG.error("Error Message", exception.getMessage());
				throw new FibonacciException(exception.getMessage());
			}
		}
		LOG.info("Result: {}", result);
		LOG.info("STARTS - calculate");
		return result;
	}

}
