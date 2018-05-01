package org.telstra.allapi.srvc.rest.serviceimpls;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.telstra.allapi.srvc.rest.enums.TriangleType;
import org.telstra.allapi.srvc.rest.exceptions.TriangleTypeException;
import org.telstra.allapi.srvc.rest.services.TriangleTypeService;

/**
 * @author Sarin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TriangleTypeServiceImplsTest {

	@Autowired
	private TriangleTypeService triangleTypeService;

	@Test
	public void testProcess1() throws TriangleTypeException {
		assertThat(triangleTypeService.process(5,5,5)).isEqualTo(TriangleType.EQUILATERAL);
	}

	@Test
	public void testProcess2() throws TriangleTypeException {
		assertThat(triangleTypeService.process(5,5,15)).isEqualTo(TriangleType.ISOSCELES);
	}

	@Test
	public void testProcess3() throws TriangleTypeException {
		assertThat(triangleTypeService.process(5,10,15)).isEqualTo(TriangleType.SCALENE);
	}

	@Test
	public void testProcess4() throws TriangleTypeException {
		assertThat(triangleTypeService.process(1,-10,15)).isEqualTo(TriangleType.INVALID);
	}

	@Test(expected = TriangleTypeException.class)
	public void testProcess5() throws TriangleTypeException {
		triangleTypeService.process(1,null,15);
	}
}
