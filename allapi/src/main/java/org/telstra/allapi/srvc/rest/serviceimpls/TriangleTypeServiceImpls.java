/**
 * 
 */
package org.telstra.allapi.srvc.rest.serviceimpls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telstra.allapi.srvc.rest.enums.TriangleType;
import org.telstra.allapi.srvc.rest.exceptions.TriangleTypeException;
import org.telstra.allapi.srvc.rest.services.TriangleTypeService;

/**
 * @author Sarin
 *
 */
@Service
public class TriangleTypeServiceImpls implements TriangleTypeService {

	private static final Logger LOG = LoggerFactory.getLogger(TriangleTypeServiceImpls.class);

	/**
	 * This method used to find the triangle type based on all 3 sides
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 * @throws TriangleTypeException
	 */
	@Override
	public TriangleType process(Integer a, Integer b, Integer c) throws TriangleTypeException {
		LOG.info("STARTS - process");
		TriangleType result = null;
		try {
			if (a <= 0 || b <= 0 || c <= 0)
				result = TriangleType.INVALID;
			else if (a == b && b == c)
				result = TriangleType.EQUILATERAL;
			else if (b == c || a == b || c == a)
				result = TriangleType.ISOSCELES;
			else
				result = TriangleType.SCALENE;
		} catch (Exception exception) {
			LOG.error("Error Message", exception.getMessage());
			throw new TriangleTypeException(exception.getMessage());
		}
		LOG.info("Result: {}", result);
		LOG.info("STARTS - process");
		return result;
	}

}
