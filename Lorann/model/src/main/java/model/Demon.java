package model;

import model.IDemon;
import controller.Permeability;

/**
 * <b>Demon is the class representative the artificial intelligence of game that one should avoid</b>
 * The Demon consists to instantiate an object Demon with :
 * <ul>
 * <li>An x and y coordinates to locate on a map.</li>
 * <li>A url to connect the Demon to an image format . png.</li>
 * <li>And a list to give him a permeability.</li>
 * </ul>
 * @author Corentin Devrouete
 * @version 1.1
 */
public class Demon extends MobileElement implements IDemon {

	/**
	 * Initialize the demon
	 * @param x
	 * 			The x position of the demon on a landmark o,x,y.
	 * 			It can be changed by artificial intelligence.
	 * @param y
	 * 			The y position of the demon on a landmark o,x,y.
	 * 			It can be changed by artificial intelligence.
	 * @param url
	 *			The link to a specific image. 
	 */
	
	public Demon(int x, int y, String url) {
		super(url,Permeability.PENETRABLE);
		setY(y);
		setX(x);
	}
}
