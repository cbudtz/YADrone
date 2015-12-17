package dtu.cdio.tutorial.gui;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;

public class DroneVariablesGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int width = 500;
	private final int height = 400;
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
	private JButton speedUp;
	private JLabel lblSpeedUp;
	private JTextField speedIncr;
	private JButton speedDown;
	private JTextField speedDecr;
	private JButton land;
	private JButton takeOff;
	private JButton btnEmergency;
	private JButton trim;
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
	
	public enum ButtonCmd{SPEED_UP, SPEED_DOWN, LAND, TAKE_OFF, EMERGENCY, TRIM};
	
	public DroneVariablesGUI(){
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
		stateAcquisitionThreadOn.setBackground(Color.RED);
		stateAcquisitionThreadOn.setBounds(264, 607, 141, 16);
		getContentPane().add(stateAcquisitionThreadOn);
		
		stateADCWatchdogDelayed = new JLabel("ADC watchdog delayed");
		stateADCWatchdogDelayed.setOpaque(true);
		stateADCWatchdogDelayed.setBackground(Color.RED);
		stateADCWatchdogDelayed.setBounds(417, 381, 131, 16);
		getContentPane().add(stateADCWatchdogDelayed);
		
		stateAltitudeControlActive = new JLabel("altitude control active");
		stateAltitudeControlActive.setOpaque(true);
		stateAltitudeControlActive.setBackground(Color.RED);
		stateAltitudeControlActive.setBounds(130, 381, 122, 16);
		getContentPane().add(stateAltitudeControlActive);
		
		stateAngelsOutOfRange = new JLabel("angles out of range");
		stateAngelsOutOfRange.setOpaque(true);
		stateAngelsOutOfRange.setBackground(Color.RED);
		stateAngelsOutOfRange.setBounds(560, 436, 183, 16);
		getContentPane().add(stateAngelsOutOfRange);
		
		stateATCodedThreadOn = new JLabel("AT coded thread on");
		stateATCodedThreadOn.setOpaque(true);
		stateATCodedThreadOn.setBackground(Color.RED);
		stateATCodedThreadOn.setBounds(130, 607, 122, 16);
		getContentPane().add(stateATCodedThreadOn);
		
		stateBatteryTooHigh = new JLabel("battery too high");
		stateBatteryTooHigh.setOpaque(true);
		stateBatteryTooHigh.setBackground(Color.RED);
		stateBatteryTooHigh.setBounds(130, 436, 122, 16);
		getContentPane().add(stateBatteryTooHigh);
		
		stateBatteryTooLow = new JLabel("battery too low");
		stateBatteryTooLow.setOpaque(true);
		stateBatteryTooLow.setBackground(Color.RED);
		stateBatteryTooLow.setBounds(264, 436, 141, 16);
		getContentPane().add(stateBatteryTooLow);
		
		stateCameraReady = new JLabel("camera ready");
		stateCameraReady.setOpaque(true);
		stateCameraReady.setBackground(Color.RED);
		stateCameraReady.setBounds(130, 520, 122, 16);
		getContentPane().add(stateCameraReady);
		
		stateCommunicationLost = new JLabel("communication lost");
		stateCommunicationLost.setOpaque(true);
		stateCommunicationLost.setBackground(Color.RED);
		stateCommunicationLost.setBounds(130, 465, 122, 16);
		getContentPane().add(stateCommunicationLost);
		
		stateCommunicationProblemOccured = new JLabel("comm problem occured");
		stateCommunicationProblemOccured.setOpaque(true);
		stateCommunicationProblemOccured.setBackground(Color.RED);
		stateCommunicationProblemOccured.setBounds(264, 465, 141, 16);
		getContentPane().add(stateCommunicationProblemOccured);
		
		stateControlReceived = new JLabel("control received");
		stateControlReceived.setOpaque(true);
		stateControlReceived.setBackground(Color.RED);
		stateControlReceived.setBounds(12, 381, 107, 16);
		getContentPane().add(stateControlReceived);
		
		stateControlWatchDogDelayed = new JLabel("control watchdog delayed");
		stateControlWatchDogDelayed.setOpaque(true);
		stateControlWatchDogDelayed.setBackground(Color.RED);
		stateControlWatchDogDelayed.setBounds(560, 520, 183, 16);
		getContentPane().add(stateControlWatchDogDelayed);
		
		stateCutoutSystemDetected = new JLabel("cutout system detected");
		stateCutoutSystemDetected.setOpaque(true);
		stateCutoutSystemDetected.setBackground(Color.RED);
		stateCutoutSystemDetected.setBounds(264, 381, 141, 16);
		getContentPane().add(stateCutoutSystemDetected);
		
		stateEmergency = new JLabel("emergency");
		stateEmergency.setOpaque(true);
		stateEmergency.setBackground(Color.RED);
		stateEmergency.setBounds(264, 410, 141, 16);
		getContentPane().add(stateEmergency);
		
		stateFlying = new JLabel("flying");
		stateFlying.setOpaque(true);
		stateFlying.setBackground(Color.RED);
		stateFlying.setBounds(12, 407, 107, 16);
		getContentPane().add(stateFlying);
		
		stateGyrometersDown = new JLabel("gyros down");
		stateGyrometersDown.setOpaque(true);
		stateGyrometersDown.setBackground(Color.RED);
		stateGyrometersDown.setBounds(417, 465, 131, 16);
		getContentPane().add(stateGyrometersDown);
		
		stateMagnetoCalibrationNeeded = new JLabel("magneto calibration needed");
		stateMagnetoCalibrationNeeded.setOpaque(true);
		stateMagnetoCalibrationNeeded.setBackground(Color.RED);
		stateMagnetoCalibrationNeeded.setBounds(570, 381, 173, 16);
		getContentPane().add(stateMagnetoCalibrationNeeded);
		
		stateMotorsDown = new JLabel("motors down");
		stateMotorsDown.setOpaque(true);
		stateMotorsDown.setBackground(Color.RED);
		stateMotorsDown.setBounds(12, 465, 107, 16);
		getContentPane().add(stateMotorsDown);
		
		stateNavDataBootstrap = new JLabel("navdata bootstrap");
		stateNavDataBootstrap.setOpaque(true);
		stateNavDataBootstrap.setBackground(Color.RED);
		stateNavDataBootstrap.setBounds(130, 578, 122, 16);
		getContentPane().add(stateNavDataBootstrap);
		
		stateNavdataDemoOnly = new JLabel("navdata demo only");
		stateNavdataDemoOnly.setOpaque(true);
		stateNavdataDemoOnly.setBackground(Color.RED);
		stateNavdataDemoOnly.setBounds(264, 578, 141, 16);
		getContentPane().add(stateNavdataDemoOnly);
		
		stateNavdataThreadOn = new JLabel("navdata thread on");
		stateNavdataThreadOn.setOpaque(true);
		stateNavdataThreadOn.setBackground(Color.RED);
		stateNavdataThreadOn.setBounds(12, 578, 107, 16);
		getContentPane().add(stateNavdataThreadOn);
		
		stateNotEnoughPower = new JLabel("not enough power");
		stateNotEnoughPower.setOpaque(true);
		stateNotEnoughPower.setBackground(Color.RED);
		stateNotEnoughPower.setBounds(12, 436, 107, 16);
		getContentPane().add(stateNotEnoughPower);
		
		statePICVersionNumberOK = new JLabel("PIC version ok");
		statePICVersionNumberOK.setOpaque(true);
		statePICVersionNumberOK.setBackground(Color.RED);
		statePICVersionNumberOK.setBounds(264, 520, 141, 16);
		getContentPane().add(statePICVersionNumberOK);
		
		stateSoftwareFaultDetected = new JLabel("software fault");
		stateSoftwareFaultDetected.setOpaque(true);
		stateSoftwareFaultDetected.setBackground(Color.RED);
		stateSoftwareFaultDetected.setBounds(560, 465, 183, 16);
		getContentPane().add(stateSoftwareFaultDetected);
		
		stateTimerElapsed = new JLabel("timer elapsed");
		stateTimerElapsed.setOpaque(true);
		stateTimerElapsed.setBackground(Color.RED);
		stateTimerElapsed.setBounds(560, 549, 183, 16);
		getContentPane().add(stateTimerElapsed);
		
		stateTooMuchWind = new JLabel("too much wind");
		stateTooMuchWind.setOpaque(true);
		stateTooMuchWind.setBackground(Color.RED);
		stateTooMuchWind.setBounds(417, 436, 131, 16);
		getContentPane().add(stateTooMuchWind);
		
		stateTravellingMask = new JLabel("travelling mask");
		stateTravellingMask.setOpaque(true);
		stateTravellingMask.setBackground(Color.RED);
		stateTravellingMask.setBounds(417, 520, 131, 16);
		getContentPane().add(stateTravellingMask);
		
		stateTrimReceived = new JLabel("trim received");
		stateTrimReceived.setOpaque(true);
		stateTrimReceived.setBackground(Color.RED);
		stateTrimReceived.setBounds(12, 549, 107, 16);
		getContentPane().add(stateTrimReceived);
		
		stateTrimRunning = new JLabel("trim running");
		stateTrimRunning.setOpaque(true);
		stateTrimRunning.setBackground(Color.RED);
		stateTrimRunning.setBounds(130, 549, 122, 16);
		getContentPane().add(stateTrimRunning);
		
		stateTrimSucceeded = new JLabel("trim succeeded");
		stateTrimSucceeded.setOpaque(true);
		stateTrimSucceeded.setBackground(Color.RED);
		stateTrimSucceeded.setBounds(264, 549, 141, 16);
		getContentPane().add(stateTrimSucceeded);
		
		stateUltrasonicSensorDeaf = new JLabel("ultrasonic sensor deaf");
		stateUltrasonicSensorDeaf.setOpaque(true);
		stateUltrasonicSensorDeaf.setBackground(Color.RED);
		stateUltrasonicSensorDeaf.setBounds(560, 494, 183, 16);
		getContentPane().add(stateUltrasonicSensorDeaf);
		
		stateUsbKeyReady = new JLabel("usb key ready");
		stateUsbKeyReady.setOpaque(true);
		stateUsbKeyReady.setBackground(Color.RED);
		stateUsbKeyReady.setBounds(12, 520, 107, 16);
		getContentPane().add(stateUsbKeyReady);

		stateVideoEnabled = new JLabel("video enabled");
		stateVideoEnabled.setOpaque(true);
		stateVideoEnabled.setBackground(Color.RED);
		stateVideoEnabled.setBounds(264, 494, 141, 16);
		getContentPane().add(stateVideoEnabled);
		
		stateVideoThreadOn = new JLabel("video thread on");
		stateVideoThreadOn.setOpaque(true);
		stateVideoThreadOn.setBackground(Color.RED);
		stateVideoThreadOn.setBounds(417, 494, 131, 16);
		getContentPane().add(stateVideoThreadOn);
		
		stateVisionDefined = new JLabel("vision defined");
		stateVisionDefined.setOpaque(true);
		stateVisionDefined.setBackground(Color.RED);
		stateVisionDefined.setBounds(12, 494, 107, 16);
		getContentPane().add(stateVisionDefined);
		
		stateVisionEnabled = new JLabel("vision enabled");
		stateVisionEnabled.setOpaque(true);
		stateVisionEnabled.setBackground(Color.RED);
		stateVisionEnabled.setBounds(130, 494, 122, 16);
		getContentPane().add(stateVisionEnabled);
		
		stateUserEmergencyLanding = new JLabel("emergency landing");
		stateUserEmergencyLanding.setOpaque(true);
		stateUserEmergencyLanding.setBackground(Color.RED);
		stateUserEmergencyLanding.setBounds(130, 410, 122, 16);
		getContentPane().add(stateUserEmergencyLanding);
		
		stateUserFeedbackOn = new JLabel("user feedback on");
		stateUserFeedbackOn.setOpaque(true);
		stateUserFeedbackOn.setBackground(Color.RED);
		stateUserFeedbackOn.setBounds(12, 607, 107, 16);
		getContentPane().add(stateUserFeedbackOn);
				
		speedUp = new JButton("<html>&#9650</html>");
		speedUp.setBounds(774, 35, 44, 35);
		getContentPane().add(speedUp);
		speedUp.setActionCommand(ButtonCmd.SPEED_UP.name());
		
		lblSpeedUp = new JLabel("speed");
		lblSpeedUp.setBounds(774, 13, 44, 16);
		getContentPane().add(lblSpeedUp);
		
		speedIncr = new JTextField();
		speedIncr.setText("10");
		speedIncr.setBounds(717, 41, 44, 22);
		getContentPane().add(speedIncr);
		speedIncr.setColumns(10);
		
		speedDown = new JButton("<html>&#9660</html>");
		speedDown.setBounds(774, 83, 44, 35);
		getContentPane().add(speedDown);
		speedDown.setActionCommand(ButtonCmd.SPEED_DOWN.name());
		
		
		speedDecr = new JTextField();
		speedDecr.setText("10");
		speedDecr.setColumns(10);
		speedDecr.setBounds(717, 89, 44, 22);
		getContentPane().add(speedDecr);
		
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
		
		trim = new JButton("Trim");
		trim.setActionCommand(ButtonCmd.TRIM.name());
		trim.setBounds(501, 83, 96, 35);
		getContentPane().add(trim);
		
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
		setVisible(true);
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
		this.stateAcquisitionThreadOn.setBackground(b ? Color.green : Color.red);
	}

	public void setStateADCWatchdogDelayed(boolean b){
		this.stateADCWatchdogDelayed.setBackground(b ? Color.green : Color.red);
	}

	public void setStateAltitudeControlActive(boolean b){
		this.stateAltitudeControlActive.setBackground(b ? Color.green : Color.red);
	}

	public void setStateAngelsOutOfRange(boolean b){
		this.stateAngelsOutOfRange.setBackground(b ? Color.green : Color.red);
	}

	public void setStateATCodedThreadOn(boolean b){
		this.stateATCodedThreadOn.setBackground(b ? Color.green : Color.red);
	}

	public void setStateBatteryTooHigh(boolean b){
		this.stateBatteryTooHigh.setBackground(b ? Color.green : Color.red);
	}

	public void setStateBatteryTooLow(boolean b){
		this.stateBatteryTooLow.setBackground(b ? Color.green : Color.red);
	}

	public void setStateCameraReady(boolean b){
		this.stateCameraReady.setBackground(b ? Color.green : Color.red);
	}

	public void setStateCommunicationLost(boolean b){
		this.stateCommunicationLost.setBackground(b ? Color.green : Color.red);
	}

	public void setStateCommunicationProblemOccured(boolean b){
		this.stateCommunicationProblemOccured.setBackground(b ? Color.green : Color.red);
	}

	public void setStateControlReceived(boolean b){
		this.stateControlReceived.setBackground(b ? Color.green : Color.red);
	}

	public void setStateControlWatchDogDelayed(boolean b){
		this.stateControlWatchDogDelayed.setBackground(b ? Color.green : Color.red);
	}

	public void setStateCutoutSystemDetected(boolean b){
		this.stateCutoutSystemDetected.setBackground(b ? Color.green : Color.red);
	}

	public void setStateEmergency(boolean b){
		this.stateEmergency.setBackground(b ? Color.green : Color.red);
	}

	public void setStateFlying(boolean b){
		this.stateFlying.setBackground(b ? Color.green : Color.red);
	}

	public void setStateGyrometersDown(boolean b){
		this.stateGyrometersDown.setBackground(b ? Color.green : Color.red);
	}

	public void setStateMagnetoCalibrationNeeded(boolean b){
		this.stateMagnetoCalibrationNeeded.setBackground(b ? Color.green : Color.red);
	}

	public void setStateMotorsDown(boolean b){
		this.stateMotorsDown.setBackground(b ? Color.green : Color.red);
	}

	public void setStateNavDataBootstrap(boolean b){
		this.stateNavDataBootstrap.setBackground(b ? Color.green : Color.red);
	}

	public void setStateNavdataDemoOnly(boolean b){
		this.stateNavdataDemoOnly.setBackground(b ? Color.green : Color.red);
	}

	public void setStateNavdataThreadOn(boolean b){
		this.stateNavdataThreadOn.setBackground(b ? Color.green : Color.red);
	}

	public void setStateNotEnoughPower(boolean b){
		this.stateNotEnoughPower.setBackground(b ? Color.green : Color.red);
	}

	public void setStatePICVersionNumberOK(boolean b){
		this.statePICVersionNumberOK.setBackground(b ? Color.green : Color.red);
	}

	public void setStateSoftwareFaultDetected(boolean b){
		this.stateSoftwareFaultDetected.setBackground(b ? Color.green : Color.red);
	}

	public void setStateTimerElapsed(boolean b){
		this.stateTimerElapsed.setBackground(b ? Color.green : Color.red);
	}

	public void setStateTooMuchWind(boolean b){
		this.stateTooMuchWind.setBackground(b ? Color.green : Color.red);
	}

	public void setStateTravellingMask(boolean b){
		this.stateTravellingMask.setBackground(b ? Color.green : Color.red);
	}

	public void setStateTrimReceived(boolean b){
		this.stateTrimReceived.setBackground(b ? Color.green : Color.red);
	}

	public void setStateTrimRunning(boolean b){
		this.stateTrimRunning.setBackground(b ? Color.green : Color.red);
	}

	public void setStateTrimSucceeded(boolean b){
		this.stateTrimSucceeded.setBackground(b ? Color.green : Color.red);
	}

	public void setStateUltrasonicSensorDeaf(boolean b){
		this.stateUltrasonicSensorDeaf.setBackground(b ? Color.green : Color.red);
	}

	public void setStateUsbKeyReady(boolean b){
		this.stateUsbKeyReady.setBackground(b ? Color.green : Color.red);
	}

	public void setStateUserEmergencyLanding(boolean b){
		this.stateUserEmergencyLanding.setBackground(b ? Color.green : Color.red);
	}

	public void setStateUserFeedbackOn(boolean b){
		this.stateUserFeedbackOn.setBackground(b ? Color.green : Color.red);
	}

	public void setStateVideoEnabled(boolean b){
		this.stateVideoEnabled.setBackground(b ? Color.green : Color.red);
	}

	public void setStateVideoThreadOn(boolean b){
		this.stateVideoThreadOn.setBackground(b ? Color.green : Color.red);
	}

	public void setStateVisionDefined(boolean b){
		this.stateVisionDefined.setBackground(b ? Color.green : Color.red);
	}

	public void setStateVisionEnabled(boolean b){
		this.stateVisionEnabled.setBackground(b ? Color.green : Color.red);
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
		this.speedDown.addActionListener(listener);
		this.speedUp.addActionListener(listener);
		this.btnEmergency.addActionListener(listener);
		this.trim.addActionListener(listener);
		
	}
	
	public synchronized void addListenerName(String name){
		listenerData.addElement(name);
		
	}
	
	public synchronized void removeListenerName(String name){
		listenerData.removeElement(name);
	}
	
	public int getSpeedIncr(){
		try{
		return Math.abs(Integer.valueOf(this.speedIncr.getText()));
		}catch(Exception e){
			return 1;
		}
	}
	
	public int getSpeedDecr(){
		try{
			return Math.abs(Integer.valueOf(this.speedDecr.getText()));
		}catch(Exception e){
			return 1;
		}
	}
}
