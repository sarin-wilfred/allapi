/**
 * 
 */
package org.telstra.allapi.srvc.rest.services;

import java.math.BigInteger;

import org.telstra.allapi.srvc.rest.exceptions.FibonacciException;

/**
 * @author Sarin
 *
 */
public interface FibonacciService {
	
	/**
	 * 
	 * @param number
	 * @return BigInteger
	 * @throws FibonacciException
	 */
	public BigInteger calculate(Long number) throws FibonacciException;

}
