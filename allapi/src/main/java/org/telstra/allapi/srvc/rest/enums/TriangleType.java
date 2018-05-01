/**
 * 
 */
package org.telstra.allapi.srvc.rest.enums;

/**
 * @author Sarin
 *
 */
public enum TriangleType {
	EQUILATERAL("Equilateral"), ISOSCELES("Isosceles"), SCALENE("Scalene"), INVALID("Invalid");
	private TriangleType(String value) {
		this.value = value;
	}
	private String value;
	
	public String getValue() {
		return this.value;
	}
}
