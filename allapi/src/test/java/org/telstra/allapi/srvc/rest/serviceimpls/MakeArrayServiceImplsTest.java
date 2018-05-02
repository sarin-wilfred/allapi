package org.telstra.allapi.srvc.rest.serviceimpls;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.telstra.allapi.srvc.rest.exceptions.MakeArrayException;
import org.telstra.allapi.srvc.rest.services.MakeArrayService;

/**
 * @author Sarin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MakeArrayServiceImplsTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Autowired
	private MakeArrayService makeArrayService;

	@Test
	public void testProcess1() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {2f,4f,3f,1f});
		requestData.put("Array2", new Float[] {6f,3f,7f,9f,5f,8f,2f,4f});
		requestData.put("Array3", new Float[] {12f,13f,10f,11f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {1f,2f,3f,4f,5f,6f,7f,8f,9f,10f,11f,12f,13f});
		assertArrayEquals(makeArrayService.process(requestData).get("Array"), resultMap.get("Array"));
	}

	@Test
	public void testProcess2() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {});
		requestData.put("Array2", new Float[] {6f,3f,7f,9f,5f,8f,2f,4f});
		requestData.put("Array3", new Float[] {12f,13f,10f,11f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {2f,3f,4f,5f,6f,7f,8f,9f,10f,11f,12f,13f});
		assertArrayEquals(makeArrayService.process(requestData).get("Array"), resultMap.get("Array"));
	}

	@Test
	public void testProcess3() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {2f,4f,3f,1f});
		requestData.put("Array2", new Float[] {});
		requestData.put("Array3", new Float[] {});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {1f,2f,3f,4f});
		assertArrayEquals(makeArrayService.process(requestData).get("Array"), resultMap.get("Array"));
	}
	
	@Test
	public void testProcess4() throws MakeArrayException {
		exception.expect(MakeArrayException.class);
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {2f,4f,3f,1f});
		requestData.put("Array2", null);
		requestData.put("Array3", new Float[] {10f,11f,12f,13f});
		makeArrayService.process(requestData);
	}
	
	@Test
	public void testProcess5() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {12.3f,12.2f,12.5f,12.4f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {12.2f,12.3f,12.4f,12.5f});
		assertArrayEquals(makeArrayService.process(requestData).get("Array"), resultMap.get("Array"));
	}
	
	@Test
	public void testProcess6() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {11f,-22f,-33f,44f,55f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {-33f,-22f,11f,44f,55f});
		assertArrayEquals(makeArrayService.process(requestData).get("Array"), resultMap.get("Array"));
	}
	
	@Test
	public void testProcess7() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {31f,32f,33f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {32f,33f,31f});
		assertNotEquals(makeArrayService.process(requestData).get("Array"), resultMap);
	}
	
	@Test
	public void testProcess8() throws MakeArrayException {
		Map<String, Float[]> requestData = new HashMap<>();
		requestData.put("Array1", new Float[] {32f,31f,-33f});
		Map<String, Float[]> resultMap = new HashMap<>();
		resultMap.put("Array", new Float[] {31f,32f,-33f});
		assertNotEquals(makeArrayService.process(requestData).get("Array"), resultMap);
	}

}
