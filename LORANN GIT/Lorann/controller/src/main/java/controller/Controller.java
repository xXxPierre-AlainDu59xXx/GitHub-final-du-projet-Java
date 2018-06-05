package controller;

import java.awt.event.KeyEvent;


import contract.*;
/**
 * @author Corentin Devrouete
 * @version 29/05/2018
 */
public class Controller implements IController {

	private IModel model;
	private IView frame;
	
	/**
	 * Initialize the controller
	 * @param model
	 * 			Use the model
	 * @param frame
	 * 			Use the frame
	 */
	public Controller(IModel model, IView frame){
		this.model = model;
		this.frame = frame;
		Thread t = new Thread(new Ticks(this));
		t.start();

	}	
		
	/**
	 * Method that checks if the element is permeable or not
	 * @param x
	 * 		The x position on a landmark o,x,y.
	 * @param y
	 * 		The y position on a landmark o,x,y.
	 * @return A boolean if is blocked
	 */
	private boolean getBlocked(int x, int y){
		return model.getMap().getElement(x, y).getPermeability().equals(Permeability.BLOCKING);
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IController#keyEvents(java.awt.event.KeyEvent)
	 */
	public void keyEvents(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP : case KeyEvent.VK_Z :
				moveLorann(1);
				break;
			case KeyEvent.VK_DOWN : case KeyEvent.VK_S :
				moveLorann(2);
				break;
			case KeyEvent.VK_LEFT : case KeyEvent.VK_Q :
				moveLorann(4);
				break;
			case KeyEvent.VK_RIGHT : case KeyEvent.VK_D :
				moveLorann(3);
				break;
			case KeyEvent.VK_SPACE :
				IElement lorann = model.getMap().getLorann();
				if(((ILorann)lorann).getPossessionSpell().equals(SpellState.NotThrow)){
					((ILorann)lorann).setPossessionSpell(SpellState.Throw);
					model.addSpells(lorann);
					setSpellState(((ILorann)lorann).getState());
				}
				break;
		}
	}
	
	/**
	 * Method to move Lorann in the map
	 * @param state
	 * 			the state of Lorann
	 */
	public void moveLorann(int state){
		IElement lorann = model.getMap().getLorann();
		int x = lorann.getX();
		int y = lorann.getY();
		switch(state){
			case 1:
				((ILorann)lorann).setState(LorannState.UP);
				BubbleKeyCheck(x,y-1,lorann);
				CoinsCheck(x,y-1,lorann);
				DoorCheck(x,y-1,lorann);
				if(!getBlocked(lorann.getX(),lorann.getY()-1)){
					lorann.setPosition(x, y-1);
				}
				break;
			case 2:
				((ILorann)lorann).setState(LorannState.DOWN);
				BubbleKeyCheck(x,y+1,lorann);
				CoinsCheck(x,y+1,lorann);
				DoorCheck(x,y+1,lorann);
				if(!getBlocked(x, y +1)){
					lorann.setPosition(x, y+1);	
				}
				break;
			case 3:
				((ILorann)lorann).setState(LorannState.RIGHT);

				BubbleKeyCheck(x+1,y,lorann);
				CoinsCheck(x+1,y,lorann);
				DoorCheck(x+1,y,lorann);
				if(!getBlocked(x + 1, y)){
					lorann.setPosition(x +1, y);
				}
				break;
			case 4:
				((ILorann)lorann).setState(LorannState.LEFT);
				BubbleKeyCheck(x-1,y,lorann);
				CoinsCheck(x-1,y,lorann);
				DoorCheck(x-1,y,lorann);
				if(!getBlocked(x - 1, y)){
					lorann.setPosition(x - 1, y);
				}
				break;
				
		}model.change();
	}


	/**
	 * Method that check if the element is a BubbleKey or not
	 * @param x
	 * 			The x position of the BubbleKey on a landmark o,x,y.
	 * @param y
	 * 			The y position of the BubbleKey on a landmark o,x,y.
	 * @param lorann
	 * 				The hero
	 */
	private void BubbleKeyCheck(int x, int y, IElement lorann){

		IElement bubblekey = model.getMap().getElement(x, y);
		if(bubblekey instanceof IBubbleKey){
			lorann.setPosition(x, y);
			model.addFloor(lorann, x, y);
			model.setScore(model.getScore()+400);
			for(IElement[] e : model.getMap().getElements()){
				for(IElement element : e){
					if(element instanceof IDoor){
						((IDoor)element).setDoorState(DoorState.OPEN);
						element.getSprite().setImage("sprite/gate_open.png");
					}
				}
			}
		}
	}
	
	/**
	 * Method that check if the element is a Coin or not
	 * @param x
	 * 			The x position of the coins on a landmark o,x,y.
	 * @param y
	 * 			The y position of the coins on a landmark o,x,y.
	 * @param lorann
	 * 			The hero
	 */
	private void CoinsCheck(int x, int y, IElement lorann){
		IElement coins = model.getMap().getElement(x, y);
		if (coins instanceof ICoins){
			lorann.setPosition(x, y);
			model.addFloor(lorann, x, y);
			model.setScore(model.getScore()+200);
		}
	}
	
	/**
	 * Method that check if the element is a Door or not
	 * @param x
	 * 			The x position of the door on a landmark o,x,y.
	 * @param y
	 * 			The y position of the door on a landmark o,x,y.
	 * @param lorann
	 * 			The hero
	 */
	private void DoorCheck(int x, int y, IElement lorann){
		IElement door = model.getMap().getElement(x, y);
		if (door instanceof IDoor){
			if(((IDoor)door).getDoorState().equals(DoorState.OPEN)){
				int id = model.getId();
				if ( id+1 < model.getMaps().size()){
					model.setId(id +1);
				}else {
					model.setGameState(GameState.Congratulation);
				}
				System.out.println(model.getId());
				lorann.setPosition(x, y);
			}else if (((IDoor)door).getDoorState().equals(DoorState.CLOSE)){
				model.setGameState(GameState.GAMEOVER);
			}

		}
	}
	
	/**
	 * Method to move mobile element
	 */
	public void moveMobileElement(){
		try{
			moveDemon();
			moveSpell();
		}catch(Exception ex){};	
	}
	
	/**
	 * Method to move demon
	 */
	public void moveDemon(){		
		for(IMobileElement demon : model.getMap().getMobiles()){
			int x = ((IElement)demon).getX();
			int y = ((IElement)demon).getY();
			IElement lorann = model.getMap().getLorann();
			int x2 = lorann.getX();
			int y2 = lorann.getY();
			demonContact(demon, lorann);
				
			if(x < x2 && !getBlocked(x+1,y)){
				((IElement)demon).setPosition(x+1, y );
			}else if (x > x2 && !getBlocked(x-1,y)){
				((IElement)demon).setPosition(x-1, y);
			}else if (x < x2 && getBlocked(x+1,y)){
				if(y < y2 && !getBlocked(x,y+1)){
					((IElement)demon).setPosition(x, y+1);
				}else if (y > y2 && !getBlocked(x,y -1)){
					((IElement)demon).setPosition(x, y -1);
				}
			}else if (x > x2 && getBlocked(x-1,y)){
				if(y < y2 && !getBlocked(x,y+1)){
					((IElement)demon).setPosition(x, y+1);
				}else if (y > y2 && !getBlocked(x,y -1)){
					((IElement)demon).setPosition(x, y -1);
				}
			}

			if(y < y2 && !getBlocked(x,y+1)){
				((IElement)demon).setPosition(x, y+1);
			}else if (y > y2 && !getBlocked(x,y -1)){
				((IElement)demon).setPosition(x, y -1);
			}else if (y < y2 && getBlocked(x,y+1)){
				if(x < x2 && !getBlocked(x+1,y)){
					((IElement)demon).setPosition(x+1, y );
				}else if (x > x2 && !getBlocked(x-1,y)){
					((IElement)demon).setPosition(x-1, y);
				}
			}else if (y > y2 && getBlocked(x,y -1)){
				if(x < x2 && !getBlocked(x+1,y)){
					((IElement)demon).setPosition(x+1, y );
				}else if (x > x2 && !getBlocked(x-1,y)){
					((IElement)demon).setPosition(x-1, y);
				}
			}model.change();	
		}
	}
	
	/**
	 * Method to check the contact between a demon and different elements
	 * @param demon
	 * 			It's a mobile element
	 * @param lorann
	 * 			It's an element
	 */
	public void demonContact(IMobileElement demon, IElement lorann)
	{
		IElement spell = model.getMap().getSpell();
		if(((IElement)demon).getX()== lorann.getX() && ((IElement)demon).getY()== lorann.getY()){
			model.setGameState(GameState.GAMEOVER);
		}else if(spell!=null &&((IElement)demon).getX() == spell.getX() && ((IElement)demon).getY() == spell.getY()){
			model.getMap().getMobiles().remove(demon);
			model.getMap().setSpell(null);
			model.setScore(model.getScore()+100);
			((ILorann)model.getMap().getLorann()).setPossessionSpell(SpellState.NotThrow);
		}
	}

	/**
	 * Update the state of Spell depending on the state of Lorann
	 * @param state
	 * 		the state of Lorann
	 */
	private void setSpellState(LorannState state){
		IElement spell = model.getMap().getSpell();
		if(state == LorannState.UP){
			((ISpell)spell).setState(SpellState.UP);
		}else if (state == LorannState.DOWN){
			((ISpell)spell).setState(SpellState.DOWN);
		}else if (state == LorannState.LEFT){
			((ISpell)spell).setState(SpellState.LEFT);
		}else if (state == LorannState.RIGHT){
			((ISpell)spell).setState(SpellState.RIGHT);
		}
	}
	
	/**
	 * Method to move spell
	 */
	public void moveSpell(){
			IElement spell = model.getMap().getSpell();
			int x = spell.getX();
			int y = spell.getY();
			spellContact(spell);
			if (((ISpell)spell).getState().equals(SpellState.UP)){
				if(getBlocked(x,y-1)){
					((ISpell)spell).setState(SpellState.DOWN);
				}else{
					spell.setPosition(x, y-1);
				}
			}else if (((ISpell)spell).getState().equals(SpellState.DOWN)){
				if(getBlocked(x,y+1)){
					((ISpell)spell).setState(SpellState.UP);
				}else{
					spell.setPosition(x, y+1);
				}
			}else if (((ISpell)spell).getState().equals(SpellState.RIGHT)){
				if(getBlocked(x+1,y)){
					((ISpell)spell).setState(SpellState.LEFT);
				}else{
					spell.setPosition(x+1, y);
				}
			}else if (((ISpell)spell).getState().equals(SpellState.LEFT)){
				if(getBlocked(x-1,y)){
					((ISpell)spell).setState(SpellState.RIGHT);
				}else{
					spell.setPosition(x-1, y);
				}
			}model.change();
	}
	
	/**
	 * Method to check the contact between the spell and different elements
	 * @param spell
	 * 			It's an element
	 */
	public void spellContact(IElement spell){
		IElement lorann = model.getMap().getLorann();
		if(lorann.getX()== spell.getX() && lorann.getY()==spell.getY()){
			((ILorann)lorann).setPossessionSpell(SpellState.NotThrow);
			model.getMap().setSpell(null);
		}
		for(IMobileElement demon : model.getMap().getMobiles()){
			if(((IElement)demon).getX()== spell.getX() && ((IElement)demon).getY()== spell.getY()){
				model.getMap().getMobiles().remove(demon);
				model.getMap().setSpell(null);
				((ILorann)model.getMap().getLorann()).setPossessionSpell(SpellState.NotThrow);
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IController#update()
	 */
	public void update(){
		updateSprites();
		moveMobileElement();

	}
	
	/**
	 * Method to update the image of the spell and Lorann
	 */
	private void updateSprites(){
		((IAnimateSprite)model.getMap().getLorann().getSprite()).nextImage();
		if(model.getMap().getSpell()!=null){
			((IAnimateSprite)model.getMap().getSpell().getSprite()).nextImage();
		}
		
	}
	

}