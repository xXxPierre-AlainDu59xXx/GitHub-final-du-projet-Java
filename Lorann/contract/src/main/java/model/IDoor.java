
package model;

 //@author Arthur
 //@version 1/06/2018

public interface IDoor {

	public DoorState getDoorState();
	/**
	 *Updates the door state 
	 * @param doorState
	 * 				It's a DoorState
	 */
	public void setDoorState(DoorState doorState);
}