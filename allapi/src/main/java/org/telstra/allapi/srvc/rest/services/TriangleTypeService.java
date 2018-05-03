/**
 * 
 */
package org.telstra.allapi.srvc.rest.services;

import org.telstra.allapi.srvc.rest.enums.TriangleType;
import org.telstra.allapi.srvc.rest.exceptions.TriangleTypeException;

/**
 * @author Sarin
 *
 */
public interface TriangleTypeService {

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 * @throws TriangleTypeException
	 */
	public TriangleType process(Float a, Float b, Float c) throws TriangleTypeException;

}
