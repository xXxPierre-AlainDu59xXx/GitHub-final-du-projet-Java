package contract;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import contract.IMap;


public interface IModel {


	public int getScore();
	
	
	public void setScore(int score); 
	

	public int getId();
	

	public void setId(int id);
	
	
	public ArrayList<IMap> getMaps();
	
	
	IMap getMap();
	  
	
	Observable getObservable();
	
	
	void addObserver(Observer observer);
	
	
	public void change();
	
	
	public void addSpells(IElement lorann);
	
	
	public void addFloor(IElement lorann, int x ,int y);
	
	
	public GameState getGameState();
	

	public void setGameState(GameState gameState);
	
	
	public void GameOver(Graphics graphics);
	
	
	public void Congratulations(Graphics graphics);
}