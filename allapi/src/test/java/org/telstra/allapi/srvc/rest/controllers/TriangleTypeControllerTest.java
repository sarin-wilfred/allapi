package org.telstra.allapi.srvc.rest.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.telstra.allapi.srvc.rest.enums.TriangleType;
import org.telstra.allapi.srvc.rest.exceptions.TriangleTypeException;

/**
 * @author Sarin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TriangleTypeControllerTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Autowired
	private TriangleTypeController triangleTypeController;

	@Test
	public void testFindTriangleType1() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(1,1,1);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.EQUILATERAL.getValue());
	}

	@Test
	public void testFindTriangleType2() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(2,2,3);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.ISOSCELES.getValue());
	}

	@Test
	public void testFindTriangleType3() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(3,4,5);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.SCALENE.getValue());
	}

	@Test
	public void testFindTriangleType4() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeController.findTriangleType(-1,2,3);
	}
	
	@Test
	public void testFindTriangleType5() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeController.findTriangleType(-1,-2,-3);
	}
	
	@Test
	public void testFindTriangleType6() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeController.findTriangleType(1,2,0);
	}
	
	@Test
	public void testFindTriangleType7() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeController.findTriangleType(0,0,0);
	}
	
	@Test
	public void testFindTriangleType9() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(4,4,4);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNotEqualTo(TriangleType.SCALENE.getValue());
	}

	@Test
	public void testFindTriangleType10() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(5,4,7);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNotEqualTo(TriangleType.ISOSCELES.getValue());
	}

	@Test
	public void testFindTriangleTyp11() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(7,7,10);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNotEqualTo(TriangleType.EQUILATERAL.getValue());
	}
	
	@Test
	public void testFindTriangleType12() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeController.findTriangleType(5,5,10);
	}

}
