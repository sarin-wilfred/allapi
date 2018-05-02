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
	 * @return ResponseEntity<Map<String, Float[]>>
	 * @throws MakeArrayException
	 */
	public Map<String, Float[]> process(Map<String, Float[]> requestData) throws MakeArrayException;

}
