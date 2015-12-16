package de.yadrone.apps.tutorial;


import de.yadrone.apps.paperchase.controller.PaperChaseKeyboardController;
import de.yadrone.base.ARDrone;
import de.yadrone.base.IARDrone;
import de.yadrone.base.command.ConfigureCommand;
import de.yadrone.base.command.ControlCommand;
import de.yadrone.base.command.ControlMode;
import de.yadrone.base.command.EmergencyCommand;
import de.yadrone.base.command.LEDAnimation;
import de.yadrone.base.command.VideoChannel;
import de.yadrone.base.exception.ARDroneException;
import de.yadrone.base.exception.IExceptionListener;
import de.yadrone.base.navdata.Altitude;
import de.yadrone.base.navdata.AltitudeListener;

public class TutorialMain
{

	public static void main(String[] args)
	{
		IARDrone drone = null;
		try
		{
			
			// Tutorial Section 1
			drone = new ARDrone();
			//			drone.addExceptionListener(new IExceptionListener() {
			//				public void exeptionOccurred(ARDroneException exc)
			//				{
			//					exc.printStackTrace();
			//				}
			//			});

			drone.start();

			drone.getCommandManager().setVideoChannel(VideoChannel.HORI);
			// Tutorial Section 2
//			TutorialAttitudeListener alt = new TutorialAttitudeListener(drone);
			drone.getNavDataManager().addAltitudeListener(new AltitudeListener() {
				
				@Override
				public void receivedExtendedAltitude(Altitude d) {
					System.err.println("altitude ext: " + d.getObsAlt());
				}
				
				@Override
				public void receivedAltitude(int altitude) {
					System.out.println("altitude simple: " + altitude);
				}
			});
			// Tutorial Section 3
			new TutorialVideoListener(drone);
			
						new TutorialVideoListener(drone);

			// Tutorial Section 4
			TutorialCommander commander = new TutorialCommander(drone);
			commander.animateLEDs();
			commander.takeOffAndLand();
			
//			commander.leftRightForwardBackward();
//			TutorialCommander commander = new TutorialCommander(drone);
//			System.out.println(drone.getCommandManager().isConnected());
//			System.out.println(drone.getConfigurationManager().isConnected());

			//			commander.animateLEDs();
			//	commander.takeOffAndLand();
			//commander.leftRightForwardBackward();
			//commander.forward();
			//commander.land();
			//drone.getCommandManager().setCommand(new ClearEmergencyCommand());
			PaperChaseKeyboardController k = new PaperChaseKeyboardController(drone);
			k.start();
			Thread.sleep(10000);
				System.err.println("Taking off");
			drone.getCommandManager().takeOff();
			Thread.sleep(5000);
			drone.getCommandManager().forward(10);
			Thread.sleep(200);
			drone.getCommandManager().backward(10);
			Thread.sleep(8000);
			drone.landing();
			Thread.sleep(50000);
			

		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		finally
		{
			if (drone != null)
				drone.stop();

			System.exit(0);
		}
	}
}
