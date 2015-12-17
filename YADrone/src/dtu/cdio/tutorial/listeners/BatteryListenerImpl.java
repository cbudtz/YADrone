package dtu.cdio.tutorial.listeners;

import de.yadrone.base.navdata.BatteryListener;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;

public class BatteryListenerImpl implements BatteryListener {

	private DroneVariablesGUI gui;
	private int prevBattery;
	private int batteryMaxDelta;
	
	public BatteryListenerImpl(DroneVariablesGUI gui) {
		this.gui = gui;
		if(gui != null) gui.addListenerName("battery listener");
	}

	@Override
	public void batteryLevelChanged(int percentage) {
		if(gui != null){
			gui.setBattery(percentage);
			
		}
	}

	@Override
	public void voltageChanged(int vbat_raw) {
		// TODO Auto-generated method stub

	}

}
