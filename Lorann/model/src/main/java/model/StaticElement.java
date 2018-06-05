package model;

import controller.Permeability;
/**
 * This class StaticElement is used to define the mobility of the object
 * The StaticElement consists take into account:
 * 
 * >A url to connect the object to an image format . png.
 * And a list to give him a permeability or not.
 *
 * @author Corentin Devrouete
 * @version 1.0
 */
public class StaticElement extends Element {
/***
 * 
 * @param url
 * 			Take the picture.
 * @param permeability
 * 			Take the permeability of the element.
 */
	public StaticElement ( String url, Permeability permeability){
		super(permeability, new Sprite(url));
	}
}