package model;

import java.awt.Image;


import model.IElement;
import model.ISprite;
import controller.Permeability;

/**
* The Element class introduces elements based on 3 criteria :
*
* An x and y coordinates to locate on a map at the start of the game.
* A url to connect the various images format . png.
* And a list to give him a permeability.
* 
* @author Corentin Devrouete
* @version 1.0
 */
public class Element implements IElement {
	public int x, y;
	private Permeability permeability;
	protected ISprite sprite;

/**
 * @param permeability
 *				Update the permeability	 for the item
 * @param sprite
 * 				Update the sprite for the item
 */
	public Element(Permeability permeability, ISprite sprite){
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	/* (non-Javadoc)
	 * @see model.IElement#getX()
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Method to set the x coordinate of an element
	 * @param x
	 * 		the x coordinate of an element
	 */
	public void setX(int x) {
		this.x = x;
	}

	/* (non-Javadoc)
	 * @see model.IElement#getY()
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Method to set the y coordinate of an element
	 * @param y
	 * 		the x coordinate of an element
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IElement#setPosition(int, int)
	 */
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	

	/* (non-Javadoc)
	 * @see model.IElement#getPermeability()
	 */
	public Permeability getPermeability() {
		return permeability;
	}
	
	/**
	 * Method to set the permeability of an element
	 * @param permeability
	 */
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	/* (non-Javadoc)
	 * @see model.IElement#getSprite()
	 */
	public ISprite getSprite() {
		return sprite;
	}

	/**
	 * Method to set the sprite of an element
	 * @param sprite
	 * 			the sprite of an element
	 */
	public void setSprite(ISprite sprite) {
		this.sprite = sprite;
	}
	
	/* (non-Javadoc)
	 * @see model.IElement#getImage()
	 */
	public Image getImage() {
		return this.getSprite().getImage();
	}
	
	
	
}