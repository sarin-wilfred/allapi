/**
 * 
 */
package org.telstra.allapi.srvc.rest.services;

import org.telstra.allapi.srvc.rest.exceptions.RevWordException;

/**
 * @author Sarin
 *
 */
public interface RevWordService {
	
	/**
	 * @param scentence
	 * @return String
	 * @throws RevWordException
	 */
	public String process(String scentence) throws RevWordException;

}
