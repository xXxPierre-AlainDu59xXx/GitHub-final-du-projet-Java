package controller;

/* @author Corentin DEVROUETE 
 * update 1.0
 */

public class Ticks implements Runnable {
	private IController controller;
	
	/**
	 * Initialize
	 * @param controller
	 */ 
	
	public Ticks( IController controller){this.controller = controller;}
	
	@Override
	public void run() {
		try{
			while(true){
				controller.update();
				try{
				Thread.sleep(150);
				}catch(Exception e){e.printStackTrace();}
				}}
		catch(Exception ex){}
		}}
