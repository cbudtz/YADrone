package area51.drone.opencv.test;

import java.net.InetAddress;

import de.yadrone.base.exception.IExceptionListener;

abstract class ICommandManager extends de.yadrone.base.command.CommandManager{

	public ICommandManager(InetAddress inetaddr, IExceptionListener excListener) {
		super(inetaddr, excListener);
	}

}
