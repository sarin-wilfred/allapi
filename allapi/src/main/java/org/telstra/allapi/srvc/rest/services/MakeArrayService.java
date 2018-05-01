/**
 * 
 */
package org.telstra.allapi.srvc.rest.services;

import java.util.Map;

import org.telstra.allapi.srvc.rest.exceptions.MakeArrayException;

/**
 * @author Sarin
 *
 */
public interface MakeArrayService {
	
	/**
	 * 
	 * @param requestData
	 * @return Map<String, Integer[]>
	 * @throws MakeArrayException
	 */
	public Map<String, Integer[]> process(Map<String, Integer[]> requestData) throws MakeArrayException;

}
