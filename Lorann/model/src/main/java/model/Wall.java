package model;

import model.IWall;
import controller.Permeability;
/**
*The Wall class represents the structure of the map
*The Wall class represents the structure of the map
* The class Wall consists to instantiate an object Wall with:
* 
* An x and y coordinates to locate on a map.
* A url to connect the wall to an image format . png
* And a list to give him a permeability.
* 
* @author Corentin Devrouete
* @version 1.2
*/
public class Wall extends StaticElement implements IWall {
	
	/**
	 * Initialize the wall
	 * @param x
	 * 			The x position of the wall on a landmark o,x,y.
	 * @param y
	 * 			The y position of the wall on a landmark o,x,y.
	 * @param url
	 * 			The link to a specific image. 
	 */
	public Wall ( int x, int y, String url){
		super(url,Permeability.BLOCKING);
	}
}