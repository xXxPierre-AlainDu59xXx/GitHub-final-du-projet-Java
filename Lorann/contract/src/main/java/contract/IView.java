package contract;

import controller.IController;

public interface IView {
	int HEIGHT = 460;
	int WIDTH = 646;
	

	public void setController(IController controler);
	
    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);

}
