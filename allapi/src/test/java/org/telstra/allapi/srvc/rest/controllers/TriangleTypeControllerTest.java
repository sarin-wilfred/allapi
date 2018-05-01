package org.telstra.allapi.srvc.rest.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.telstra.allapi.srvc.rest.controllers.TriangleTypeController;
import org.telstra.allapi.srvc.rest.enums.TriangleType;
import org.telstra.allapi.srvc.rest.exceptions.TriangleTypeException;

/**
 * @author Sarin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TriangleTypeControllerTest {

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
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(1,2,1);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.ISOSCELES.getValue());
	}

	@Test
	public void testFindTriangleType3() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(1,2,3);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.SCALENE.getValue());
	}

	@Test
	public void testFindTriangleType4() throws TriangleTypeException {
		ResponseEntity<String> responseEntity = triangleTypeController.findTriangleType(-1,2,3);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(TriangleType.INVALID.getValue());
	}
	
	@Test(expected = TriangleTypeException.class)
	public void testFindTriangleType5() throws TriangleTypeException {
		triangleTypeController.findTriangleType(null,2,3);
	}

}
