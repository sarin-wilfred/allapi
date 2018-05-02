package org.telstra.allapi.srvc.rest.serviceimpls;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Autowired
	private TriangleTypeService triangleTypeService;

	@Test
	public void testProcess1() throws TriangleTypeException {
		assertThat(triangleTypeService.process(5,5,5)).isEqualTo(TriangleType.EQUILATERAL);
	}

	@Test
	public void testProcess2() throws TriangleTypeException {
		assertThat(triangleTypeService.process(10,10,15)).isEqualTo(TriangleType.ISOSCELES);
	}

	@Test
	public void testProcess3() throws TriangleTypeException {
		assertThat(triangleTypeService.process(5,11,15)).isEqualTo(TriangleType.SCALENE);
	}

	@Test
	public void testProcess4() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(1,-10,15);
	}
	
	@Test
	public void testProcess5() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(-11,12,13);
	}
	
	@Test
	public void testProcess6() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(-21,-22,-23);
	}
	
	@Test
	public void testProcess7() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(31,32,0);
	}
	
	@Test
	public void testProcess8() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(0,0,0);
	}
	
	@Test
	public void testProcess9() throws TriangleTypeException {
		assertThat(triangleTypeService.process(24,24,24)).isNotEqualTo(TriangleType.SCALENE.getValue());
	}

	@Test
	public void testProcess10() throws TriangleTypeException {
		assertThat(triangleTypeService.process(15,14,17)).isNotEqualTo(TriangleType.ISOSCELES.getValue());
	}

	@Test
	public void testProcess11() throws TriangleTypeException {
		assertThat(triangleTypeService.process(17,20,17)).isNotEqualTo(TriangleType.EQUILATERAL.getValue());
	}
	
	@Test
	public void testProcess12() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(5,5,10);
	}
}
