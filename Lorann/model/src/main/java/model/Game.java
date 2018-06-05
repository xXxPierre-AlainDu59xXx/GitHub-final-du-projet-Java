package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.imageio.ImageIO;
import contract.*;
import controller.Permeability;
import view.IMap;

/**
*<b>The Game class represents the entire game</b>
*The Game class represents the entire game
* The class Game consists to:
* <ul>
* <li>Download the map</li>
* <li>Download the database</li>
* </ul>
* @author Corentin Devrouete
* @version 16.06.16
*/
@SuppressWarnings("unused")
public class Game extends Observable implements IModel {

	public IMap map;
	private DBGame dbgame;
	private GameState gameState;
	private ArrayList<IMap> maps;
	public int id ;
	public int score = 0;

	/**
	 * Initialize the game
	 */
	public Game(){
		dbgame = new DBGame();
		gameState = GameState.OK;
		maps = new ArrayList<IMap>();
		initMap();
		this.id=3;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IGame#getMaps()
	 */
	public ArrayList<IMap> getMaps() {
		return maps;
	}

	/*
	 * (non-Javadoc)
	 * @see contract.IGame#getMap()
	 */
	public IMap getMap(){
		return maps.get(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IGame#getId()
	 */
	public int getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * @see contract.IGame#setId(int)
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IGame#getScore()
	 */
	public int getScore() {
		return score;
	}

	/*
	 * (non-Javadoc)
	 * @see contract.IGame#setScore(int)
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Method to initialize map
	 */
	private void initMap() {
		try {
			ResultSet resultMaps = dbgame.procedure("{call allMap()}");
			while(resultMaps.next()){
				loadsMap(resultMaps.getInt("IDmap"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		change();
	}

	/**
	 * Method to load map
	 * @param idMap
	 * 			It's the idMap in the database
	 */
	public void loadsMap(int idMap){
		Map map = new Map(20,12);
		try {
			ResultSet result = dbgame.procedure("{call elementMap(?)}", idMap);
			while(result.next()){
				int x = result.getInt("x");
				int y = result.getInt("y");
				int idElement = result.getInt("IDelement");
				String url = result.getString("url");
				System.out.println(idElement);
				System.out.println(url);
				switch(idElement){
				case 1: case 2: case 3:
					map.addElement(new Wall(x, y,url),x,y);
					break;
				case 4:
					map.addElement(new BubbleKey(x, y, url), x, y);
					break;
				case 6:
					IElement door = new Door(x, y, url);
					map.addElement(door, x, y);
					break;
				case 7:
					map.setLorann(new Lorann(x, y,url));
					break;
				case 8: case 9 : case 10: case 11:
					map.addMobiles(new Demon(x, y, url));
					break;
				case 12:
					map.addElement(new Coins(x, y, url), x, y);
					break;
				case 13:
					map.addElement(new Floor(x, y, url), x, y);
					break;
				}
			}
			maps.add(map);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see contract.IGame#change()
	 */
	public void change(){
		setChanged();
		notifyObservers();
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IGame#addSpells(contract.IElement)
	 */
	public void addSpells(IElement lorann){
		int x =lorann.getX();
		int y =lorann.getY();
		if(((ILorann)lorann).getState().equals(LorannState.UP)&& getMap().getElement(x, y-1).getPermeability().equals(Permeability.PENETRABLE)){
			y --;
		}else if (((ILorann)lorann).getState().equals(LorannState.DOWN)&& getMap().getElement(x, y+1).getPermeability().equals(Permeability.PENETRABLE)){
			y ++;
		}else if (((ILorann)lorann).getState().equals(LorannState.RIGHT) && getMap().getElement(x+1, y).getPermeability().equals(Permeability.PENETRABLE)){
			x ++;
		}else if (((ILorann)lorann).getState().equals(LorannState.LEFT) && getMap().getElement(x-1, y).getPermeability().equals(Permeability.PENETRABLE)){
			x --;
		}
		getMap().setSpell(new Spell(x,y,"sprite/fireball_1.png"));
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IGame#addFloor(contract.IElement, int, int)
	 */
	public void addFloor(IElement lorann, int x ,int y){
		getMap().addElement(new Floor(lorann.getX(),lorann.getY(),"sprite/floor.jpg"),x,y);
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IGame#getGamestate()
	 */
	public GameState getGameState() {
		return gameState;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IGame#setGamestate(contract.GameState)
	 */
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IGame#GameOver(java.awt.Graphics)
	 */
	public void GameOver(Graphics graphics){
		Image image;
		try {
			image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("sprite/you_loose.jpg"));
			graphics.drawImage(image, 0, 0, null);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see contract.IGame#Congratulations(java.awt.Graphics)
	 */
	public void Congratulations(Graphics graphics){
		Image image;
		try {
			image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("sprite/you_won.png"));
			graphics.drawImage(image, 0, 0, null);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see contract.IGame#getObservable()
	 */
	public Observable getObservable(){
		return null;
	}

	@Override
	public Example getExampleById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Example getExampleByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Example> getAllExamples() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Example> getAllSprites() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}