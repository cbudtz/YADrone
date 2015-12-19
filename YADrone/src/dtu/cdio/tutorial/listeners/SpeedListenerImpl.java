package dtu.cdio.tutorial.listeners;

import de.yadrone.base.ARDrone.ISpeedListener;
import dtu.cdio.tutorial.gui.DebugGui;

/**
 * 
 * @author Runi
 * listener created for GUI. makes user able to see speed.
 */
public class SpeedListenerImpl implements ISpeedListener {


	private DebugGui gui;
	public SpeedListenerImpl(DebugGui gui){
		this.gui = gui;
		if(gui != null) gui.addListenerName("speed listener");
	}
	@Override
	public void speedUpdated(int speed) {
		
		if(gui != null) {
			gui.setSpeed(speed);
		}
		
	}

}
