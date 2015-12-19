package dtu.cdio.tutorial;

import de.yadrone.base.IARDrone;

public class Program implements Runnable, Commander {

	private IARDrone drone;
	private volatile boolean doStop = false;
	public Program(IARDrone drone){
		this.drone = drone;
	}
	@Override
	public void run() {

		while(!doStop){
			drone.spinLeft();
			delay(100);
		}
	}

	public void delay(long msec){
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
		}
	}

	public synchronized void setYaw(int yaw){
		if(yaw < 0) {
			drone.landing();
			doStop = true;
		}
	}

}
