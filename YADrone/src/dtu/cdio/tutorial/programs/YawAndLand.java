package dtu.cdio.tutorial.programs;

import java.awt.image.BufferedImage;

import de.yadrone.base.IARDrone;

/**
 * 
 * @author Runi
 * simple example code to autonomously control drone.
 * rotates drone on the spot while angle is >0 then land.
 * remember to add listeners. otherwise you will not get any updates
 */
public class YawAndLand extends ProgramImpl{

	private IARDrone drone;
	private boolean doStop;
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
		drone.takeOff();
		while(!doStop){
			drone.spinLeft();
			delay(100);
		}
		drone.landing();
	}

	@Override
	public void attitudeUpdated(float pitch, float roll, float yaw) {
		if(yaw < 0) doStop = true;
	};

	public void delay(long msec){
		try{
			Thread.sleep(msec);
		}catch(InterruptedException e){
			
		}
	}

	@Override
	public void imageUpdated(BufferedImage image) {
		// TODO Auto-generated method stub
		
	}

}
