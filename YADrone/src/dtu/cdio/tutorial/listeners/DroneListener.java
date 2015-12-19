package dtu.cdio.tutorial.listeners;

import de.yadrone.base.ARDrone.ISpeedListener;
import de.yadrone.base.navdata.AltitudeListener;
import de.yadrone.base.navdata.AttitudeListener;
import de.yadrone.base.navdata.BatteryListener;
import de.yadrone.base.navdata.GyroListener;
import de.yadrone.base.navdata.PressureListener;
import de.yadrone.base.navdata.StateListener;
import de.yadrone.base.video.ImageListener;

/**
 * 
 * @author Runi
 * wraps listeners in one. for better overview
 */
public interface DroneListener extends AltitudeListener, AttitudeListener,
		BatteryListener, GyroListener, PressureListener, StateListener,
		ImageListener, ISpeedListener{

}
