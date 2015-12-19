package dtu.cdio.tutorial.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;

import de.yadrone.base.command.LEDAnimation;

public class DroneVariablesGUI extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String title = "Drone navdata";
	
	private JTextField speed;
	private JTextField altitude;
	private JTextField pitchComp;
	private JTextField rollComp;
	private JTextField pitchUpdated;
	private JTextField rollUpdated;
	private JTextField yawUpdated;
	private JTextField battery;
	private JTextField speedMaxDelta;
	private JTextField altitudeMaxDelta;
	private JTextField pitchCompMaxDelta;
	private JTextField rollCompMaxDelta;
	private JTextField pitchUpdatedMaxDelta;
	private JTextField rollUpdatedMaxDelta;
	private JTextField yawUpdatedMaxDelta;
	private JLabel lblCtrlState;
	private JTextField ctrlState;
	private JLabel lblPressure;
	private JTextField pressure;
	
	
	private JLabel stateAcquisitionThreadOn;
	private JLabel stateADCWatchdogDelayed;
	private JLabel stateAltitudeControlActive;
	private JLabel stateAngelsOutOfRange;
	private JLabel stateATCodedThreadOn;
	private JLabel stateBatteryTooHigh;
	private JLabel stateBatteryTooLow;
	private JLabel stateCameraReady;
	private JLabel stateCommunicationLost;
	private JLabel stateCommunicationProblemOccured;
	private JLabel stateControlReceived;
	private JLabel stateControlWatchDogDelayed;
	private JLabel stateCutoutSystemDetected;
	private JLabel stateEmergency;
	private JLabel stateFlying;
	private JLabel stateGyrometersDown;
	private JLabel stateMagnetoCalibrationNeeded;
	private JLabel stateMotorsDown;
	private JLabel stateNavDataBootstrap;
	private JLabel stateNavdataDemoOnly;
	private JLabel stateNavdataThreadOn;
	private JLabel stateNotEnoughPower;
	private JLabel statePICVersionNumberOK;
	private JLabel stateSoftwareFaultDetected;
	private JLabel stateTimerElapsed;
	private JLabel stateTooMuchWind;
	private JLabel stateTravellingMask;
	private JLabel stateTrimReceived;
	private JLabel stateTrimRunning;
	private JLabel stateTrimSucceeded;
	private JLabel stateUltrasonicSensorDeaf;
	private JLabel stateUsbKeyReady;
	private JLabel stateUserEmergencyLanding;
	private JLabel stateUserFeedbackOn;
	
	private JLabel stateVideoEnabled;
	private JLabel stateVideoThreadOn;
	private JLabel stateVisionDefined;
	private JLabel stateVisionEnabled;
	private JButton speedSet;
	private JLabel lblSpeedUp;
	private JTextField speedVal;
	private JButton land;
	private JButton takeOff;
	private JButton btnEmergency;
	private JButton autoTrim;
	private JButton btnSetAnimation;
	private JLabel lblGyro;
	private JTextField gyroXVal;
	private JTextField gyroXOffset;
	private JLabel lblValueHeader;
	private JLabel lblOffset;
	private JLabel lblX;
	private JLabel lblY;
	private JTextField gyroYVal;
	private JTextField gyroYOffset;
	private JLabel lblZ;
	private JTextField gyroZVal;
	private JTextField gyroZOffset;
	private DefaultListModel<String> listenerData;
	private JFrame videoFrame;
	private JComboBox<LEDAnimation> animationOptions;
	public enum ButtonCmd{SPEED_SET, LAND, TAKE_OFF, EMERGENCY, AUTO_TRIM, MANUAL_TRIM, ANIMATION_SET, FREEZE, HOVER, RUN_PROGRAM};
	
	private ArrayList<JLabel> alarmStates = new ArrayList<JLabel>();
	private Color alarmOnColor = Color.red;
	private Color alarmOffColor = Color.green;
	private Color alarmOnBlinkColor = Color.orange;
	private JLabel lblLedAnimation;
	private JLabel lblSpeed_1;
	private JButton btnHover;
	private JButton btnFreeze;
	private JTextField pitchTrim;
	private JLabel lblPitch_2;
	private JLabel lblRoll_2;
	private JTextField rollTrim;
	private JTextField yawTrim;
	private JLabel lblYaw_1;
	private JButton manualTrim;
	private JLabel lblFrequency;
	private JTextField animFrequency;
	private JLabel lblDurations;
	private JTextField animDuration;
	private JButton btnRunProgram;
	
	public DroneVariablesGUI(){
		videoFrame = new JFrame();
		videoFrame.setSize(640, 480);
		videoFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		videoFrame.setTitle("Video feed");
		
		setSize(848, 716);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e){};
		getContentPane().setLayout(null);
		
		JLabel lblSpeed = new JLabel("speed");
		lblSpeed.setBounds(12, 44, 56, 16);
		getContentPane().add(lblSpeed);
		
		speed = new JTextField();
		speed.setEnabled(false);
		speed.setBounds(80, 41, 61, 22);
		getContentPane().add(speed);
		speed.setColumns(10);
		
		JLabel lblAltitude = new JLabel("altitude");
		lblAltitude.setBounds(12, 73, 56, 16);
		getContentPane().add(lblAltitude);
		
		altitude = new JTextField();
		altitude.setEnabled(false);
		altitude.setColumns(10);
		altitude.setBounds(80, 70, 61, 22);
		getContentPane().add(altitude);
		
		JLabel lblAttitudeListener = new JLabel("attitude listener");
		lblAttitudeListener.setBounds(12, 102, 107, 16);
		getContentPane().add(lblAttitudeListener);
		
		JLabel lblWindCompensation = new JLabel("wind compensation");
		lblWindCompensation.setBounds(12, 120, 129, 16);
		getContentPane().add(lblWindCompensation);
		
		JLabel lblPitch = new JLabel("pitch");
		lblPitch.setBounds(12, 149, 56, 16);
		getContentPane().add(lblPitch);
		
		pitchComp = new JTextField();
		pitchComp.setEnabled(false);
		pitchComp.setBounds(80, 146, 61, 22);
		getContentPane().add(pitchComp);
		pitchComp.setColumns(10);
		
		JLabel lblRoll = new JLabel("roll");
		lblRoll.setBounds(12, 178, 56, 16);
		getContentPane().add(lblRoll);
		
		rollComp = new JTextField();
		rollComp.setEnabled(false);
		rollComp.setColumns(10);
		rollComp.setBounds(80, 175, 61, 22);
		getContentPane().add(rollComp);
		
		JLabel lblAttitudeUpdated = new JLabel("attitude updated");
		lblAttitudeUpdated.setBounds(12, 207, 107, 16);
		getContentPane().add(lblAttitudeUpdated);
		
		JLabel lblPitch_1 = new JLabel("pitch");
		lblPitch_1.setBounds(12, 236, 56, 16);
		getContentPane().add(lblPitch_1);
		
		pitchUpdated = new JTextField();
		pitchUpdated.setEnabled(false);
		pitchUpdated.setColumns(10);
		pitchUpdated.setBounds(80, 233, 61, 22);
		getContentPane().add(pitchUpdated);
		
		JLabel lblRoll_1 = new JLabel("roll");
		lblRoll_1.setBounds(12, 265, 56, 16);
		getContentPane().add(lblRoll_1);
		
		rollUpdated = new JTextField();
		rollUpdated.setEnabled(false);
		rollUpdated.setColumns(10);
		rollUpdated.setBounds(80, 262, 61, 22);
		getContentPane().add(rollUpdated);
		
		JLabel lblYaw = new JLabel("yaw");
		lblYaw.setBounds(12, 294, 56, 16);
		getContentPane().add(lblYaw);
		
		yawUpdated = new JTextField();
		yawUpdated.setEnabled(false);
		yawUpdated.setColumns(10);
		yawUpdated.setBounds(80, 291, 61, 22);
		getContentPane().add(yawUpdated);
		
		JLabel lblBattery = new JLabel("battery");
		lblBattery.setBounds(12, 323, 56, 16);
		getContentPane().add(lblBattery);
		
		battery = new JTextField();
		battery.setEnabled(false);
		battery.setColumns(10);
		battery.setBounds(80, 320, 61, 22);
		getContentPane().add(battery);
		
		JLabel lblValue = new JLabel("value");
		lblValue.setBounds(80, 13, 56, 16);
		getContentPane().add(lblValue);
		
		speedMaxDelta = new JTextField();
		speedMaxDelta.setEnabled(false);
		speedMaxDelta.setBounds(153, 41, 56, 22);
		getContentPane().add(speedMaxDelta);
		speedMaxDelta.setColumns(10);
		
		altitudeMaxDelta = new JTextField();
		altitudeMaxDelta.setEnabled(false);
		altitudeMaxDelta.setColumns(10);
		altitudeMaxDelta.setBounds(153, 70, 56, 22);
		getContentPane().add(altitudeMaxDelta);
		
		pitchCompMaxDelta = new JTextField();
		pitchCompMaxDelta.setEnabled(false);
		pitchCompMaxDelta.setColumns(10);
		pitchCompMaxDelta.setBounds(153, 146, 56, 22);
		getContentPane().add(pitchCompMaxDelta);
		
		rollCompMaxDelta = new JTextField();
		rollCompMaxDelta.setEnabled(false);
		rollCompMaxDelta.setColumns(10);
		rollCompMaxDelta.setBounds(153, 175, 56, 22);
		getContentPane().add(rollCompMaxDelta);
		
		pitchUpdatedMaxDelta = new JTextField();
		pitchUpdatedMaxDelta.setEnabled(false);
		pitchUpdatedMaxDelta.setColumns(10);
		pitchUpdatedMaxDelta.setBounds(153, 233, 56, 22);
		getContentPane().add(pitchUpdatedMaxDelta);
		
		rollUpdatedMaxDelta = new JTextField();
		rollUpdatedMaxDelta.setEnabled(false);
		rollUpdatedMaxDelta.setColumns(10);
		rollUpdatedMaxDelta.setBounds(153, 262, 56, 22);
		getContentPane().add(rollUpdatedMaxDelta);
		
		yawUpdatedMaxDelta = new JTextField();
		yawUpdatedMaxDelta.setEnabled(false);
		yawUpdatedMaxDelta.setColumns(10);
		yawUpdatedMaxDelta.setBounds(153, 291, 56, 22);
		getContentPane().add(yawUpdatedMaxDelta);
		
		JLabel lblMaxDelta = new JLabel("max delta");
		lblMaxDelta.setBounds(153, 13, 68, 16);
		getContentPane().add(lblMaxDelta);
		
		lblCtrlState = new JLabel("ctrl state");
		lblCtrlState.setBounds(12, 352, 56, 16);
		getContentPane().add(lblCtrlState);
		
		ctrlState = new JTextField();
		ctrlState.setEnabled(false);
		ctrlState.setBounds(80, 349, 129, 22);
		getContentPane().add(ctrlState);
		ctrlState.setColumns(10);
		
		lblPressure = new JLabel("pressure");
		lblPressure.setBounds(12, 636, 56, 16);
		getContentPane().add(lblPressure);
		
		pressure = new JTextField();
		pressure.setEnabled(false);
		pressure.setBounds(80, 636, 129, 22);
		getContentPane().add(pressure);
		pressure.setColumns(10);
		
		stateAcquisitionThreadOn = new JLabel("acquisition thread on");
		stateAcquisitionThreadOn.setOpaque(true);
		stateAcquisitionThreadOn.setBackground(alarmOnColor);
		stateAcquisitionThreadOn.setBounds(264, 607, 141, 16);
		getContentPane().add(stateAcquisitionThreadOn);
		
		stateADCWatchdogDelayed = new JLabel("ADC watchdog delayed");
		stateADCWatchdogDelayed.setOpaque(true);
		stateADCWatchdogDelayed.setBackground(alarmOnColor);
		stateADCWatchdogDelayed.setBounds(417, 381, 131, 16);
		getContentPane().add(stateADCWatchdogDelayed);
		
		stateAltitudeControlActive = new JLabel("altitude control active");
		stateAltitudeControlActive.setOpaque(true);
		stateAltitudeControlActive.setBackground(alarmOnColor);
		stateAltitudeControlActive.setBounds(130, 381, 122, 16);
		getContentPane().add(stateAltitudeControlActive);
		
		stateAngelsOutOfRange = new JLabel("angles out of range");
		stateAngelsOutOfRange.setOpaque(true);
		stateAngelsOutOfRange.setBackground(alarmOnColor);
		stateAngelsOutOfRange.setBounds(560, 436, 183, 16);
		getContentPane().add(stateAngelsOutOfRange);
		
		stateATCodedThreadOn = new JLabel("AT coded thread on");
		stateATCodedThreadOn.setOpaque(true);
		stateATCodedThreadOn.setBackground(alarmOnColor);
		stateATCodedThreadOn.setBounds(130, 607, 122, 16);
		getContentPane().add(stateATCodedThreadOn);
		
		stateBatteryTooHigh = new JLabel("battery too high");
		stateBatteryTooHigh.setOpaque(true);
		stateBatteryTooHigh.setBackground(alarmOnColor);
		stateBatteryTooHigh.setBounds(130, 436, 122, 16);
		getContentPane().add(stateBatteryTooHigh);
		
		stateBatteryTooLow = new JLabel("battery too low");
		stateBatteryTooLow.setOpaque(true);
		stateBatteryTooLow.setBackground(alarmOnColor);
		stateBatteryTooLow.setBounds(264, 436, 141, 16);
		getContentPane().add(stateBatteryTooLow);
		
		stateCameraReady = new JLabel("camera ready");
		stateCameraReady.setOpaque(true);
		stateCameraReady.setBackground(alarmOnColor);
		stateCameraReady.setBounds(130, 520, 122, 16);
		getContentPane().add(stateCameraReady);
		
		stateCommunicationLost = new JLabel("communication lost");
		stateCommunicationLost.setOpaque(true);
		stateCommunicationLost.setBackground(alarmOnColor);
		stateCommunicationLost.setBounds(130, 465, 122, 16);
		getContentPane().add(stateCommunicationLost);
		
		stateCommunicationProblemOccured = new JLabel("comm problem occured");
		stateCommunicationProblemOccured.setOpaque(true);
		stateCommunicationProblemOccured.setBackground(alarmOnColor);
		stateCommunicationProblemOccured.setBounds(264, 465, 141, 16);
		getContentPane().add(stateCommunicationProblemOccured);
		
		stateControlReceived = new JLabel("control received");
		stateControlReceived.setOpaque(true);
		stateControlReceived.setBackground(alarmOnColor);
		stateControlReceived.setBounds(12, 381, 107, 16);
		getContentPane().add(stateControlReceived);
		
		stateControlWatchDogDelayed = new JLabel("control watchdog delayed");
		stateControlWatchDogDelayed.setOpaque(true);
		stateControlWatchDogDelayed.setBackground(alarmOnColor);
		stateControlWatchDogDelayed.setBounds(560, 520, 183, 16);
		getContentPane().add(stateControlWatchDogDelayed);
		
		stateCutoutSystemDetected = new JLabel("cutout system detected");
		stateCutoutSystemDetected.setOpaque(true);
		stateCutoutSystemDetected.setBackground(alarmOnColor);
		stateCutoutSystemDetected.setBounds(264, 381, 141, 16);
		getContentPane().add(stateCutoutSystemDetected);
		
		stateEmergency = new JLabel("emergency");
		stateEmergency.setOpaque(true);
		stateEmergency.setBackground(alarmOnColor);
		stateEmergency.setBounds(264, 410, 141, 16);
		getContentPane().add(stateEmergency);
		
		stateFlying = new JLabel("flying");
		stateFlying.setOpaque(true);
		stateFlying.setBackground(alarmOnColor);
		stateFlying.setBounds(12, 407, 107, 16);
		getContentPane().add(stateFlying);
		
		stateGyrometersDown = new JLabel("gyros down");
		stateGyrometersDown.setOpaque(true);
		stateGyrometersDown.setBackground(alarmOnColor);
		stateGyrometersDown.setBounds(417, 465, 131, 16);
		getContentPane().add(stateGyrometersDown);
		
		stateMagnetoCalibrationNeeded = new JLabel("magneto calibration needed");
		stateMagnetoCalibrationNeeded.setOpaque(true);
		stateMagnetoCalibrationNeeded.setBackground(alarmOnColor);
		stateMagnetoCalibrationNeeded.setBounds(560, 381, 183, 16);
		getContentPane().add(stateMagnetoCalibrationNeeded);
		
		stateMotorsDown = new JLabel("motors down");
		stateMotorsDown.setOpaque(true);
		stateMotorsDown.setBackground(alarmOnColor);
		stateMotorsDown.setBounds(12, 465, 107, 16);
		getContentPane().add(stateMotorsDown);
		
		stateNavDataBootstrap = new JLabel("navdata bootstrap");
		stateNavDataBootstrap.setOpaque(true);
		stateNavDataBootstrap.setBackground(alarmOnColor);
		stateNavDataBootstrap.setBounds(130, 578, 122, 16);
		getContentPane().add(stateNavDataBootstrap);
		
		stateNavdataDemoOnly = new JLabel("navdata demo only");
		stateNavdataDemoOnly.setOpaque(true);
		stateNavdataDemoOnly.setBackground(alarmOnColor);
		stateNavdataDemoOnly.setBounds(264, 578, 141, 16);
		getContentPane().add(stateNavdataDemoOnly);
		
		stateNavdataThreadOn = new JLabel("navdata thread on");
		stateNavdataThreadOn.setOpaque(true);
		stateNavdataThreadOn.setBackground(alarmOnColor);
		stateNavdataThreadOn.setBounds(12, 578, 107, 16);
		getContentPane().add(stateNavdataThreadOn);
		
		stateNotEnoughPower = new JLabel("not enough power");
		stateNotEnoughPower.setOpaque(true);
		stateNotEnoughPower.setBackground(alarmOnColor);
		stateNotEnoughPower.setBounds(12, 436, 107, 16);
		getContentPane().add(stateNotEnoughPower);
		
		statePICVersionNumberOK = new JLabel("PIC version ok");
		statePICVersionNumberOK.setOpaque(true);
		statePICVersionNumberOK.setBackground(alarmOnColor);
		statePICVersionNumberOK.setBounds(264, 520, 141, 16);
		getContentPane().add(statePICVersionNumberOK);
		
		stateSoftwareFaultDetected = new JLabel("software fault");
		stateSoftwareFaultDetected.setOpaque(true);
		stateSoftwareFaultDetected.setBackground(alarmOnColor);
		stateSoftwareFaultDetected.setBounds(560, 465, 183, 16);
		getContentPane().add(stateSoftwareFaultDetected);
		
		stateTimerElapsed = new JLabel("timer elapsed");
		stateTimerElapsed.setOpaque(true);
		stateTimerElapsed.setBackground(alarmOnColor);
		stateTimerElapsed.setBounds(560, 549, 183, 16);
		getContentPane().add(stateTimerElapsed);
		
		stateTooMuchWind = new JLabel("too much wind");
		stateTooMuchWind.setOpaque(true);
		stateTooMuchWind.setBackground(alarmOnColor);
		stateTooMuchWind.setBounds(417, 436, 131, 16);
		getContentPane().add(stateTooMuchWind);
		
		stateTravellingMask = new JLabel("travelling mask");
		stateTravellingMask.setOpaque(true);
		stateTravellingMask.setBackground(alarmOnColor);
		stateTravellingMask.setBounds(417, 520, 131, 16);
		getContentPane().add(stateTravellingMask);
		
		stateTrimReceived = new JLabel("trim received");
		stateTrimReceived.setOpaque(true);
		stateTrimReceived.setBackground(alarmOnColor);
		stateTrimReceived.setBounds(12, 549, 107, 16);
		getContentPane().add(stateTrimReceived);
		
		stateTrimRunning = new JLabel("trim running");
		stateTrimRunning.setOpaque(true);
		stateTrimRunning.setBackground(alarmOnColor);
		stateTrimRunning.setBounds(130, 549, 122, 16);
		getContentPane().add(stateTrimRunning);
		
		stateTrimSucceeded = new JLabel("trim succeeded");
		stateTrimSucceeded.setOpaque(true);
		stateTrimSucceeded.setBackground(alarmOnColor);
		stateTrimSucceeded.setBounds(264, 549, 141, 16);
		getContentPane().add(stateTrimSucceeded);
		
		stateUltrasonicSensorDeaf = new JLabel("ultrasonic sensor deaf");
		stateUltrasonicSensorDeaf.setOpaque(true);
		stateUltrasonicSensorDeaf.setBackground(alarmOnColor);
		stateUltrasonicSensorDeaf.setBounds(560, 494, 183, 16);
		getContentPane().add(stateUltrasonicSensorDeaf);
		
		stateUsbKeyReady = new JLabel("usb key ready");
		stateUsbKeyReady.setOpaque(true);
		stateUsbKeyReady.setBackground(alarmOnColor);
		stateUsbKeyReady.setBounds(12, 520, 107, 16);
		getContentPane().add(stateUsbKeyReady);

		stateVideoEnabled = new JLabel("video enabled");
		stateVideoEnabled.setOpaque(true);
		stateVideoEnabled.setBackground(alarmOnColor);
		stateVideoEnabled.setBounds(264, 494, 141, 16);
		getContentPane().add(stateVideoEnabled);
		
		stateVideoThreadOn = new JLabel("video thread on");
		stateVideoThreadOn.setOpaque(true);
		stateVideoThreadOn.setBackground(alarmOnColor);
		stateVideoThreadOn.setBounds(417, 494, 131, 16);
		getContentPane().add(stateVideoThreadOn);
		
		stateVisionDefined = new JLabel("vision defined");
		stateVisionDefined.setOpaque(true);
		stateVisionDefined.setBackground(alarmOnColor);
		stateVisionDefined.setBounds(12, 494, 107, 16);
		getContentPane().add(stateVisionDefined);
		
		stateVisionEnabled = new JLabel("vision enabled");
		stateVisionEnabled.setOpaque(true);
		stateVisionEnabled.setBackground(alarmOnColor);
		stateVisionEnabled.setBounds(130, 494, 122, 16);
		getContentPane().add(stateVisionEnabled);
		
		stateUserEmergencyLanding = new JLabel("emergency landing");
		stateUserEmergencyLanding.setOpaque(true);
		stateUserEmergencyLanding.setBackground(alarmOnColor);
		stateUserEmergencyLanding.setBounds(130, 410, 122, 16);
		getContentPane().add(stateUserEmergencyLanding);
		
		stateUserFeedbackOn = new JLabel("user feedback on");
		stateUserFeedbackOn.setOpaque(true);
		stateUserFeedbackOn.setBackground(alarmOnColor);
		stateUserFeedbackOn.setBounds(12, 607, 107, 16);
		getContentPane().add(stateUserFeedbackOn);
				
		speedSet = new JButton("Set");
		speedSet.setBounds(750, 255, 56, 25);
		getContentPane().add(speedSet);
		speedSet.setActionCommand(ButtonCmd.SPEED_SET.name());
		
		lblSpeedUp = new JLabel("% (1-100)");
		lblSpeedUp.setBounds(682, 255, 61, 25);
		getContentPane().add(lblSpeedUp);
		
		speedVal = new JTextField();
		speedVal.setText("25");
		speedVal.setBounds(501, 257, 169, 22);
		getContentPane().add(speedVal);
		speedVal.setColumns(10);
		
		land = new JButton("Land");
		land.setBounds(603, 35, 96, 35);
		getContentPane().add(land);
		land.setActionCommand(ButtonCmd.LAND.name());
		
		takeOff = new JButton("Take off");
		takeOff.setBounds(603, 83, 96, 35);
		getContentPane().add(takeOff);
		takeOff.setActionCommand(ButtonCmd.TAKE_OFF.name());
		
		btnEmergency = new JButton("Emergency");
		btnEmergency.setActionCommand(ButtonCmd.EMERGENCY.name());
		btnEmergency.setBounds(501, 35, 96, 35);
		getContentPane().add(btnEmergency);
		
		autoTrim = new JButton("Auto trim");
		autoTrim.setActionCommand(ButtonCmd.AUTO_TRIM.name());
		autoTrim.setBounds(501, 83, 96, 35);
		getContentPane().add(autoTrim);
		
		lblGyro = new JLabel("gyro");
		lblGyro.setBounds(233, 13, 38, 16);
		getContentPane().add(lblGyro);
		
		lblValueHeader = new JLabel("value");
		lblValueHeader.setBounds(286, 13, 56, 16);
		getContentPane().add(lblValueHeader);
		
		lblOffset = new JLabel("offset");
		lblOffset.setBounds(353, 13, 56, 16);
		getContentPane().add(lblOffset);
		
		lblX = new JLabel("X:");
		lblX.setBounds(235, 44, 25, 16);
		getContentPane().add(lblX);
		
		lblY = new JLabel("Y:");
		lblY.setBounds(235, 73, 25, 16);
		getContentPane().add(lblY);
		
		lblZ = new JLabel("Z:");
		lblZ.setBounds(235, 102, 25, 16);
		getContentPane().add(lblZ);
		
		gyroYVal = new JTextField();
		gyroYVal.setEnabled(false);
		gyroYVal.setColumns(10);
		gyroYVal.setBounds(286, 70, 56, 22);
		getContentPane().add(gyroYVal);
		
		gyroXVal = new JTextField();
		gyroXVal.setEnabled(false);
		gyroXVal.setColumns(10);
		gyroXVal.setBounds(286, 41, 56, 22);
		getContentPane().add(gyroXVal);
		
		gyroZVal = new JTextField();
		gyroZVal.setEnabled(false);
		gyroZVal.setColumns(10);
		gyroZVal.setBounds(286, 99, 56, 22);
		getContentPane().add(gyroZVal);
		
		gyroXOffset = new JTextField();
		gyroXOffset.setEnabled(false);
		gyroXOffset.setColumns(10);
		gyroXOffset.setBounds(351, 41, 56, 22);
		getContentPane().add(gyroXOffset);
		
		gyroYOffset = new JTextField();
		gyroYOffset.setEnabled(false);
		gyroYOffset.setColumns(10);
		gyroYOffset.setBounds(351, 70, 56, 22);
		getContentPane().add(gyroYOffset);
		
		gyroZOffset = new JTextField();
		gyroZOffset.setEnabled(false);
		gyroZOffset.setColumns(10);
		gyroZOffset.setBounds(351, 99, 56, 22);
		getContentPane().add(gyroZOffset);
		
		JList<String> list = new JList<String>();
		list.setBounds(251, 149, 154, 190);
		getContentPane().add(list);
		listenerData = new DefaultListModel<String>();
		list.setModel(listenerData);
		
		animationOptions = new JComboBox<LEDAnimation>();
		animationOptions.setBounds(501, 146, 242, 22);
		getContentPane().add(animationOptions);
		
		btnSetAnimation = new JButton("Set");
		btnSetAnimation.setActionCommand(ButtonCmd.ANIMATION_SET.name());
		btnSetAnimation.setBounds(750, 145, 56, 66);
		getContentPane().add(btnSetAnimation);
		
		lblLedAnimation = new JLabel("led animation");
		lblLedAnimation.setBounds(501, 131, 96, 16);
		getContentPane().add(lblLedAnimation);
		
		lblSpeed_1 = new JLabel("speed");
		lblSpeed_1.setBounds(501, 242, 56, 16);
		getContentPane().add(lblSpeed_1);
		
		btnHover = new JButton("Hover");
		btnHover.setBounds(711, 35, 96, 35);
		btnHover.setActionCommand(ButtonCmd.HOVER.name());
		getContentPane().add(btnHover);
		
		btnFreeze = new JButton("Freeze");
		btnFreeze.setBounds(711, 83, 96, 35);
		btnFreeze.setActionCommand(ButtonCmd.FREEZE.name());
		getContentPane().add(btnFreeze);
		
		JLabel lblManualTrim = new JLabel("manual trim");
		lblManualTrim.setBounds(501, 290, 68, 14);
		getContentPane().add(lblManualTrim);
		
		pitchTrim = new JTextField();
		pitchTrim.setText("0");
		pitchTrim.setBounds(501, 315, 49, 22);
		getContentPane().add(pitchTrim);
		pitchTrim.setColumns(10);
		
		lblPitch_2 = new JLabel("pitch");
		lblPitch_2.setBounds(501, 301, 46, 14);
		getContentPane().add(lblPitch_2);
		
		lblRoll_2 = new JLabel("roll");
		lblRoll_2.setBounds(560, 301, 46, 14);
		getContentPane().add(lblRoll_2);
		
		rollTrim = new JTextField();
		rollTrim.setText("0");
		rollTrim.setBounds(560, 315, 49, 22);
		getContentPane().add(rollTrim);
		rollTrim.setColumns(10);
		
		yawTrim = new JTextField();
		yawTrim.setText("0");
		yawTrim.setBounds(619, 315, 49, 22);
		getContentPane().add(yawTrim);
		yawTrim.setColumns(10);
		
		lblYaw_1 = new JLabel("yaw");
		lblYaw_1.setBounds(619, 301, 46, 14);
		getContentPane().add(lblYaw_1);
		
		manualTrim = new JButton("Trim");
		manualTrim.setBounds(684, 314, 122, 25);
		manualTrim.setActionCommand(ButtonCmd.MANUAL_TRIM.name());
		getContentPane().add(manualTrim);
		
		lblFrequency = new JLabel("frequency (1/s)");
		lblFrequency.setBounds(501, 175, 92, 14);
		getContentPane().add(lblFrequency);
		
		animFrequency = new JTextField();
		animFrequency.setBounds(501, 189, 92, 22);
		getContentPane().add(animFrequency);
		animFrequency.setColumns(10);
		
		lblDurations = new JLabel("duration (s)");
		lblDurations.setBounds(603, 175, 67, 14);
		getContentPane().add(lblDurations);
		
		animDuration = new JTextField();
		animDuration.setBounds(603, 189, 67, 22);
		getContentPane().add(animDuration);
		animDuration.setColumns(10);
		
		btnRunProgram = new JButton("Run program");
		btnRunProgram.setBounds(622, 617, 200, 50);
		btnRunProgram.setActionCommand(ButtonCmd.RUN_PROGRAM.name());
		getContentPane().add(btnRunProgram);
		
		addAlarmStates();
		setVisible(true);
	}

	public void addAlarmStates(){
		alarmStates.add(stateEmergency);
		alarmStates.add(stateCommunicationLost);
		alarmStates.add(stateCommunicationProblemOccured);
		alarmStates.add(stateBatteryTooHigh);
		alarmStates.add(stateBatteryTooLow);
		alarmStates.add(stateNotEnoughPower);
		alarmStates.add(stateGyrometersDown);
		alarmStates.add(stateMotorsDown);
		alarmStates.add(stateSoftwareFaultDetected);
		alarmStates.add(stateUserEmergencyLanding);
		alarmStates.add(stateAngelsOutOfRange);
		alarmStates.add(stateTooMuchWind);
	}
	public void setSpeed(int speed) {this.speed.setText(String.valueOf(speed));	}

	public void setAltitude(int altitude) {this.altitude.setText(String.valueOf(altitude));}

	public void setPitchComp(float pitchComp) {this.pitchComp.setText(String.valueOf(pitchComp));}

	public void setRollComp(float rollComp) {this.rollComp.setText(String.valueOf(rollComp));	}

	public void setPitchUpdated(float pitchUpdated) {this.pitchUpdated.setText(String.valueOf(pitchUpdated));	}

	public void setRollUpdated(float rollUpdated) {this.rollUpdated.setText(String.valueOf(rollUpdated));	}

	public void setYawUpdated(float yawUpdated) {this.yawUpdated.setText(String.valueOf(yawUpdated));	}

	public void setBattery(int battery) {this.battery.setText(String.valueOf(battery));	}

	public void setSpeedMaxDelta(int speedMaxDelta) {this.speedMaxDelta.setText(String.valueOf(speedMaxDelta));	}

	public void setAltitudeMaxDelta(int altitudeMaxDelta) {this.altitudeMaxDelta.setText(String.valueOf(altitudeMaxDelta));	}

	public void setPitchCompMaxDelta(float pitchCompMaxDelta) {this.pitchCompMaxDelta.setText(String.valueOf(pitchCompMaxDelta)); }

	public void setRollCompMaxDelta(float rollCompMaxDelta) {this.rollCompMaxDelta.setText(String.valueOf(rollCompMaxDelta)); }

	public void setPitchUpdatedMaxDelta(float pitchUpdatedMaxDelta) {this.pitchUpdatedMaxDelta.setText(String.valueOf(pitchUpdatedMaxDelta)); }

	public void setRollUpdatedMaxDelta(float rollUpdatedMaxDelta) {this.rollUpdatedMaxDelta.setText(String.valueOf(rollUpdatedMaxDelta)); }

	public void setYawUpdatedMaxDelta(float yawUpdatedMaxDelta) {this.yawUpdatedMaxDelta.setText(String.valueOf(yawUpdatedMaxDelta)); }

	public void setCtrlState(String name) { this.ctrlState.setText(name);}
	
	public void setPressure(String val) {this.pressure.setText(val);}

	public void setStateAcquisitionThreadOn(boolean b){
		this.stateAcquisitionThreadOn.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateADCWatchdogDelayed(boolean b){
		this.stateADCWatchdogDelayed.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateAltitudeControlActive(boolean b){
		this.stateAltitudeControlActive.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateAngelsOutOfRange(boolean b){
		this.stateAngelsOutOfRange.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateATCodedThreadOn(boolean b){
		this.stateATCodedThreadOn.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateBatteryTooHigh(boolean b){
		this.stateBatteryTooHigh.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateBatteryTooLow(boolean b){
		this.stateBatteryTooLow.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateCameraReady(boolean b){
		this.stateCameraReady.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateCommunicationLost(boolean b){
		this.stateCommunicationLost.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateCommunicationProblemOccured(boolean b){
		this.stateCommunicationProblemOccured.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateControlReceived(boolean b){
		this.stateControlReceived.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateControlWatchDogDelayed(boolean b){
		this.stateControlWatchDogDelayed.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateCutoutSystemDetected(boolean b){
		this.stateCutoutSystemDetected.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateEmergency(boolean b){
		this.stateEmergency.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateFlying(boolean b){
		this.stateFlying.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateGyrometersDown(boolean b){
		this.stateGyrometersDown.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateMagnetoCalibrationNeeded(boolean b){
		this.stateMagnetoCalibrationNeeded.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateMotorsDown(boolean b){
		this.stateMotorsDown.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateNavDataBootstrap(boolean b){
		this.stateNavDataBootstrap.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateNavdataDemoOnly(boolean b){
		this.stateNavdataDemoOnly.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateNavdataThreadOn(boolean b){
		this.stateNavdataThreadOn.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateNotEnoughPower(boolean b){
		this.stateNotEnoughPower.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStatePICVersionNumberOK(boolean b){
		this.statePICVersionNumberOK.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateSoftwareFaultDetected(boolean b){
		this.stateSoftwareFaultDetected.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateTimerElapsed(boolean b){
		this.stateTimerElapsed.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateTooMuchWind(boolean b){
		this.stateTooMuchWind.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateTravellingMask(boolean b){
		this.stateTravellingMask.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateTrimReceived(boolean b){
		this.stateTrimReceived.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateTrimRunning(boolean b){
		this.stateTrimRunning.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateTrimSucceeded(boolean b){
		this.stateTrimSucceeded.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateUltrasonicSensorDeaf(boolean b){
		this.stateUltrasonicSensorDeaf.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateUsbKeyReady(boolean b){
		this.stateUsbKeyReady.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateUserEmergencyLanding(boolean b){
		this.stateUserEmergencyLanding.setBackground(!b ? alarmOffColor : alarmOnColor);
	}

	public void setStateUserFeedbackOn(boolean b){
		this.stateUserFeedbackOn.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateVideoEnabled(boolean b){
		this.stateVideoEnabled.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateVideoThreadOn(boolean b){
		this.stateVideoThreadOn.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateVisionDefined(boolean b){
		this.stateVisionDefined.setBackground(b ? alarmOffColor : alarmOnColor);
	}

	public void setStateVisionEnabled(boolean b){
		this.stateVisionEnabled.setBackground(b ? alarmOffColor : alarmOnColor);
	}
	
	public void setGyroXVal(float val){
		this.gyroXVal.setText(String.valueOf(val));
	}
	
	public void setGyroXOffset(float val){
		this.gyroXOffset.setText(String.valueOf(val));
	}
	
	public void setGyroYVal(float val){
		this.gyroYVal.setText(String.valueOf(val));
	}
	
	public void setGyroYOffset(float val){
		this.gyroYOffset.setText(String.valueOf(val));
	}
	
	public void setGyroZVal(float val){
		this.gyroZVal.setText(String.valueOf(val));
	}
	
	public void setGyroZOffset(float val){
		this.gyroZOffset.setText(String.valueOf(val));
	}
	
	public void addButtonListener(ActionListener listener){
		this.land.addActionListener(listener);
		this.takeOff.addActionListener(listener);
		this.speedSet.addActionListener(listener);
		this.btnEmergency.addActionListener(listener);
		this.autoTrim.addActionListener(listener);
		this.btnSetAnimation.addActionListener(listener);
		this.btnFreeze.addActionListener(listener);
		this.btnHover.addActionListener(listener);
		this.manualTrim.addActionListener(listener);
		this.btnRunProgram.addActionListener(listener);
	}
	
	public float getAnimationFrequency(){
		try{
			return Float.valueOf(this.animFrequency.getText());
		}catch(Exception e){
			return 1;
		}
	}
	
	public int getAnimationDuration(){
		try{
			return Integer.valueOf(this.animDuration.getText());
		}catch(Exception e){
			return 5;
		}
	}
	
	public void setAnimationOptions(LEDAnimation[] options){
		for(LEDAnimation l : options)this.animationOptions.addItem(l);
	}
	
	public LEDAnimation getAnimationSelected(){
		if(this.animationOptions.getSelectedItem() instanceof LEDAnimation){
			return (LEDAnimation) this.animationOptions.getSelectedItem();
		}
		return LEDAnimation.BLANK;
	}
	
	public float getRollTrim(){
		try{
			return Float.valueOf(this.rollTrim.getText());
		}catch(Exception e){
			return 0;
		}
	}
	
	public float getPitchTrim(){
		try{
			return Float.valueOf(this.pitchTrim.getText());
		}catch(Exception e){
			return 0;
		}
	}
	
	public float getYawTrim(){
		try{
			return Float.valueOf(this.yawTrim.getText());
		}catch(Exception e){
			return 0;
		}
	}
	
	public void setImage(BufferedImage img){
		videoFrame.getContentPane().getGraphics().drawImage(img, 0, 0, null);
	}
	
	public void setVideoFrameSize(int width, int height){
		videoFrame.setSize(width, height);
	}
	
	public void showVideoFeed(){
		videoFrame.setVisible(true);
	}
	
	public void hideVideoFeed(){
		videoFrame.setVisible(false);
	}
	
	public synchronized void addListenerName(String name){
		listenerData.addElement(name);
		
	}
	
	public synchronized void removeListenerName(String name){
		listenerData.removeElement(name);
	}
	
	public int getSpeedVal(){
		try{
		return Math.abs(Integer.valueOf(this.speedVal.getText()));
		}catch(Exception e){
			return 1;
		}
	}

	@Override
	public void run() {
		new Timer(500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				
				for(JLabel l : alarmStates){					
					if(l.getBackground().equals(alarmOnColor))
						l.setBackground(alarmOnBlinkColor);
					else if(l.getBackground().equals(alarmOnBlinkColor))
						l.setBackground(alarmOnColor);
				}
			}
		}).start();
	}
}
