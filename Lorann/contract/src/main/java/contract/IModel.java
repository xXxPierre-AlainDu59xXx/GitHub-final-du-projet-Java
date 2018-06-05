package contract;

import java.awt.Graphics;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import view.IMap;
import model.Example;
import model.GameState;
import model.IElement;


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
	
    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    Example getExampleById(int id) throws SQLException;

    /**
     * Gets the example by name.
     *
     * @param name
     *            the name
     * @return the example by name
     * @throws SQLException
     *             the SQL exception
     */
    Example getExampleByName(String name) throws SQLException;

    /**
     * Gets the all examples.
     *
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
     */
    List<Example> getAllExamples() throws SQLException;


	/**
     * Gets the all sprites.
     *
     * @return the all sprites
     * @throws SQLException
     *             the SQL exception
     */
    List<Example> getAllSprites() throws SQLException;
}