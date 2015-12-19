package dtu.cdio.tutorial.listeners;

import de.yadrone.base.navdata.Altitude;
import de.yadrone.base.navdata.AltitudeListener;
import dtu.cdio.tutorial.gui.DebugGui;

/**
 * 
 * @author Runi
 * for gui. max delta should show if there is great change in measurements.
 */
public class AltitudeListenerImpl implements AltitudeListener {

	private DebugGui gui;
	private int prevAltitude = 0;
	private int maxDeltaAltitude = 0;
	public AltitudeListenerImpl(DebugGui gui) {
		this.gui = gui;
		if(gui != null) gui.addListenerName("altitude listener");
	}
	@Override
	public void receivedAltitude(int altitude) {
		if(gui != null){
			gui.setAltitude(altitude);
			if(Math.abs(altitude-prevAltitude) > Math.abs(maxDeltaAltitude))
				gui.setAltitudeMaxDelta((maxDeltaAltitude = altitude-prevAltitude));	
		}
		prevAltitude = altitude;
	}

	@Override
	public void receivedExtendedAltitude(Altitude d) {
		// TODO Auto-generated method stub

	}

}
