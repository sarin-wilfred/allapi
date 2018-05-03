package org.telstra.allapi.srvc.rest.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.telstra.allapi.srvc.rest.exceptions.MakeArrayException;

/**
 * @author Sarin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MakeArrayControllerTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Autowired
	private MakeArrayController makeArrayController;

	@Test
	public void testGenerateOneArray1() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {4f,3f,2f,1f});
		requestData.put("Array2", new Float[] {9f,8f,7f,6f,5f,3f,2f,4f});
		requestData.put("Array3", new Float[] {10f,11f,12f,13f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {1f,2f,3f,4f,5f,6f,7f,8f,9f,10f,11f,12f,13f});
		ResponseEntity<Map<String, Float[]>> responseEntity = makeArrayController.generateOneArray(requestData);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertArrayEquals(responseEntity.getBody().get("Array"), resultMap.get("Array"));
	}
	
	@Test
	public void testGenerateOneArray2() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {4f,3f,2f,1f});
		requestData.put("Array2", new Float[] {});
		requestData.put("Array3", new Float[] {10f,11f,12f,13f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {1f,2f,3f,4f,10f,11f,12f,13f});
		ResponseEntity<Map<String, Float[]>> responseEntity = makeArrayController.generateOneArray(requestData);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertArrayEquals(responseEntity.getBody().get("Array"), resultMap.get("Array"));
	}

	@Test
	public void testGenerateOneArray3() throws MakeArrayException {
		exception.expect(MakeArrayException.class);
		exception.expectMessage("Elements of the array contains null which is not valid.");
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {null});
		requestData.put("Array2", new Float[] {});
		requestData.put("Array3", new Float[] {10f,11f,12f,13f});
		makeArrayController.generateOneArray(requestData);
	}
	
	@Test
	public void testGenerateOneArray4() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {10.3f,10.2f,10.5f,10.4f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {10.2f,10.3f,10.4f,10.5f});
		ResponseEntity<Map<String, Float[]>> responseEntity = makeArrayController.generateOneArray(requestData);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertArrayEquals(responseEntity.getBody().get("Array"), resultMap.get("Array"));
	}
	
	@Test
	public void testGenerateOneArray5() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {1f,-2f,-3f,4f,5f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {-3f,-2f,1f,4f,5f});
		ResponseEntity<Map<String, Float[]>> responseEntity = makeArrayController.generateOneArray(requestData);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertArrayEquals(responseEntity.getBody().get("Array"), resultMap.get("Array"));
	}
	
	@Test
	public void testGenerateOneArray6() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {1f,2f,3f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {2f,3f,1f});
		ResponseEntity<Map<String, Float[]>> responseEntity = makeArrayController.generateOneArray(requestData);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertNotEquals(responseEntity.getBody().get("Array"), resultMap);
	}
	
	@Test
	public void testGenerateOneArray7() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {2f,1f,-3f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {1f,2f,-3f});
		ResponseEntity<Map<String, Float[]>> responseEntity = makeArrayController.generateOneArray(requestData);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertNotEquals(responseEntity.getBody().get("Array"), resultMap);
	}
	
	@Test
	public void testGenerateOneArray8() throws MakeArrayException {
		exception.expect(MakeArrayException.class);
		exception.expectMessage("Elements of the array contains null which is not valid.");
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {4f,7f,1f, null});
		makeArrayController.generateOneArray(requestData);
	}
	
	@Test
	public void testGenerateOneArray9() throws MakeArrayException {
		exception.expect(MakeArrayException.class);
		exception.expectMessage("Elements of the array contains null which is not valid.");
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {null , null});
		makeArrayController.generateOneArray(requestData);
	}
	
}
