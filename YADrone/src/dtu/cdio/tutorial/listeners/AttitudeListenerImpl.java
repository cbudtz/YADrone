package dtu.cdio.tutorial.listeners;

import de.yadrone.base.navdata.AttitudeListener;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;

public class AttitudeListenerImpl implements AttitudeListener {

	private DroneVariablesGUI gui;
	private float prevPitchUpdated;
	private float prevRollUpdated;
	private float prevYawUpdated;
	
	private float pitchUpdatedMaxDelta;
	private float rollUpdatedMaxDelta;
	private float yawUpdatedMaxDelta;
	
	private float prevPitchComp;
	private float prevRollComp;
	
	private float pitchCompMaxDelta;
	private float rollCompMaxDelta;
	
	
	public AttitudeListenerImpl(DroneVariablesGUI gui) {
		this.gui = gui;
		if(gui != null) gui.addListenerName("attitude listener");
	}

	@Override
	public void attitudeUpdated(float pitch, float roll, float yaw) {
		if(gui != null){
			gui.setPitchUpdated(pitch);
			gui.setRollUpdated(roll);
			gui.setYawUpdated(yaw);
			
			if(Math.abs(pitch-prevPitchUpdated) > Math.abs(pitchUpdatedMaxDelta))
				gui.setPitchUpdatedMaxDelta((pitchUpdatedMaxDelta = pitch-prevPitchUpdated));
			if(Math.abs(roll-prevRollUpdated) > Math.abs(rollUpdatedMaxDelta))
				gui.setRollUpdatedMaxDelta((rollUpdatedMaxDelta = roll-prevRollUpdated));
			if(Math.abs(yaw-prevYawUpdated) > Math.abs(yawUpdatedMaxDelta))
				gui.setYawUpdatedMaxDelta((yawUpdatedMaxDelta = yaw-prevYawUpdated));
			
			prevPitchUpdated = pitch;
			prevRollUpdated = roll;
			prevYawUpdated = yaw;
		}
	}

	@Override
	public void attitudeUpdated(float pitch, float roll) {
		attitudeUpdated(pitch, roll, 0);
	}

	@Override
	public void windCompensation(float pitch, float roll) {
		if(gui != null){
			gui.setPitchComp(pitch);
			gui.setRollComp(roll);
			
			if(Math.abs(pitch-prevPitchComp) > Math.abs(pitchCompMaxDelta))
				gui.setPitchCompMaxDelta((pitchCompMaxDelta = pitch-prevPitchComp));
			if(Math.abs(roll-prevRollComp) > Math.abs(rollCompMaxDelta))
				gui.setRollCompMaxDelta((rollCompMaxDelta = roll-prevRollComp));
			
			prevPitchComp = pitch;
			prevRollComp = roll;
		}
	}

}
