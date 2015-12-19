package dtu.cdio.tutorial.listeners;

import de.yadrone.base.navdata.AttitudeListener;
import dtu.cdio.tutorial.Commander;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;

public class AttitudeListenerImpl implements AttitudeListener {

	private DroneVariablesGUI gui;
	private int prevPitchUpdated;
	private int prevRollUpdated;
	private int prevYawUpdated;
	
	private int pitchUpdatedMaxDelta;
	private int rollUpdatedMaxDelta;
	private int yawUpdatedMaxDelta;
	
	private int prevPitchComp;
	private int prevRollComp;
	
	private int pitchCompMaxDelta;
	private int rollCompMaxDelta;
	
	private Commander commander;
	public AttitudeListenerImpl(DroneVariablesGUI gui, Commander commander) {
		this.gui = gui;
		this.commander = commander;
		if(gui != null) gui.addListenerName("attitude listener");
	}

	@Override
	public void attitudeUpdated(float pitch, float roll, float yaw) {
		if(gui != null){
			int pInt = (int) pitch/1000;
			int rInt = (int) roll/1000;
			int yInt = (int) yaw/1000;
			
			gui.setPitchUpdated(pInt);
			gui.setRollUpdated(rInt);
			gui.setYawUpdated(yInt);
			
			if(Math.abs(pitch-prevPitchUpdated) > Math.abs(pitchUpdatedMaxDelta))
				gui.setPitchUpdatedMaxDelta((pitchUpdatedMaxDelta = pInt-prevPitchUpdated));
			if(Math.abs(roll-prevRollUpdated) > Math.abs(rollUpdatedMaxDelta))
				gui.setRollUpdatedMaxDelta((rollUpdatedMaxDelta = rInt-prevRollUpdated));
			if(Math.abs(yaw-prevYawUpdated) > Math.abs(yawUpdatedMaxDelta))
				gui.setYawUpdatedMaxDelta((yawUpdatedMaxDelta = yInt-prevYawUpdated));
			
			prevPitchUpdated = pInt;
			prevRollUpdated = rInt;
			prevYawUpdated = yInt;
			commander.setYaw(yInt);
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
			int pInt = (int) pitch/1000;
			int rInt = (int) roll/1000;
			if(Math.abs(pitch-prevPitchComp) > Math.abs(pitchCompMaxDelta))
				gui.setPitchCompMaxDelta((pitchCompMaxDelta = pInt-prevPitchComp));
			if(Math.abs(roll-prevRollComp) > Math.abs(rollCompMaxDelta))
				gui.setRollCompMaxDelta((rollCompMaxDelta = rInt-prevRollComp));
			
			prevPitchComp = pInt;
			prevRollComp = rInt;
		}
	}

}
