package model;



import model.ISpell;
import controller.Permeability;
import model.SpellState;

/**
*<b>The Spell class represents the sorcery that the player can launch</b>
* The class Spell consists to instantiate an object Spell with:
* <ul>
* <li>An x and y coordinates to locate on a map the spell.</li>
* <li>A url to connect the spell to an image format . png.</li>
* <li>A permeability</li>
* </ul>
* @author Corentin Devrouete
* @version 1.0
*/
public class Spell extends MobileElement implements ISpell {
	public SpellState state;
	
	/**
	 * Initialize the spell and characteristics of spell
	 * @param x
	 * 			The x position of the spell on a landmark o,x,y.
	 * @param y
	 * 			The y position of the spell on a landmark o,x,y.
	 * @param url
	 * 			The link to a specific image. 
	 */
	public Spell ( int x, int y, String url){
		super(url,Permeability.PENETRABLE);
		setX(x);
		setY(y);
		String images[] = {
				"sprite/fireball_1.png",
                "sprite/fireball_2.png",
                "sprite/fireball_3.png",
                "sprite/fireball_4.png"};
        this.sprite = new AnimateSprite(url,images);
	}
	
	/* (non-Javadoc)
	 * @see model.ISpell#getState()
	 */
	public SpellState getState() {
		return state;
	}
	
	/* (non-Javadoc)
	 * @see model.ISpell#setState(contract.SpellState)
	 */
	public void setState(SpellState state) {
		this.state = state;
	}
}