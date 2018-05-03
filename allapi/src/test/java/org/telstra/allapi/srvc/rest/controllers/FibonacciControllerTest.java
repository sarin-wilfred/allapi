package org.telstra.allapi.srvc.rest.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.telstra.allapi.srvc.rest.exceptions.FibonacciException;

/**
 * @author Sarin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FibonacciControllerTest {
	 
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Autowired
	private FibonacciController fibonacciController;

	@Test
	public void testFindFibonacciNumber1() throws FibonacciException {
		ResponseEntity<BigInteger> responseEntity = fibonacciController.findFibonacciNumber(10L);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(55);
	}

	@Test
	public void testFindFibonacciNumber2() throws FibonacciException {
		ResponseEntity<BigInteger> responseEntity = fibonacciController.findFibonacciNumber(12L);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(144);
	}

	@Test
	public void testFindFibonacciNumber3() throws FibonacciException {
		ResponseEntity<BigInteger> responseEntity = fibonacciController.findFibonacciNumber(0L);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(0);
	}
	
	@Test
	public void testFindFibonacciNumber4() throws FibonacciException {
		exception.expect(FibonacciException.class);
		exception.expectMessage("The value of n is negative and not valid.");
		fibonacciController.findFibonacciNumber(-1L);
	}
	
	@Test
	public void testFindFibonacciNumber5() throws FibonacciException {
		ResponseEntity<BigInteger> responseEntity = fibonacciController.findFibonacciNumber(11L);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNotEqualTo(60);
	}
	
	@Test
	public void testFindFibonacciNumber6() throws FibonacciException {
		ResponseEntity<BigInteger> responseEntity = fibonacciController.findFibonacciNumber(13L);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNotEqualTo(145);
	}
	
	@Test
	public void testFindFibonacciNumber7() throws FibonacciException {
		exception.expect(FibonacciException.class);
		exception.expectMessage("The value of n is negative and not valid.");
		fibonacciController.findFibonacciNumber(-9L);
	}
	
	@Test
	public void testFindFibonacciNumber8() throws FibonacciException {
		exception.expect(FibonacciException.class);
		exception.expectMessage("The value of n is negative and not valid.");
		fibonacciController.findFibonacciNumber(-30L);
	}
}
