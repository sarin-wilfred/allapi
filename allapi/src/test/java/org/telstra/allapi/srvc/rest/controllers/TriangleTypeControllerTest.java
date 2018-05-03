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
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(1f,1f,1f);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.EQUILATERAL.getValue());
	}

	@Test
	public void testFindTriangleType2() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(2f,2f,3f);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.ISOSCELES.getValue());
	}

	@Test
	public void testFindTriangleType3() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(3f,4f,5f);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.SCALENE.getValue());
	}

	@Test
	public void testFindTriangleType4() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeController.findTriangleType(-1f,2f,3f);
	}
	
	@Test
	public void testFindTriangleType5() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeController.findTriangleType(-1f,-2f,-3f);
	}
	
	@Test
	public void testFindTriangleType6() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeController.findTriangleType(1f,2f,0f);
	}
	
	@Test
	public void testFindTriangleType7() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeController.findTriangleType(0f,0f,0f);
	}
	
	@Test
	public void testFindTriangleType9() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(4f,4f,4f);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNotEqualTo(TriangleType.SCALENE.getValue());
	}

	@Test
	public void testFindTriangleType10() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(5f,4f,7f);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNotEqualTo(TriangleType.ISOSCELES.getValue());
	}

	@Test
	public void testFindTriangleTyp11() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(7f,7f,10f);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNotEqualTo(TriangleType.EQUILATERAL.getValue());
	}
	
	@Test
	public void testFindTriangleType12() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeController.findTriangleType(5f,5f,10f);
	}
	
	@Test
	public void testFindTriangleType13() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(1.3f,1.3f,1.3f);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.EQUILATERAL.getValue());
	}

	@Test
	public void testFindTriangleType14() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(2.4f,2.4f,3f);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.ISOSCELES.getValue());
	}

	@Test
	public void testFindTriangleType15() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(3.1f,4.3f,5.7f);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.SCALENE.getValue());
	}
	
	@Test
	public void testFindTriangleType16() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeController.findTriangleType(5.1f,5.2f,10.9f);
	}
	
	@Test
	public void testFindTriangleType17() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(0.6f,0.7f,0.5f);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.SCALENE.getValue());
	}
	
	@Test
	public void testFindTriangleType18() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(0.2f,0.3f,0.4f);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNotEqualTo(TriangleType.ISOSCELES.getValue());
	}


}
