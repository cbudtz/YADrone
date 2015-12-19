package dtu.cdio.tutorial.listeners;

import de.yadrone.base.navdata.AltitudeListener;
import de.yadrone.base.navdata.AttitudeListener;
import dtu.cdio.tutorial.gui.DebugGui;

/**
 * 
 * @author Runi
 * THIS IS NOT A TYPO. AltitudeListener is here {@link AltitudeListener}.
 * gives info about pitch (front/backward angle), roll (left/right angle) and yaw (drone direction using compass).
 * measurements are in degrees/1000 for appearence shown as degrees in gui.
 */
public class AttitudeListenerImpl implements AttitudeListener {

	private DebugGui gui;
	
	public AttitudeListenerImpl(DebugGui gui) {
		this.gui = gui;
		if(gui != null) gui.addListenerName("attitude listener");
	}

	@Override
	public void attitudeUpdated(float pitch, float roll, float yaw) {
		if(gui != null){
			gui.setPitchUpdated(pitch/1000);
			gui.setRollUpdated(roll/1000);
			gui.setYawUpdated(yaw/1000);		
		}
	}

	@Override
	public void attitudeUpdated(float pitch, float roll) {
		attitudeUpdated(pitch, roll, 0);
	}

	@Override
	public void windCompensation(float pitch, float roll) {
		if(gui != null){
			gui.setPitchComp(pitch/1000);
			gui.setRollComp(roll/1000);
		}
	}

}
