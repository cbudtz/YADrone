package dtu.cdio.tutorial.listeners;

import de.yadrone.base.navdata.GyroListener;
import de.yadrone.base.navdata.GyroPhysData;
import de.yadrone.base.navdata.GyroRawData;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;

public class GyroListenerImpl implements GyroListener{

	private DroneVariablesGUI gui;
	public GyroListenerImpl(DroneVariablesGUI gui) {
		this.gui = gui;
	}
	@Override
	public void receivedRawData(GyroRawData d) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void receivedPhysData(GyroPhysData d) {
		float[] g = d.getPhysGyros();
		if(g == null) return;
		if(g.length > 0) gui.setGyroXVal(g[0]);
		if(g.length > 1) gui.setGyroYVal(g[1]);
		if(g.length > 2) gui.setGyroZVal(g[2]);
		if(g.length > 3) System.err.println("phys data length is: " + g.length);
	}
	@Override
	public void receivedOffsets(float[] offset_g) {
		if(offset_g == null) return;
		if(offset_g.length > 0) gui.setGyroXOffset(offset_g[0]);
		if(offset_g.length > 1) gui.setGyroYOffset(offset_g[1]);
		if(offset_g.length > 2) gui.setGyroZOffset(offset_g[2]);
		if(offset_g.length > 3) System.err.println("offset length is: " + offset_g.length);
	}
	
	

}
