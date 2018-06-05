package model;

import java.util.ArrayList;

import view.IMap;

/**
*<b>The Map class represents the whole map</b>
* The class Map consists to instantiate an object with :
* <ul>
* <li>A dimension of map.</li>
* <li>A variety of different element.</li>
* </ul>
* @author Corentin Devrouete
* @version 1.1
*/
public class Map implements IMap {

	private int width;
	private int height;
	public IElement elements[][];
	public ArrayList<IMobileElement> mobiles = new ArrayList<IMobileElement>();
	public IElement lorann;
	public IElement spell;
	
	/**
	 * Initialize the map
	 * @param width
	 * 				The width of the map.
	 * @param height
	 * 				The height of the map.
	 */
	public Map(int width, int height){
		this.width = width;
		this.height = height;
		this.elements = new IElement[this.getWidth()][this.getHeight()];
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IMap#getWidth()
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Updates the width of the map
	 * @param width
	 * 			the width of the map
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IMap#getHeight()
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Updates the height of the map
	 * @param height 
	 * 			the height of the map
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IMap#getElements()
	 */
	public IElement[][] getElements() {
		return this.elements;
	}
	
	/**
	 * Set the table of elements
	 * @param elements 
	 * 			the different elements
	 */
	public void setElements(IElement[][] elements) {
		this.elements = elements;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IMap#getMobiles()
	 */
	public ArrayList<IMobileElement> getMobiles() {
		return this.mobiles;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IMap#addMobiles(contract.IMobileElement)
	 */
	public void addMobiles(IMobileElement mobile) {
		mobiles.add(mobile);
	}

	/*
	 * (non-Javadoc)
	 * @see contract.IMap#getElement(int, int)
	 */
	public IElement getElement( int x,  int y) {
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
			return null;
		}
		return this.elements[x][y];
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IMap#addElement(contract.IElement, int, int)
	 */
	public void addElement(IElement element, int x, int y) {
		this.elements[x][y] = element;
		element.setPosition(x,y);
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IMap#getLorann()
	 */
	public IElement getLorann() {
		return lorann;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IMap#setHero(contract.IElement)
	 */
	public void setLorann(IElement lorann) {
		this.lorann = lorann;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IMap#getSpell()
	 */
	public IElement getSpell() {
		return spell;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IMap#setSpell(contract.IElement)
	 */
	public void setSpell(IElement spell) {
		this.spell = spell;
	}

	@Override
	public int getIDMap() {
		// TODO Auto-generated method stub
		return 0;
	}
}