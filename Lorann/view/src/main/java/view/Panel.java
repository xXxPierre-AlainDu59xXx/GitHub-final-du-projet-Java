package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.*;
import model.GameState;
import model.IBubbleKey;
import model.ICoins;
import model.IDemon;
import model.IDoor;
import model.IElement;
import model.IFloor;
import model.ILorann;
import model.IMobileElement;
import model.IWall;
import model.SpellState;

/** 
 * This class panel is used to display the different elements in the game window 
 * @author Corentin Devrouete
 * @version 1.0
 */

public class Panel extends JPanel implements Observer{

	private static final long serialVersionUID = 508369234136358064L;
	
	private Frame frame;
	
	/**
	 * Initialize the panel
	 * @param frame
	 * 			It's the frame
	 */
	public Panel(Frame frame){
		this.frame = frame;
		this.setBackground(new Color(255,0,255));
		frame.game.addObserver(this);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g){
		clearAll(g);
		int x = 0;
		
		for(IElement[] e : frame.game.getMap().getElements()){
			int y = 0;
			for(IElement element : e){
					if(element instanceof IWall){
						design(g, element.getSprite().getImage(), x, y);
					}else if(element instanceof IBubbleKey){
						design(g, element.getSprite().getImage(), x, y);
					}else if(element instanceof ICoins){
						design(g, element.getSprite().getImage(), x, y);
					}else if(element instanceof IDoor){
						design(g, element.getSprite().getImage(), x, y);
					}else if(element instanceof IDemon){
						design(g, element.getSprite().getImage(), x, y);
					}else if(element instanceof ILorann){
						design(g, element.getSprite().getImage(), x, y);
					}else if(element instanceof IFloor){
						design(g, element.getSprite().getImage(), x, y);
					}
				y++;
			}
			x++;	
		} 
		for(IMobileElement demon : frame.game.getMap().getMobiles()){
			design(g, ((IElement)demon).getSprite().getImage(), ((IElement)demon).getX(),((IElement)demon).getY());
		}
		
		if(!((ILorann)frame.game.getMap().getLorann()).getPossessionSpell().equals(SpellState.NotThrow)){
		design(g, frame.game.getMap().getSpell().getSprite().getImage(),frame.game.getMap().getSpell().getX(), frame.game.getMap().getSpell().getY());}
		design(g, frame.game.getMap().getLorann().getSprite().getImage(),frame.game.getMap().getLorann().getX(), frame.game.getMap().getLorann().getY());
		if(frame.game.getGameState().equals(GameState.GAMEOVER)){
			frame.game.GameOver(g);
		}else if(frame.game.getGameState().equals(GameState.Congratulation)){
			frame.game.Congratulations(g);
		}
		g.setColor(Color.blue);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Score : "+frame.game.getScore(), 20, 424);
			
	}

	/**
	 * Method that draw an image
	 * @param g
	 * @param image
	 * @param x
	 * @param y
	 */
	private void design(Graphics g, Image image, int x, int y) {
		g.drawImage(image, x*32, y*32, 32, 32, null);
	}
	
	/**
	 * Method that clear the screen
	 * @param g
	 */
	private void clearAll(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, IView.WIDTH, IView.HEIGHT);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		
		
		repaint();
	}
}