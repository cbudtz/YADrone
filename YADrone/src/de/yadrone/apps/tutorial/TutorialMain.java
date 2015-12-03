package de.yadrone.apps.tutorial;


import de.yadrone.apps.paperchase.controller.PaperChaseKeyboardController;
import de.yadrone.base.ARDrone;
import de.yadrone.base.IARDrone;
<<<<<<< HEAD
=======
import de.yadrone.base.command.ConfigureCommand;
import de.yadrone.base.command.ControlCommand;
import de.yadrone.base.command.ControlMode;
import de.yadrone.base.command.EmergencyCommand;
import de.yadrone.base.command.LEDAnimation;
import de.yadrone.base.command.VideoChannel;
>>>>>>> branch 'master' of https://github.com/cbudtz/YADrone.git
import de.yadrone.base.exception.ARDroneException;
import de.yadrone.base.exception.IExceptionListener;

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
<<<<<<< HEAD
			
			
=======
			drone.getCommandManager().setVideoChannel(VideoChannel.HORI);

>>>>>>> branch 'master' of https://github.com/cbudtz/YADrone.git
			// Tutorial Section 2
			new TutorialAttitudeListener(drone);

			// Tutorial Section 3
<<<<<<< HEAD
			new TutorialVideoListener(drone);
			
=======
						new TutorialVideoListener(drone);

>>>>>>> branch 'master' of https://github.com/cbudtz/YADrone.git
			// Tutorial Section 4
<<<<<<< HEAD
			TutorialCommander commander = new TutorialCommander(drone);
			commander.animateLEDs();
			commander.takeOffAndLand();
			
//			commander.leftRightForwardBackward();
=======
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
			

>>>>>>> branch 'master' of https://github.com/cbudtz/YADrone.git
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
