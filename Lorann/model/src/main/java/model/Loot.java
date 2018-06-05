
	package model;

	import controller.Permeability;

	/**
	*The Loot class represents all objects that the user can take
	*The Loot class represents all objects that the user can take
	* The class Loot consists to create many object with:
	* 
	* A url to connect the loot to an image format . png.
	* And a list to give him a permeability.
	* 
	* @author Corentin Devrouete 
	* @version 1.0
	*/
	public class Loot extends StaticElement {
		/**
		 * 
		 * @param url
		 *			To assign an image 			
		 * @param permeability
		 * 			To assign a permeability
		 */
		public Loot ( String url, Permeability permeability){
			super(url, permeability);
		}}



