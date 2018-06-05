package model;

import model.IMobileElement;
import controller.Permeability;

/**
 * @author Corentin Devrouete
 * @version 2.1
 */
public class MobileElement extends Element implements IMobileElement {
	
	/**
	 * @param url
	 * 			To assign an image
	 * @param permeability
	 * 			To assign a permeability
	 */
	public MobileElement ( String url, Permeability permeability){
		super(permeability,new Sprite(url));
	}

	
	
}