package main;

import java.io.IOException;

import contract.IController;
import contract.IView;
import contract.IModel;
import controller.Controller;
import model.Game;
import view.Frame;
/**
 * 
 * @author Corentin Devrouete Pierre Alain Tietz Zackaria Lasfar 
 * @version 15.06.2016
 */

public abstract class Main {

	/**
	* Method to start the game
	* @param args
	* @throws IOException
	*/
	public static void main(final String[] args) throws IOException {
		IModel game = new Game();
		IView frame = new Frame(game);
		IController control = new Controller(game,frame);
		frame.setController(control);
					
	}

}