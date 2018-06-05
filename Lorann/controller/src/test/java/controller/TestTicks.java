package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//@author Corentin Devrouete 
//@update 1.0

public class TestTicks {

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


	@Test
	public void testTicks() {
		IController controller = null;
		assertNotNull(new controller.Ticks(controller));
	}


	@Test
	public void testRun() {
		IController controller = null;
		controller.Ticks ticks = new controller.Ticks(controller);
		ticks.run();
	}

}