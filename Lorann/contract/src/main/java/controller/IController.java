
	package controller;

	import java.awt.event.KeyEvent;


	 // <b>The Interface IController.</b>
	 // @author Corentin Devrouete

	public interface IController {

		/**
		 * Method for KeyEvent
		 * @param e 
		 * 		it's a key Event
		 */
		public void keyEvents(KeyEvent e);
		public void update();

	}

