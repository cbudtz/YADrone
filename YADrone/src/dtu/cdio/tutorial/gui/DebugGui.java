package dtu.cdio.tutorial.gui;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import de.yadrone.base.command.LEDAnimation;
import dtu.cdio.tutorial.programs.Program;

public interface DebugGui {

	public abstract void setSpeed(int speed);

	public abstract void setAltitude(int altitude);

	public abstract void setPitchComp(float pitchComp);

	public abstract void setRollComp(float rollComp);

	public abstract void setPitchUpdated(float pitchUpdated);

	public abstract void setRollUpdated(float rollUpdated);

	public abstract void setYawUpdated(float yawUpdated);

	public abstract void setBattery(int battery);

	public abstract void setSpeedMaxDelta(int speedMaxDelta);

	public abstract void setAltitudeMaxDelta(int altitudeMaxDelta);

	public abstract void setPitchCompMaxDelta(float pitchCompMaxDelta);

	public abstract void setRollCompMaxDelta(float rollCompMaxDelta);

	public abstract void setPitchUpdatedMaxDelta(float pitchUpdatedMaxDelta);

	public abstract void setRollUpdatedMaxDelta(float rollUpdatedMaxDelta);

	public abstract void setYawUpdatedMaxDelta(float yawUpdatedMaxDelta);

	public abstract void setCtrlState(String name);

	public abstract void setPressure(String val);

	public abstract void setStateAcquisitionThreadOn(boolean b);

	public abstract void setStateADCWatchdogDelayed(boolean b);

	public abstract void setStateAltitudeControlActive(boolean b);

	public abstract void setStateAngelsOutOfRange(boolean b);

	public abstract void setStateATCodedThreadOn(boolean b);

	public abstract void setStateBatteryTooHigh(boolean b);

	public abstract void setStateBatteryTooLow(boolean b);

	public abstract void setStateCameraReady(boolean b);

	public abstract void setStateCommunicationLost(boolean b);

	public abstract void setStateCommunicationProblemOccured(boolean b);

	public abstract void setStateControlReceived(boolean b);

	public abstract void setStateControlWatchDogDelayed(boolean b);

	public abstract void setStateCutoutSystemDetected(boolean b);

	public abstract void setStateEmergency(boolean b);

	public abstract void setStateFlying(boolean b);

	public abstract void setStateGyrometersDown(boolean b);

	public abstract void setStateMagnetoCalibrationNeeded(boolean b);

	public abstract void setStateMotorsDown(boolean b);

	public abstract void setStateNavDataBootstrap(boolean b);

	public abstract void setStateNavdataDemoOnly(boolean b);

	public abstract void setStateNavdataThreadOn(boolean b);

	public abstract void setStateNotEnoughPower(boolean b);

	public abstract void setStatePICVersionNumberOK(boolean b);

	public abstract void setStateSoftwareFaultDetected(boolean b);

	public abstract void setStateTimerElapsed(boolean b);

	public abstract void setStateTooMuchWind(boolean b);

	public abstract void setStateTravellingMask(boolean b);

	public abstract void setStateTrimReceived(boolean b);

	public abstract void setStateTrimRunning(boolean b);

	public abstract void setStateTrimSucceeded(boolean b);

	public abstract void setStateUltrasonicSensorDeaf(boolean b);

	public abstract void setStateUsbKeyReady(boolean b);

	public abstract void setStateUserEmergencyLanding(boolean b);

	public abstract void setStateUserFeedbackOn(boolean b);

	public abstract void setStateVideoEnabled(boolean b);

	public abstract void setStateVideoThreadOn(boolean b);

	public abstract void setStateVisionDefined(boolean b);

	public abstract void setStateVisionEnabled(boolean b);

	public abstract void setGyroXVal(float val);

	public abstract void setGyroXOffset(float val);

	public abstract void setGyroYVal(float val);

	public abstract void setGyroYOffset(float val);

	public abstract void setGyroZVal(float val);

	public abstract void setGyroZOffset(float val);

	public abstract void addButtonListener(ActionListener listener);

	public abstract void addProgram(Program p);

	public abstract Program getSelectedProgram();

	public abstract float getAnimationFrequency();

	public abstract int getAnimationDuration();

	public abstract void setAnimationOptions(LEDAnimation[] options);

	public abstract LEDAnimation getAnimationSelected();

	public abstract float getRollTrim();

	public abstract float getPitchTrim();

	public abstract float getYawTrim();

	public abstract void setImage(BufferedImage img);

	public abstract void setVideoFrameSize(int width, int height);

	public abstract void showVideoFeed();

	public abstract void hideVideoFeed();

	public abstract void addListenerName(String name);

	public abstract void removeListenerName(String name);

	public abstract int getSpeedVal();

}