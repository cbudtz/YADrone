package de.yadrone.apps.tutorial;

import de.yadrone.base.IARDrone;
import de.yadrone.base.navdata.AttitudeListener;
import de.yadrone.base.navdata.BatteryListener;
import de.yadrone.base.navdata.ControlState;
import de.yadrone.base.navdata.DroneState;
import de.yadrone.base.navdata.StateListener;

public class TutorialAttitudeListener
{

	private final IARDrone drone;

	public TutorialAttitudeListener(final IARDrone drone)
	{
		this.drone = drone;
		drone.getNavDataManager().addAttitudeListener(new AttitudeListener() {
			
			public void attitudeUpdated(float pitch, float roll, float yaw)
			{
		    	System.out.println("Pitch: " + pitch + " Roll: " + roll + " Yaw: " + yaw);
			}

			public void attitudeUpdated(float pitch, float roll) { }
			public void windCompensation(float pitch, float roll) { }
		});
		
		drone.getNavDataManager().addBatteryListener(new BatteryListener() {
			
			public void batteryLevelChanged(int percentage)
			{
				System.out.println("Battery: " + percentage + " %");
			}
			
			public void voltageChanged(int vbat_raw) { }
		});
//		StateListener stateListener = new StateListener() {
//			
//			@Override
//			public void stateChanged(DroneState state) {
//				System.out.println("Drone changed State");
//				System.out.println("Emergency :" + state.isEmergency());
//				if (state.isEmergency()){
//					drone.getCommandManager().emergency();
//				}
//				
//			}
//			
//			@Override
//			public void controlStateChanged(ControlState state) {
//				System.out.println("Drone changed controlstate to : " + state);
//				
//			}
//			
//		};
//		drone.getNavDataManager().addStateListener(stateListener);
		
	}

}
