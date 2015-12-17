package dtu.cdio.tutorial.listeners;

import de.yadrone.base.navdata.ControlState;
import de.yadrone.base.navdata.DroneState;
import de.yadrone.base.navdata.StateListener;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;

public class StateListenerImpl implements StateListener {

	private DroneVariablesGUI gui;
	public StateListenerImpl(DroneVariablesGUI gui){
		this.gui = gui;
	}
	@Override
	public void stateChanged(DroneState state) {
		if(gui != null){
			gui.setStateAcquisitionThreadOn(state.isAcquisitionThreadOn());
			gui.setStateADCWatchdogDelayed(state.isADCWatchdogDelayed());
			gui.setStateAltitudeControlActive(state.isAltitudeControlActive());
			gui.setStateAngelsOutOfRange(state.isAngelsOutOufRange());
			gui.setStateATCodedThreadOn(state.isATCodedThreadOn());
			gui.setStateBatteryTooHigh(state.isBatteryTooHigh());
			gui.setStateBatteryTooLow(state.isBatteryTooLow());
			gui.setStateCameraReady(state.isCameraReady());
			gui.setStateCommunicationLost(state.isCommunicationLost());
			gui.setStateCommunicationProblemOccured(state.isCommunicationProblemOccurred());
			gui.setStateControlReceived(state.isControlReceived());
			gui.setStateControlWatchDogDelayed(state.isControlWatchdogDelayed());
			gui.setStateCutoutSystemDetected(state.isCutoutSystemDetected());
			gui.setStateEmergency(state.isEmergency());
			gui.setStateFlying(state.isFlying());
			gui.setStateGyrometersDown(state.isGyrometersDown());
			gui.setStateMagnetoCalibrationNeeded(state.isMagnetoCalibrationNeeded());
			gui.setStateMotorsDown(state.isMotorsDown());
			gui.setStateNavDataBootstrap(state.isNavDataBootstrap());
			gui.setStateNavdataDemoOnly(state.isNavDataDemoOnly());
			gui.setStateNavdataThreadOn(state.isNavDataThreadOn());
			gui.setStateNotEnoughPower(state.isNotEnoughPower());
			gui.setStatePICVersionNumberOK(state.isPICVersionNumberOK());
			gui.setStateSoftwareFaultDetected(state.isSoftwareFaultDetected());
			gui.setStateTimerElapsed(state.isTimerElapsed());
			gui.setStateTooMuchWind(state.isTooMuchWind());
			gui.setStateTravellingMask(state.isTravellingMask());
			gui.setStateTrimReceived(state.isTrimReceived());
			gui.setStateTrimRunning(state.isTrimRunning());
			gui.setStateTrimSucceeded(state.isTrimSucceeded());
			gui.setStateUltrasonicSensorDeaf(state.isUltrasonicSensorDeaf());
			gui.setStateUsbKeyReady(state.isUsbKeyReady());
			gui.setStateUserEmergencyLanding(state.isUserEmergencyLanding());
			gui.setStateUserFeedbackOn(state.isUserFeedbackOn());
			gui.setStateVideoEnabled(state.isVideoEnabled());
			gui.setStateVideoThreadOn(state.isVideoThreadOn());
			gui.setStateVisionDefined(state.isVisionDefined());
			gui.setStateVisionEnabled(state.isVisionEnabled());

		}
	}

	@Override
	public void controlStateChanged(ControlState state) {
		if(gui != null) gui.setCtrlState(state.name());
	}

}
