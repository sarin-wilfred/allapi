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
	public TriangleType process(Float a, Float b, Float c) throws TriangleTypeException {
		LOG.info("STARTS - process");
		TriangleType result = null;
		if (a.compareTo(0f) <= 0 || b.compareTo(0f) <= 0 || c.compareTo(0f) <= 0)
			throw new TriangleTypeException("Sides are not valid.");
		else if (a.compareTo(b) == 0 && b.compareTo(c) == 0)
			result = TriangleType.EQUILATERAL;
		else if (a.compareTo(Float.sum(b, c)) >= 0 || b.compareTo(Float.sum(a, c)) >= 0 || c.compareTo(Float.sum(b, a)) >= 0)
			throw new TriangleTypeException("Sides are not valid.");
		else if (b.compareTo(c) == 0 || a.compareTo(b) == 0 || c.compareTo(a) == 0)
			result = TriangleType.ISOSCELES;
		else
			result = TriangleType.SCALENE;
		LOG.info("Result: {}", result);
		LOG.info("STARTS - process");
		return result;
	}

}
