package dtu.cdio.tutorial.listeners;

import de.yadrone.base.navdata.ControlState;
import de.yadrone.base.navdata.DroneState;
import de.yadrone.base.navdata.StateListener;
import dtu.cdio.tutorial.TutorialMain;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;

public class StateListenerImpl implements StateListener {

	private DroneVariablesGUI gui;
	private volatile boolean AcquisitionThreadOn = false;
	private volatile boolean ADCWatchdogDelayed = true;
	private volatile boolean AltitudeControlActive = false;
	private volatile boolean AngelsOutOfRange = true;
	private volatile boolean ATCodedThreadOn = false;
	private volatile boolean BatteryTooHigh = true;
	private volatile boolean BatteryTooLow = true;
	private volatile boolean CameraReady = false;
	private volatile boolean CommunicationLost = true;
	private volatile boolean CommunicationProblemOccured = true;
	private volatile boolean ControlReceived = false;
	private volatile boolean ControlWatchDogDelayed = true;
	private volatile boolean CutoutSystemDetected = false;
	private volatile boolean Emergency = true;
	private volatile boolean Flying = false;
	private volatile boolean GyrometersDown = true;
	private volatile boolean MagnetoCalibrationNeeded = true;
	private volatile boolean MotorsDown = true;
	private volatile boolean NavDataBootstrap = false;
	private volatile boolean NavdataDemoOnly = false;
	private volatile boolean NavdataThreadOn = false;
	private volatile boolean NotEnoughPower = true;
	private volatile boolean PICVersionNumberOK = false;
	private volatile boolean SoftwareFaultDetected = true;
	private volatile boolean TimerElapsed = true;
	private volatile boolean TooMuchWind = true;
	private volatile boolean TravellingMask = false;
	private volatile boolean TrimReceived = false;
	private volatile boolean TrimRunning = false;
	private volatile boolean TrimSucceeded = false;
	private volatile boolean UltrasonicSensorDeaf = true;
	private volatile boolean UsbKeyReady = false;
	private volatile boolean UserEmergencyLanding = true;
	private volatile boolean UserFeedbackOn = false;
	private volatile boolean VideoEnabled = false;
	private volatile boolean VideoThreadOn = false;
	private volatile boolean VisionDefined = false;
	private volatile boolean VisionEnabled = false;
	
	public TutorialMain test;
	public StateListenerImpl(DroneVariablesGUI gui, TutorialMain test){
		this.gui = gui;
		this.test = test;
		if(gui != null) gui.addListenerName("state listener");
	}
	@Override
	public synchronized void stateChanged(DroneState state) {
		
		if(gui != null){
			if(AcquisitionThreadOn != state.isAcquisitionThreadOn()) gui.setStateAcquisitionThreadOn(AcquisitionThreadOn = state.isAcquisitionThreadOn());
			if(ADCWatchdogDelayed != state.isADCWatchdogDelayed()) gui.setStateADCWatchdogDelayed(ADCWatchdogDelayed = state.isADCWatchdogDelayed());
			if(AltitudeControlActive != state.isAltitudeControlActive()) gui.setStateAltitudeControlActive(AltitudeControlActive = state.isAltitudeControlActive());
			if(AngelsOutOfRange != state.isAngelsOutOufRange()) gui.setStateAngelsOutOfRange(AngelsOutOfRange = state.isAngelsOutOufRange());
			if(ATCodedThreadOn != state.isATCodedThreadOn()) gui.setStateATCodedThreadOn(ATCodedThreadOn = state.isATCodedThreadOn());
			if(BatteryTooHigh != state.isBatteryTooHigh()) gui.setStateBatteryTooHigh(BatteryTooHigh = state.isBatteryTooHigh());
			if(BatteryTooLow != state.isBatteryTooLow()) gui.setStateBatteryTooLow(BatteryTooLow = state.isBatteryTooLow());
			if(CameraReady != state.isCameraReady()) gui.setStateCameraReady(CameraReady = state.isCameraReady());
			if(CommunicationLost != state.isCommunicationLost()) gui.setStateCommunicationLost(CommunicationLost = state.isCommunicationLost());
			if(CommunicationProblemOccured != state.isCommunicationProblemOccurred()) gui.setStateCommunicationProblemOccured(CommunicationProblemOccured = state.isCommunicationProblemOccurred());
			if(ControlReceived != state.isControlReceived()) gui.setStateControlReceived(ControlReceived = state.isControlReceived());
			if(ControlWatchDogDelayed != state.isControlWatchdogDelayed()) gui.setStateControlWatchDogDelayed(ControlWatchDogDelayed = state.isControlWatchdogDelayed());
			if(CutoutSystemDetected != state.isCutoutSystemDetected()) gui.setStateCutoutSystemDetected(CutoutSystemDetected = state.isCutoutSystemDetected());
			if(Emergency != state.isEmergency()) gui.setStateEmergency(Emergency = state.isEmergency());
			if(Flying != state.isFlying()) gui.setStateFlying(Flying = state.isFlying());
			if(GyrometersDown != state.isGyrometersDown()) gui.setStateGyrometersDown(GyrometersDown = state.isGyrometersDown());
			if(MagnetoCalibrationNeeded != state.isMagnetoCalibrationNeeded()) gui.setStateMagnetoCalibrationNeeded(MagnetoCalibrationNeeded = state.isMagnetoCalibrationNeeded());
			if(MotorsDown != state.isMotorsDown()) gui.setStateMotorsDown(MotorsDown = state.isMotorsDown());
			if(NavDataBootstrap != state.isNavDataBootstrap()) gui.setStateNavDataBootstrap(NavDataBootstrap = state.isNavDataBootstrap());
			if(NavdataDemoOnly != state.isNavDataDemoOnly()) gui.setStateNavdataDemoOnly(NavdataDemoOnly = state.isNavDataDemoOnly());
			if(NavdataThreadOn != state.isNavDataThreadOn()) gui.setStateNavdataThreadOn(NavdataThreadOn = state.isNavDataThreadOn());
			if(NotEnoughPower != state.isNotEnoughPower()) gui.setStateNotEnoughPower(NotEnoughPower = state.isNotEnoughPower());
			if(PICVersionNumberOK != state.isPICVersionNumberOK()) gui.setStatePICVersionNumberOK(PICVersionNumberOK = state.isPICVersionNumberOK());
			if(SoftwareFaultDetected != state.isSoftwareFaultDetected()) gui.setStateSoftwareFaultDetected(SoftwareFaultDetected = state.isSoftwareFaultDetected());
			if(TimerElapsed != state.isTimerElapsed()) gui.setStateTimerElapsed(TimerElapsed = state.isTimerElapsed());
			if(TooMuchWind != state.isTooMuchWind()) gui.setStateTooMuchWind(TooMuchWind = state.isTooMuchWind());
			if(TravellingMask != state.isTravellingMask()) gui.setStateTravellingMask(TravellingMask = state.isTravellingMask());
			if(TrimReceived != state.isTrimReceived()) gui.setStateTrimReceived(TrimReceived = state.isTrimReceived());
			if(TrimRunning != state.isTrimRunning()) gui.setStateTrimRunning(TrimRunning = state.isTrimRunning());
			if(TrimSucceeded != state.isTrimSucceeded()) gui.setStateTrimSucceeded(TrimSucceeded = state.isTrimSucceeded());
			if(UltrasonicSensorDeaf != state.isUltrasonicSensorDeaf()) gui.setStateUltrasonicSensorDeaf(UltrasonicSensorDeaf = state.isUltrasonicSensorDeaf());
			if(UsbKeyReady != state.isUsbKeyReady()) gui.setStateUsbKeyReady(UsbKeyReady = state.isUsbKeyReady());
			if(UserEmergencyLanding != state.isUserEmergencyLanding()) gui.setStateUserEmergencyLanding(UserEmergencyLanding = state.isUserEmergencyLanding());
			if(UserFeedbackOn != state.isUserFeedbackOn()) gui.setStateUserFeedbackOn(UserFeedbackOn = state.isUserFeedbackOn());
			if(VideoEnabled != state.isVideoEnabled()) gui.setStateVideoEnabled(VideoEnabled = state.isVideoEnabled());
			if(VideoThreadOn != state.isVideoThreadOn()) gui.setStateVideoThreadOn(VideoThreadOn = state.isVideoThreadOn());
			if(VisionDefined != state.isVisionDefined()) gui.setStateVisionDefined(VisionDefined = state.isVisionDefined());
			if(VisionEnabled != state.isVisionEnabled()) gui.setStateVisionEnabled(VisionEnabled = state.isVisionEnabled());
		}
		
		test.isFlying = state.isFlying();
	}

	@Override
	public void controlStateChanged(ControlState state) {
		if(gui != null) gui.setCtrlState(state.name());
	}

}
