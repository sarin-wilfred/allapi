/**
 * 
 */
package org.telstra.allapi.srvc.rest.controllers;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telstra.allapi.srvc.rest.exceptions.MakeArrayException;
import org.telstra.allapi.srvc.rest.services.MakeArrayService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

/**
 * @author Sarin
 *
 */
@RestController
public class MakeArrayController {

	private static final Logger LOG = LoggerFactory.getLogger(MakeArrayController.class);

	@Autowired
	private MakeArrayService makeArrayService;

	/**
	 * This method used to used to generate and sort one array from multiple arrays
	 * 
	 * @param requestData
	 * @return ResponseEntity<Map<String, Float[]>>
	 * @throws MakeArrayException
	 */
	@PostMapping("/api/makeonearray")
	public ResponseEntity<Map<String, Float[]>> generateOneArray(@RequestBody Map<String, Float[]> requestData)
			throws MakeArrayException {
		LOG.debug("STARTS - generateOneArray");
		LOG.info("Request Data");
		for (Entry<String, Float[]> entry : requestData.entrySet()) {
			if(null!= entry.getKey() && null!= entry.getValue()) {
				LOG.info("key: {}", entry.getKey());
				for (Float value : entry.getValue()) {
					if(null == value) {
						throw new MakeArrayException("Elements of the array contains null which is not valid.");
					}
					LOG.info("value: {}", value);
				}
			}
		}
		Map<String, Float[]> resultMap = makeArrayService.process(requestData);
		LOG.debug("ENDS - generateOneArray");
		return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(resultMap);

	}
	
	/**
	 * Method added to handle NumberFormatException
	 * 
	 * @param request
	 * @param nfEx
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<String> handleException(HttpServletRequest request, InvalidFormatException ifEx) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).cacheControl(CacheControl.noCache()).body("Elements of the array should be valid.");
	}
	
	/**
	 * Method added to handle JsonParseException
	 * 
	 * @param request
	 * @param jpEx
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(JsonParseException.class)
	public ResponseEntity<String> handleException(HttpServletRequest request, JsonParseException jpEx) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).cacheControl(CacheControl.noCache()).body("Input json is not valid.");
	}

}
