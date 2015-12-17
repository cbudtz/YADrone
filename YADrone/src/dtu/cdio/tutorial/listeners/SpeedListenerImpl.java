package dtu.cdio.tutorial.listeners;

import de.yadrone.base.ARDrone.ISpeedListener;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;

public class SpeedListenerImpl implements ISpeedListener {

	private int deltaSpeed;
	private int prevSpeed = 0;
	private DroneVariablesGUI gui;
	public SpeedListenerImpl(DroneVariablesGUI gui){
		this.gui = gui;
	}
	@Override
	public void speedUpdated(int speed) {
		
		if(gui != null) {
			gui.setSpeed(speed);
			if(Math.abs(speed-prevSpeed) > Math.abs(deltaSpeed))
				gui.setSpeedMaxDelta((deltaSpeed = speed-prevSpeed));
		}
		
		prevSpeed = speed;
	}

}
