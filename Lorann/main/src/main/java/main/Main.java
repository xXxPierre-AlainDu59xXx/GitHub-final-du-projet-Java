package main;

import java.io.IOException;

import controller.IController;
import contract.IView;
import contract.IModel;
import controller.Controller;
import model.Game;
import view.Frame;
/**
 * 
 * @author Corentin Devrouete
 * @version 1.3
 */

public abstract class Main {

	/**
	* Method to start the game
	* @param args
	* 		the arguments
	* @throws IOException
	* 		throws the exceptions
	*/
	public static void main(final String[] args) throws IOException {
		IModel game = new Game();
		IView frame = new Frame(game);
		IController control = new Controller(game,frame);
		frame.setController(control);
					
	}

}