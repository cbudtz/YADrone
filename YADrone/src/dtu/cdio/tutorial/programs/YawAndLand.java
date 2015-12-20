package dtu.cdio.tutorial.programs;

import java.awt.image.BufferedImage;

import de.yadrone.base.IARDrone;
import de.yadrone.base.navdata.ControlState;
import de.yadrone.base.navdata.DroneState;
import dtu.cdio.tutorial.listeners.AltitudeListenerImpl;
import dtu.cdio.tutorial.listeners.AttitudeListenerImpl;
import dtu.cdio.tutorial.listeners.BatteryListenerImpl;
import dtu.cdio.tutorial.listeners.GyroListenerImpl;
import dtu.cdio.tutorial.listeners.PressureListenerImpl;
import dtu.cdio.tutorial.listeners.SpeedListenerImpl;
import dtu.cdio.tutorial.listeners.StateListenerImpl;
import dtu.cdio.tutorial.listeners.VideoListenerImpl;

/**
 * 
 * @author Runi
 * simple example code to autonomously control drone.
 * rotates drone on the spot while angle is >0 then land.
 * remember to add listeners. otherwise you will not get any updates
 */
public class YawAndLand extends ProgramImpl{

	private IARDrone drone;
	private volatile boolean doStop;
	private volatile boolean isFlying;
	public YawAndLand(IARDrone drone){
		this.drone = drone;
		drone.addSpeedListener(this);
		drone.getNavDataManager().addAltitudeListener(this);
		drone.getNavDataManager().addAttitudeListener(this);
		drone.getNavDataManager().addBatteryListener(this);
		drone.getNavDataManager().addGyroListener(this);
		drone.getNavDataManager().addPressureListener(this);
		drone.getNavDataManager().addStateListener(this);
		drone.getVideoManager().addImageListener(this);	
	}
	
	@Override
	public void run() {
		// only takeoff if not already flying. otherwise the drone will crash.
		if(!isFlying) drone.takeOff(); 
		
		// program main loop.
		while(!doStop){
			drone.spinLeft();
			delay(100);
		}
		
		// when program is done we land
		drone.landing();
	}

	@Override
	public void attitudeUpdated(float pitch, float roll, float yaw) {
		// stop program if yaw angle is <0
		if(yaw < 0) doStop = true;
	};

	public void delay(long msec){
		try{
			Thread.sleep(msec);
		}catch(InterruptedException e){
			
		}
	}
	
	@Override
	public void controlStateChanged(de.yadrone.base.navdata.ControlState state) {
		if(state.equals(ControlState.LANDED)){
			isFlying = false;
		}else{
			isFlying = true;
		}
	};
	
	@Override
	public void stateChanged(DroneState state) {
		
	};

	@Override
	public void imageUpdated(BufferedImage image) {
		// TODO Auto-generated method stub
		
	}

}
