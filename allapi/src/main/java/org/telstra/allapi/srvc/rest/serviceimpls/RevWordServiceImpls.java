/**
 * 
 */
package org.telstra.allapi.srvc.rest.serviceimpls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telstra.allapi.srvc.rest.exceptions.RevWordException;
import org.telstra.allapi.srvc.rest.services.RevWordService;

/**
 * @author Sarin
 *
 */
@Service
public class RevWordServiceImpls implements RevWordService {

	private static final Logger LOG = LoggerFactory.getLogger(RevWordServiceImpls.class);

	/**
	 * This method used to process the reverse word of a sentence
	 * 
	 * @param scentence
	 * @return String
	 * @throws RevWordException
	 */
	@Override
	public String process(String scentence) throws RevWordException {
		LOG.info("STARTS - process");
		String result = null;
		try {
			String[] words = scentence.split(" ");
			StringBuilder scentenceBuilder = new StringBuilder();
			StringBuilder wordBuilder = null;
			for (String word : words) {
				wordBuilder = new StringBuilder(word);
				scentenceBuilder.append(wordBuilder.reverse());
				if (scentence.length() > scentenceBuilder.length())
					scentenceBuilder.append(" ");
			}
			result = scentenceBuilder.toString();
		} catch (Exception exception) {
			LOG.error("Error Message", exception.getMessage());
			throw new RevWordException(exception.getMessage());
		}
		LOG.info("Result: {}", result);
		LOG.info("STARTS - process");
		return result;
	}

}
