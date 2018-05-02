package org.telstra.allapi.srvc.rest.serviceimpls;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.telstra.allapi.srvc.rest.exceptions.RevWordException;
import org.telstra.allapi.srvc.rest.services.RevWordService;

/**
 * @author Sarin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RevWordServiceImplsTest {

	@Autowired
	private RevWordService revWordService;

	@Test
	public void testProcess1() throws RevWordException {
		assertThat(revWordService.process("My name is Sarin")).isEqualTo("yM eman si niraS");
	}

	@Test
	public void testProcess2() throws RevWordException {
		assertThat(revWordService.process("I want to be the best")).isEqualTo("I tnaw ot eb eht tseb");
	}

	@Test
	public void testProcess3() throws RevWordException {
		assertThat(revWordService.process("success")).isEqualTo("sseccus");
	}

	@Test(expected = RevWordException.class)
	public void testProcess4() throws RevWordException {
		revWordService.process(null);
	}
	
	@Test
	public void testProcess5() throws RevWordException {
		assertThat(revWordService.process("one")).isNotEqualTo("oen");
	}
	
	@Test
	public void testProcess6() throws RevWordException {
		assertThat(revWordService.process("one one")).isNotEqualTo("oen one");
	}

}
