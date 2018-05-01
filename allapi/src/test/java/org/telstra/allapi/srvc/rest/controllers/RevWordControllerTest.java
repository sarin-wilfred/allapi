package org.telstra.allapi.srvc.rest.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.telstra.allapi.srvc.rest.controllers.RevWordController;
import org.telstra.allapi.srvc.rest.exceptions.RevWordException;

/**
 * @author Sarin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RevWordControllerTest {

	@Autowired
	private RevWordController revWordController;

	@Test
	public void testGenerateReversedWords1() throws RevWordException {
		ResponseEntity<String> responseEntity = revWordController.generateReversedWords("how are you");
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo("woh era uoy");
	}

	@Test
	public void testGenerateReversedWords2() throws RevWordException {
		ResponseEntity<String> responseEntity = revWordController.generateReversedWords("I love coding");
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo("I evol gnidoc");
	}

	@Test
	public void testGenerateReversedWords3() throws RevWordException {
		ResponseEntity<String> responseEntity = revWordController.generateReversedWords("test");
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo("tset");
	}

	@Test(expected = RevWordException.class)
	public void testGenerateReversedWords4() throws RevWordException {
		revWordController.generateReversedWords(null);
	}

}
