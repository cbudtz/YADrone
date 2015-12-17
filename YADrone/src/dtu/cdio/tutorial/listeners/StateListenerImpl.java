package dtu.cdio.tutorial.listeners;

import de.yadrone.base.navdata.ControlState;
import de.yadrone.base.navdata.DroneState;
import de.yadrone.base.navdata.StateListener;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;

public class StateListenerImpl implements StateListener {

	private DroneVariablesGUI gui;
	public StateListenerImpl(DroneVariablesGUI gui){
		this.gui = gui;
	}
	@Override
	public void stateChanged(DroneState state) {
		if(gui != null) gui.setDroneState(state.toString());
	}

	@Override
	public void controlStateChanged(ControlState state) {
		if(gui != null) gui.setCtrlState(state.name());
	}

}
