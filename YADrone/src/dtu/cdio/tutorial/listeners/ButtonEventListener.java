package dtu.cdio.tutorial.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.yadrone.base.IARDrone;
import dtu.cdio.tutorial.gui.DebugGui;
import dtu.cdio.tutorial.gui.DroneVariablesGUI.ButtonCmd;

/**
 * 
 * @author Runi
 * handling all events from gui. That is events from buttons.
 * each button is represented with an enum. use this to override running programs.
 * If any buttons are added, add enum for it as well and add it to switch case.
 */
public class ButtonEventListener implements ActionListener{

	private IARDrone drone;
	private DebugGui gui;
	private Thread runningProgram = null;
	
	public ButtonEventListener(IARDrone drone, DebugGui gui){
		this.drone = drone;
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ButtonCmd cmd;
		try{
			cmd = ButtonCmd.valueOf(e.getActionCommand());
		}catch(Exception ex){
			return;
		}
		switch(cmd){
		case ANIMATION_SET:
			drone.getCommandManager().setLedsAnimation(gui.getAnimationSelected(), gui.getAnimationFrequency(), gui.getAnimationDuration());
			break;
		case AUTO_TRIM:
			drone.getCommandManager().flatTrim();
			break;
		case EMERGENCY:
			drone.getCommandManager().emergency();
			break;
		case FREEZE:
			drone.getCommandManager().freeze();	
			break;
		case HOVER:
			drone.getCommandManager().hover();
			break;
		case LAND:
			drone.getCommandManager().landing();
			break;
		case MANUAL_TRIM:
			drone.getCommandManager().manualTrim(gui.getPitchTrim(), gui.getRollTrim(), gui.getYawTrim());
			break;
		case SPEED_SET:
			drone.setSpeed(gui.getSpeedVal());
			break;
		case TAKE_OFF:
			drone.getCommandManager().takeOff();
			break;
		case RUN_PROGRAM:
			if(runningProgram != null && !runningProgram.isInterrupted()) runningProgram.interrupt();
			runningProgram = new Thread(gui.getSelectedProgram());
			runningProgram.start();
			break;
		default:
			System.err.println("no action bound to button command: " + cmd);
			break;

		}

	}

}
