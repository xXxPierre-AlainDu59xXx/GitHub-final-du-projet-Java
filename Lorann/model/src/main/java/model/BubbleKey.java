package model;

import model.IBubbleKey;
import controller.Permeability;
/**
 *  BubbleKey is the class representative the necessary key to open the door 
 * BubbleKey is the class representative the necessary key to open the door 
 * The BubbleKey consists to instantiate an object BubbleKey with :
 * 
 * An x and y coordinates to locate on a map
 * A url to connect the key to an image format . png
 * And a list to give him a permeability.
 * 
 * 
 * @author Corentin Devrouete
 * @version 1.0
 */
public class BubbleKey extends Loot implements IBubbleKey {
	
	/**
	 * Initialize BubbleKey
	 * @param x
	 * 			The x position of the key on a landmark o,x,y.
	 * @param y
	 * 			The y position of the key on a landmark o,x,y.
	 * @param url
	 *			The link to a specific image. 
	 */
	public BubbleKey(int x, int y,String url) {
		super(url,Permeability.BLOCKING);
	}
}