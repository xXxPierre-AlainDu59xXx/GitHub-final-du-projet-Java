package model;

import model.ICoins;
import controller.Permeability;

/**
 *  The coins class represents a loot that can be retrieve to earn points 
 * The class coins consists to instantiate an object coins with:
 * 
 * An x and y coordinates to locate on a map.
 * A url to connect the coins to an image format . png
 * And a list to give him a permeability.
 * 
 * @author Corentin Devrouete
 * @version 1.0
 */
public class Coins extends Loot implements ICoins {
	
	/**
	 * Initialized Coins 
	 * @param x
	 * 			The x position of the coins on a landmark o,x,y.
	 * @param y
	 * 			The y position of the coins on a landmark o,x,y.
	 * @param url
	 * 			The link to a specific image. 
	 */
	public Coins(int x, int y, String url) {
		super(url,Permeability.BLOCKING);
	}
}