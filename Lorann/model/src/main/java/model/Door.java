package model;

import model.DoorState;

import model.IDoor;
import controller.Permeability;
/**
 *  The Door class represents the access to the end of the level </b>
 * The class Door consists to instantiate an object Door with:
 * 
 * An x and y coordinates to locate on a map
 * A url to connect the door to an image format . png
 * And a list to give him a permeability
 * 
 * 
 * @author Corentin Devrouete
 * @version 17.06.16
 */
public class Door extends StaticElement implements IDoor {
	private DoorState doorState;
	
	/**
	 * Initialize the door
	 * @param x
	 * 			The x position of the door on a landmark o,x,y.
	 * @param y
	 * 			The y position of the door on a landmark o,x,y.
	 * @param url
	 * 			The link to a specific image. 
	 */
	public Door(int x, int y, String url) {
		super(url,Permeability.BLOCKING);
		this.doorState = DoorState.CLOSE;
	}


	public DoorState getDoorState() {
		return doorState;
	}


	public void setDoorState(DoorState doorState) {
		this.doorState = doorState;
	}
	
	
}