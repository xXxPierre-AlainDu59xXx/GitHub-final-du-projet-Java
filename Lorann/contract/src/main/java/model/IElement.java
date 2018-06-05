package model;

import java.awt.Image;

import controller.Permeability;


 // @author Corentin Devrouete
 // @version 01/06/2018

public interface IElement {


	int getX();


	int getY();
	

	public void setPosition(int x, int y);


	public Permeability getPermeability();

	
	public ISprite getSprite();

	Image getImage();

}