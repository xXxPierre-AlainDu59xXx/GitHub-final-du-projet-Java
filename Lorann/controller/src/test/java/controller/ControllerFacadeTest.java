package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ControllerFacadeTest {

	//@author Corentin Devrouete 
	//@update 1.0
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	 // test method for {@link controller.Controller#Controller(contract.IModel, contract.IView)}

	@Test
	public void testController() {
		assertNotNull(new ControllerFacade(null, null));
	}

	@Test
	public void testKeyEvents() {
		
	}

	@Test
	public void testMoveLorann() {
		
	}

	@Test
	public void testMoveMobileElement() {
		
	}

	@Test
	public void testMoveDemon() {
		
	}

	@Test
	public void testDemonContact() {}
		

	@Test
	public void testMoveSpell() {
		
	}

	@Test
	public void testSpellContact() {
		
	}

	@Test
	public void testUpdate() {
		
	}

}
