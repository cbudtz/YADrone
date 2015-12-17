package dtu.cdio.tutorial.listeners;

import de.yadrone.base.navdata.KalmanPressureData;
import de.yadrone.base.navdata.Pressure;
import de.yadrone.base.navdata.PressureListener;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;

public class PressureListenerImpl implements PressureListener {

	private DroneVariablesGUI gui;
	public PressureListenerImpl(DroneVariablesGUI gui) {
		this.gui = gui;
		if(gui != null) gui.addListenerName("pressure listener");
	}

	@Override
	public void receivedKalmanPressure(KalmanPressureData d) {
		// TODO
	}

	@Override
	public void receivedPressure(Pressure d) {
		if(gui != null) gui.setPressure(d.getValue() + "/" + d.getMeasurement());
	}

}
