package contract;

import controller.IController;

public interface IView {
	int HEIGHT = 700;
	int WIDTH = 700;
	

	public void setController(IController controler);
	
    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);

}
