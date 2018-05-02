/**
 * 
 */
package org.telstra.allapi.srvc.rest.serviceimpls;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telstra.allapi.srvc.rest.exceptions.MakeArrayException;
import org.telstra.allapi.srvc.rest.services.MakeArrayService;

/**
 * @author Sarin
 *
 */
@Service
public class MakeArrayServiceImpls implements MakeArrayService {

	private static final Logger LOG = LoggerFactory.getLogger(MakeArrayServiceImpls.class);

	/**
	 * This method used to used to generate and sort one array from multiple arrays
	 * 
	 * @param requestData
	 * @return ResponseEntity<Map<String, Float[]>>
	 * @throws MakeArrayException
	 */
	@Override
	public Map<String, Float[]> process(Map<String, Float[]> requestData) throws MakeArrayException {
		LOG.info("STARTS - process");
		Map<String, Float[]> resultMap = new HashMap<>();
		Set<Float> result = new HashSet<>();
		Float[] sortedResult = null;
		try {
			requestData.entrySet().forEach(entry -> Collections.addAll(result, entry.getValue()));
			sortedResult = result.parallelStream().sorted().toArray(Float[]::new);
			resultMap.put("Array", (Float[]) sortedResult);
		} catch (Exception exception) {
			LOG.error("Error Message", exception.getMessage());
			throw new MakeArrayException(exception.getMessage());
		}
		for (Float floatObj : sortedResult) {
			LOG.info("Sorted Result: {}", floatObj);
		}
		LOG.info("STARTS - process");
		return resultMap;
	}

}
