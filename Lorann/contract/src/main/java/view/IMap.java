package view;

import java.util.ArrayList;

import model.IElement;
import model.IMobileElement;

//@author Corentin Devrouete
//@update 30/05/2018

public interface IMap {


	int getWidth();


	int getHeight();

	
	int getIDMap();
	
	
	public IElement[][] getElements();

	
	public ArrayList<IMobileElement> getMobiles();

	
	public void addMobiles(IMobileElement mobile);


	public IElement getElement(int x, int y);
	
	
	void addElement(IElement element, int x, int y);
	
	
	public IElement getLorann();
	
	
	public void setLorann(IElement lorann);
	
	
	public IElement getSpell();
	
	
	public void setSpell(IElement spell);

}