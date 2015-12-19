package dtu.cdio.tutorial.programs;

import de.yadrone.base.navdata.Altitude;
import de.yadrone.base.navdata.ControlState;
import de.yadrone.base.navdata.DroneState;
import de.yadrone.base.navdata.GyroPhysData;
import de.yadrone.base.navdata.GyroRawData;
import de.yadrone.base.navdata.HDVideoStreamData;
import de.yadrone.base.navdata.KalmanPressureData;
import de.yadrone.base.navdata.Pressure;
import de.yadrone.base.navdata.VideoStreamData;

/**
 * 
 * @author Runi
 *Wrapper for {@link Program} only necessary to implement needed methods
 */
public abstract class ProgramImpl implements Program{

	@Override
	public abstract void run();

	@Override
	public void receivedAltitude(int altitude) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receivedExtendedAltitude(Altitude d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attitudeUpdated(float pitch, float roll, float yaw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attitudeUpdated(float pitch, float roll) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windCompensation(float pitch, float roll) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batteryLevelChanged(int percentage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void voltageChanged(int vbat_raw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receivedRawData(GyroRawData d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receivedPhysData(GyroPhysData d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receivedOffsets(float[] offset_g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receivedKalmanPressure(KalmanPressureData d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receivedPressure(Pressure d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(DroneState state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controlStateChanged(ControlState state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void speedUpdated(int speed) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString(){
		return this.getClass().getSimpleName();
	}

}
