package model;

import model.IFloor;
import controller.Permeability;
/**
**The Floor class represents the wallpaper of the game
* The class Floor consists to instantiate an object Floor with:
* 
* An x and y coordinates to locate on a map.
* A url to connect the floor to an image format . png.
* And a list to give him a permeability.
* 
* @author Corentin Devrouete Pierre Alain Tietz
* @version 1.0
*/

public class Floor extends StaticElement implements IFloor{
	/**
	 * Initialize the floor
	 * @param x
	 * 			The x position of the floor on a landmark o,x,y.
	 * @param y
	 * 			The y position of the floor on a landmark o,x,y.
	 * @param url
	 * 			The link to a specific image. 
	 */
	public Floor(int x, int y, String url) {
		super(url, Permeability.PENETRABLE);
	
	}

}