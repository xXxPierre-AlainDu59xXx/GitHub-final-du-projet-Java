package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import model.Game;
/**
 * 
 * @author Corentin Devrouete
 * @version 1.2
 * Ce Test a été réalisé grace a un tutoriel d'utilisation de JUnit pour un jeux PacMan 
 */
public class TestGame {
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
	/**
	 * test method for {@link model.Game#Game()}
	 */
	@Test
	public void testGame(){
		assertNotNull(new Game());
	}
	
	/**
	 * test method for {@link model.Game#getId()}
	 */
	@Test
	public void testGetId(){
		model.Game game = new model.Game();
		assertEquals(game.getId(), game.id);
	}
	
	/**
	 * test method for {@link model.Game#setId(int)}
	 */
	@Test
	public void testSetId(){
		int rand;
		model.Game game = new model.Game();
		do{
		rand = (int)(Math.random()*10);
		}while (rand == game.getId());
		game.setId(rand);
	}
	
	/**
	 * test method for {@link model.Game#getScore()}
	 */
	@Test
	public void testGetScore(){
		model.Game game = new model.Game();
		int scoreSetted = 28021933;
		game.score = scoreSetted;
		assertEquals(scoreSetted, game.getScore());
	}
	
	/**
	 * test method for {@link model.Game#setScore(int)}
	 */
	@Test
	public void testSetScore(){
		model.Game game = new model.Game();
		int scoreSetted = 28021933;
		game.setScore(scoreSetted);
		assertEquals(scoreSetted, game.getScore());
	}
}