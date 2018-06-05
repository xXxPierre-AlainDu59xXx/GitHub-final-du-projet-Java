package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.IElement;
import controller.Permeability;
import model.Element;
import model.Sprite;
/**
 * @author Corentin Devrouete
 * @version 1.1
 * Ce Test a été réalisé grace a un tutoriel d'utilisation de JUnit pour un jeux PacMan 
 */
public class TestMap {


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
	 * test method for {@link model.Map#Map(int, int)}
	 */
	@Test
	public void testMap(){
		assertNotNull(new model.Map(42,88));
	}
	
	/**
	 * test method for {@link model.Map#getWidth()}
	 */
	@Test
	public void testGetWidth() {
		int w = (int)(Math.random()*100);
		model.Map map = new model.Map(w,15);
		assertEquals(w, map.getWidth());
	}

	/**
	 * test method for {@link model.Map#setWidth(int)}
	 */
	@Test
	public void testSetWidth() {
		int w = (int)(Math.random()*100);
		model.Map map = new model.Map(w,15);
		int width1 = map.getWidth();
		int width2;
		do{
			width2 = (int)(Math.random()*100);
		}while(width2 ==width1);
		map.setWidth(width2);
		
		assertEquals(width2, map.getWidth());
	}

	/**
	 * test method for {@link model.Map#getHeight()}
	 */
	@Test
	public void testGetHeight() {
		int h = (int)(Math.random()*100);
		model.Map map = new model.Map(23,h);
		assertEquals(h, map.getHeight());
	}

	/**
	 * test method for {@link model.Map#setHeight(int)}
	 */
	@Test
	public void testSetHeight() {
		int h = (int)(Math.random()*100);
		model.Map map = new model.Map(34,h);
		int height1 = map.getHeight();
		int height2;
		do{
			height2 = (int)(Math.random()*100);
		}while(height2 == height1);
		map.setHeight(height2);
		
		assertEquals(height2, map.getHeight());
	}

	/**
	 * test method for {@link model.Map#getElements()}
	 */
	@Test
	public void testGetElements() {
		model.Map map = new model.Map((int)(Math.random()*100),(int)(Math.random()*100));
		map.elements = new IElement[map.getWidth()][map.getHeight()];
		assertArrayEquals(map.getElements(),map.elements);
	}
	
	/**
	 * test method for {@link model.Map#getElement(int, int)}
	 */
	@Test
	public void testGetElement(){
		Sprite sprite = new Sprite("sprite/lorann_ul.png");
		model.Map map = new model.Map((int)(Math.random()*100),(int)(Math.random()*100));
		model.Element element = new model.Element(Permeability.PENETRABLE, sprite);
		map.elements[2][2] = element;
		assertEquals(map.getElement(2, 2), element);
	}

	/**
	 * test method for {@link model.Map#addMobiles(contract.IMobileElement)}
	 */
	@Test
	public void testAddMobiles() {
		/* To complete*/
	}
	
	/**
	 * test method for {@link model.Map#getLorann()}
	 */
	@Test
	public void testGetLorann(){
		Sprite sprite = new Sprite("sprite/lorann_ul.png");
		model.Map map = new model.Map((int)(Math.random()*100),(int)(Math.random()*100));
		map.lorann = new Element(Permeability.PENETRABLE,sprite);
		assertEquals(map.lorann, map.getLorann());
	}
	
	/**
	 * test method for {@link model.Map#setLorann(IElement)}
	 */
	@Test
	public void testSetLorann(){
		Sprite sprite = new Sprite("sprite/lorann_ul.png");
		model.Map map = new model.Map((int)(Math.random()*100),(int)(Math.random()*100));
		map.lorann = new Element(Permeability.PENETRABLE,sprite);
		Sprite newSprite = new Sprite("sprite/lorann_ur.png");
		IElement newHero =new Element(Permeability.PENETRABLE,newSprite);
		map.setLorann(newHero);
		assertEquals(newHero, map.getLorann());
	}
	
	/**
	 * test method for {@link model.Map#getSpell()}
	 */
	@Test
	public void testGetSpell(){
		Sprite sprite = new Sprite("sprite/bone.png");
		model.Map map = new model.Map((int)(Math.random()*100),(int)(Math.random()*100));
		map.spell = new Element(Permeability.BLOCKING, sprite);
		assertEquals(map.spell,map.getSpell());
	}
}