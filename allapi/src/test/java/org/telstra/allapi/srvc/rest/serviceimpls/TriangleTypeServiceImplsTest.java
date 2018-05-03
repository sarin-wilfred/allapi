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
		assertThat(triangleTypeService.process(5f,5f,5f)).isEqualTo(TriangleType.EQUILATERAL);
	}

	@Test
	public void testProcess2() throws TriangleTypeException {
		assertThat(triangleTypeService.process(10f,10f,15f)).isEqualTo(TriangleType.ISOSCELES);
	}

	@Test
	public void testProcess3() throws TriangleTypeException {
		assertThat(triangleTypeService.process(5f,11f,15f)).isEqualTo(TriangleType.SCALENE);
	}

	@Test
	public void testProcess4() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(1f,-10f,15f);
	}
	
	@Test
	public void testProcess5() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(-11f,12f,13f);
	}
	
	@Test
	public void testProcess6() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(-21f,-22f,-23f);
	}
	
	@Test
	public void testProcess7() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(31f,32f,0f);
	}
	
	@Test
	public void testProcess8() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(0f,0f,0f);
	}
	
	@Test
	public void testProcess9() throws TriangleTypeException {
		assertThat(triangleTypeService.process(24f,24f,24f)).isNotEqualTo(TriangleType.SCALENE);
	}

	@Test
	public void testProcess10() throws TriangleTypeException {
		assertThat(triangleTypeService.process(15f,14f,17f)).isNotEqualTo(TriangleType.ISOSCELES);
	}

	@Test
	public void testProcess11() throws TriangleTypeException {
		assertThat(triangleTypeService.process(17f,20f,17f)).isNotEqualTo(TriangleType.EQUILATERAL);
	}
	
	@Test
	public void testProcess12() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(5f,5f,10f);
	}
	
	@Test
	public void testProcess13() throws TriangleTypeException {
		assertThat(triangleTypeService.process(4.2f,4.2f,4.2f)).isEqualTo(TriangleType.EQUILATERAL);
	}

	@Test
	public void testProcess14() throws TriangleTypeException {
		assertThat(triangleTypeService.process(2.4f,2.4f,3f)).isEqualTo(TriangleType.ISOSCELES);
	}

	@Test
	public void testProcess15() throws TriangleTypeException {
		assertThat(triangleTypeService.process(6.1f,5.4f,7.6f)).isEqualTo(TriangleType.SCALENE);
	}
	
	@Test
	public void testProcess16() throws TriangleTypeException {
		exception.expect(TriangleTypeException.class);
		exception.expectMessage("Sides are not valid.");
		triangleTypeService.process(7.3f,6.2f,15.9f);
	}
	
	@Test
	public void testProcess17() throws TriangleTypeException {
		assertThat(triangleTypeService.process(0.4f,0.7f,0.6f)).isEqualTo(TriangleType.SCALENE);
	}
	
	@Test
	public void testProcess18() throws TriangleTypeException {
		assertThat(triangleTypeService.process(0.2f,0.3f,0.4f)).isNotEqualTo(TriangleType.ISOSCELES);
	}

}
