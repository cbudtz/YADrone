package dtu.cdio.tutorial;


import de.yadrone.base.ARDrone;
import de.yadrone.base.command.LEDAnimation;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;
import dtu.cdio.tutorial.listeners.AltitudeListenerImpl;
import dtu.cdio.tutorial.listeners.AttitudeListenerImpl;
import dtu.cdio.tutorial.listeners.BatteryListenerImpl;
import dtu.cdio.tutorial.listeners.ButtonEventListener;
import dtu.cdio.tutorial.listeners.GyroListenerImpl;
import dtu.cdio.tutorial.listeners.PressureListenerImpl;
import dtu.cdio.tutorial.listeners.SpeedListenerImpl;
import dtu.cdio.tutorial.listeners.StateListenerImpl;
import dtu.cdio.tutorial.listeners.VideoListenerImpl;
import dtu.cdio.tutorial.programs.YawAndLand;

/**
 * 
 * @author Runi
 * example code to use debug GUI with any program
 */
public class TutorialMain
{
	DroneVariablesGUI gui;
	private ARDrone drone;
	public volatile boolean isFlying = false;
	public static void main(String[] args)
	{
		new TutorialMain().run();
	}
	public void run(){
		// start gui
		gui = new DroneVariablesGUI();
		gui.setAnimationOptions(LEDAnimation.values());
		new Thread(gui).start();

		// initialize drone
		drone = new ARDrone();
		drone.start();

		// listeners for gui only
		drone.addSpeedListener(new SpeedListenerImpl(gui));
		drone.getNavDataManager().addAttitudeListener(new AttitudeListenerImpl(gui));
		drone.getNavDataManager().addAltitudeListener(new AltitudeListenerImpl(gui));
		drone.getNavDataManager().addBatteryListener(new BatteryListenerImpl(gui));
		drone.getNavDataManager().addGyroListener(new GyroListenerImpl(gui));
		drone.getNavDataManager().addStateListener(new StateListenerImpl(gui));			
		drone.getNavDataManager().addPressureListener(new PressureListenerImpl(gui));
		drone.getVideoManager().addImageListener(new VideoListenerImpl(gui, false));
		
		// someone needs to handle events from buttons
		gui.addButtonListener(new ButtonEventListener(drone, gui));
		
		// adding program to gui so we can execute it when ready
		gui.addProgram(new YawAndLand(drone));
	}
}
