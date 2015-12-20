/*
 *
  Copyright (c) <2011>, <Shigeo Yoshida>
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
The names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package de.yadrone.base;


import de.yadrone.base.ARDrone.ISpeedListener;
import de.yadrone.base.command.CommandManager;
import de.yadrone.base.configuration.ConfigurationManager;
import de.yadrone.base.exception.IExceptionListener;
import de.yadrone.base.navdata.NavDataManager;
import de.yadrone.base.video.VideoManager;



public interface IARDrone {

	/**
	 * Returns the {@link CommandManager} object. Instantiates a new CommandManager if needed.
	 * @return CommandManager
	 */
	public CommandManager getCommandManager();
	/**
	 * Returns the {@link NavDataManager} object. Instantiates a new NavDataManager if needed.
	 * @return NavDataManager
	 */
	public NavDataManager getNavDataManager();
	/**
	 * Returns the {@link VideoManager} object. Instantiates a new VideoManager if needed.
	 * @return
	 */
	public VideoManager getVideoManager();
	/** 
	 * Returns the {@link ConfigurationManager} object. Instantiates a new Manager if needed.
	 * @return
	 */
	public ConfigurationManager getConfigurationManager();
	
	
	//TODO: cleanup, if kept, factory method should be created for ARDroneInterface
	/**
	 * Instantiates all 4 manager objects.
	 */
	public void start();
	/**
	 * Cleans up manager objects.
	 */
	public void stop();
	
	//camera
	/**
	 * Switches to horizontal camera.
	 */
	public void setHorizontalCamera();//setFrontCameraStreaming()
	/**
	 * Switches to vertical camera.
	 */
	public void setVerticalCamera();//setBellyCameraStreaming()
	/** 
	 * Switches to horizontal camera with small vertical camera image in corner.
	 */
	public void setHorizontalCameraWithVertical();//setFrontCameraWithSmallBellyStreaming()
	/** 
	 * Switches to vertical camera with small horizontal camera image in corner.
	 */
	public void setVerticalCameraWithHorizontal();//setBellyCameraWithSmallFrontStreaming()
	/** 
	 * Switches between cameras
	 */
	public void toggleCamera();
	
	//control command
	/**
	 * Lands drone in a standardized way.
	 */
	public void landing();
	/**
	 * Causes drone to takeOff.
	 */
	public void takeOff();
	/**
	 * Invokes emergency signal on Drone. If drone is already in emergency state, emergency state is cleared.
	 */
	public void reset();
	/**
	 * Causes drone to fly forward with speed specified be setSpeed().
	 */
	public void forward();
	/**
	 * Causes drone to fly backward with speed specified be setSpeed().
	 */
	public void backward();
	/**
	 * Causes drone to rotate right with speed specified be setSpeed().
	 */
	public void spinRight();
	/**
	 * Causes drone to rotate left with speed specified be setSpeed().
	 */
	public void spinLeft();
	/**
	 * Causes drone to fly upward with speed specified be setSpeed()
	 */
	public void up();
	/**
	 * Causes drone to fly downward with speed specified be setSpeed()
	 */
	public void down();
	/**
	 * Causes drone to strafe right with speed specified be setSpeed()
	 */
	public void goRight();
	/**
	 * Causes drone to strafe left with speed specified be setSpeed()
	 */
	public void goLeft();
	/**
	 * Stops drone at current position
	 */
	public void freeze();
	/**
	 * Causes drone to hover at current position
	 */
	public void hover();
	
	//getter
	public int getSpeed();
	/**
	 * Sets speed for all movements in % of maximum speed (which can be configures).
	 * @param speed
	 */
	public void setSpeed(int speed);
	/**
	 * Adds listener for set speed - Not actual flight speed!.
	 * @param speedListener
	 */
	public void addSpeedListener(ISpeedListener speedListener);
	/**
	 * Removes listener for set speed.
	 * @param speedListener
	 */
	public void removeSpeedListener(ISpeedListener speedListener);
	
	public void addExceptionListener(IExceptionListener exceptionListener);
	public void removeExceptionListener(IExceptionListener exceptionListener);
	
	//set max/min altitude
	public void setMaxAltitude(int altitude);
	public void setMinAltitude(int altitude);
	/**
	 * Complex movement - allowing movement in all 3 directions, as well as rotation.
	 * @param speedX
	 * @param speedY
	 * @param speedZ
	 * @param speedSpin
	 */
	public void move3D(int speedX, int speedY, int speedZ, int speedSpin);
}
