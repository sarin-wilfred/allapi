package org.telstra.allapi.srvc.rest.serviceimpls;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.telstra.allapi.srvc.rest.exceptions.FibonacciException;
import org.telstra.allapi.srvc.rest.services.FibonacciService;

/**
 * @author Sarin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FibonacciServiceImplsTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Autowired
	private FibonacciService fibonacciService;

	@Test
	public void testCalculate1() throws FibonacciException {
		assertThat(fibonacciService.calculate(11L)).isEqualTo(89);
	}

	@Test
	public void testCalculate2() throws FibonacciException {
		assertThat(fibonacciService.calculate(13L)).isEqualTo(233);
	}

	@Test
	public void testCalculate3() throws FibonacciException {
		assertThat(fibonacciService.calculate(0L)).isEqualTo(0);
	}
	
	@Test
	public void testCalculate4() throws FibonacciException {
		exception.expect(FibonacciException.class);
		exception.expectMessage("The value of n is negative and not valid.");
		fibonacciService.calculate(-2L);
	}
	
	@Test
	public void testCalculate5() throws FibonacciException {
		assertThat(fibonacciService.calculate(12L)).isNotEqualTo(90);
	}
	
	public void testCalculate6() throws FibonacciException {
		assertThat(fibonacciService.calculate(14L)).isNotEqualTo(234);
	}

	
	@Test
	public void testCalculate7() throws FibonacciException {
		exception.expect(FibonacciException.class);
		exception.expectMessage("The value of n is negative and not valid.");
		fibonacciService.calculate(-10L);
	}
	
	@Test
	public void testCalculate8() throws FibonacciException {
		exception.expect(FibonacciException.class);
		exception.expectMessage("The value of n is negative and not valid.");
		fibonacciService.calculate(-15L);
	}

}
