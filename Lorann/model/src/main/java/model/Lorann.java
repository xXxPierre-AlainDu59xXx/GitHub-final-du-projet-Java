package model;

import model.ILorann;
import controller.Permeability;
import model.SpellState;
import model.LorannState;
/**
*<b>The Lorann class represents the main character that the user plays</b>
* The class Lorann consists to instantiate an object Lorann with:
* <ul>
* <li>An x and y coordinates to locate on a map at the start of the game.</li>
* <li>A url to connect the character to an image format . png.</li>
* <li>A permeability</li>
* </ul>
* @author Corentin Devrouete
* @version 1.4
*/
public class Lorann extends MobileElement implements ILorann {
	
	public LorannState state = LorannState.DOWN;
	public SpellState spellState;
	
	
	/**
	 * Initialize Lorann and characteristics of Lorann 
	 * @param x
	 * 			The x position of the character on a landmark o,x,y.
	 * 			It can be changed by the user during the game.
	 * @param y
	 * 			The y position of the character on a landmark o,x,y.
	 * 			It can be changed by the user during the game.
	 * @param url
	 * 			The link to a specific image. 
	 */
	public Lorann (int x, int y, String url){
		super(url,Permeability.PENETRABLE);
		setX(x);
		setY(y);
		spellState = SpellState.NotThrow;
		String images[] = {
				"sprite/lorann_b.png",
                "sprite/lorann_br.png",
                "sprite/lorann_r.png",
                "sprite/lorann_ur.png",
                "sprite/lorann_u.png",
                "sprite/lorann_ul.png",
                "sprite/lorann_l.png",
                "sprite/lorann_bl.png"};
        this.sprite = new AnimateSprite(url,images);
	}

	
	/*
	 * (non-Javadoc)
	 * @see contract.ILorann#getState()
	 */
	public LorannState getState() {
		return state;
	}

	/*
	 * (non-Javadoc)
	 * @see contract.ILorann#setState(contract.LorannState)
	 */
	public void setState(LorannState state) {
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * @see contract.ILorann#getPossessionSpell()
	 */
	public SpellState getPossessionSpell() {
		return spellState;
	}

	/*
	 * (non-Javadoc)
	 * @see contract.ILorann#setPossessionSpell(contract.SpellState)
	 */
	public void setPossessionSpell(SpellState spellState) {
		this.spellState = spellState;
	}
}