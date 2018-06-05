package model;

import java.awt.Graphics;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import contract.IModel;
import model.dao.ExampleDAO;
import view.IMap;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */
    @Override
    public Example getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleByName(java.lang.String)
     */
    @Override
    public Example getExampleByName(final String name) throws SQLException {
        return ExampleDAO.getExampleByName(name);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllExamples()
     */
    @Override
    public List<Example> getAllExamples() throws SQLException {
        return ExampleDAO.getAllExamples();
    }

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setScore(int score) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<IMap> getMaps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMap getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSpells(IElement lorann) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFloor(IElement lorann, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameState getGameState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGameState(GameState gameState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GameOver(Graphics graphics) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Congratulations(Graphics graphics) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Example> getAllSprites() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
