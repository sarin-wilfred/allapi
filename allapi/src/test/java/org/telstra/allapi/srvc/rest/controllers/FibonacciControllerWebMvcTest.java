package org.telstra.allapi.srvc.rest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.telstra.allapi.srvc.rest.exceptions.FibonacciException;

/**
 * @author Sarin
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = FibonacciController.class, secure = false)
public class FibonacciControllerWebMvcTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FibonacciController mockFibonacciController;
	
	@Test
	public void testFindFibonacciNumber7() throws FibonacciException, Exception {
		ResponseEntity<BigInteger> response = ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(new BigInteger("55"));
		Mockito.when(mockFibonacciController.findFibonacciNumber(10L)).thenReturn(response);
		mockMvc.perform(get("/api/Fibonacci?n=10"))
        .andExpect(status().isOk());
	}
	
	@Test
	public void testFindFibonacciNumber9() throws FibonacciException, Exception {
		ResponseEntity<BigInteger> response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).cacheControl(CacheControl.noCache()).body(new BigInteger("-1"));
		Mockito.when(mockFibonacciController.findFibonacciNumber(-1L)).thenReturn(response);
		mockMvc.perform(get("/api/Fibonacci?n=-1"))
        .andExpect(status().isInternalServerError());
	}	

}
