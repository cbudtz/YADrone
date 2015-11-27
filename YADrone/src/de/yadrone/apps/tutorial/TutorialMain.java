package de.yadrone.apps.tutorial;


import de.yadrone.base.ARDrone;
import de.yadrone.base.IARDrone;
import de.yadrone.base.command.ConfigureCommand;
import de.yadrone.base.command.ControlCommand;
import de.yadrone.base.command.ControlMode;
import de.yadrone.base.command.EmergencyCommand;
import de.yadrone.base.command.LEDAnimation;
import de.yadrone.base.exception.ARDroneException;
import de.yadrone.base.exception.IExceptionListener;
import de.yadrone.base.navdata.AttitudeListener;

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

			// Tutorial Section 2
			new TutorialAttitudeListener(drone);

			// Tutorial Section 3
						new TutorialVideoListener(drone);

			// Tutorial Section 4
			TutorialCommander commander = new TutorialCommander(drone);
			System.out.println(drone.getCommandManager().isConnected());
			System.out.println(drone.getConfigurationManager().isConnected());

			//			commander.animateLEDs();
			//	commander.takeOffAndLand();
			//commander.leftRightForwardBackward();
			//commander.forward();
			//commander.land();
			//drone.getCommandManager().setCommand(new ClearEmergencyCommand());
			
			Thread.sleep(2000);
				
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
