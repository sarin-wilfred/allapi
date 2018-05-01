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
import org.telstra.allapi.srvc.rest.exceptions.RevWordException;
import org.telstra.allapi.srvc.rest.services.RevWordService;

/**
 * @author Sarin
 *
 */
@RestController
public class RevWordController {

	private static final Logger LOG = LoggerFactory.getLogger(RevWordController.class);

	@Autowired
	private RevWordService revWordService;

	/**
	 * This method used to generate the reversed words
	 * 
	 * @param sentence
	 * @return ResponseEntity<String>
	 * @throws RevWordException
	 */
	@GetMapping("/api/ReverseWords")
	public ResponseEntity<String> generateReversedWords(@RequestParam("sentence") String sentence)
			throws RevWordException {
		LOG.debug("STARTS - generateReversedWords");
		LOG.info("Sentence: {}", sentence);
		String result = revWordService.process(sentence);
		LOG.debug("ENDS - generateReversedWords");
		return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(result);

	}

}
