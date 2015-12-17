package dtu.cdio.tutorial.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DroneVariablesGUI extends JFrame{

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
	private JLabel lblDroneState;
	private JTextField droneState;
	private JLabel lblPressure;
	private JTextField pressure;
	
	public DroneVariablesGUI(){
		setSize(500, 554);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
		getContentPane().setLayout(null);
		
		JLabel lblSpeed = new JLabel("speed");
		lblSpeed.setBounds(12, 44, 56, 16);
		getContentPane().add(lblSpeed);
		
		speed = new JTextField();
		speed.setBounds(80, 41, 61, 22);
		getContentPane().add(speed);
		speed.setColumns(10);
		
		JLabel lblAltitude = new JLabel("altitude");
		lblAltitude.setBounds(12, 73, 56, 16);
		getContentPane().add(lblAltitude);
		
		altitude = new JTextField();
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
		pitchComp.setBounds(80, 146, 61, 22);
		getContentPane().add(pitchComp);
		pitchComp.setColumns(10);
		
		JLabel lblRoll = new JLabel("roll");
		lblRoll.setBounds(12, 178, 56, 16);
		getContentPane().add(lblRoll);
		
		rollComp = new JTextField();
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
		pitchUpdated.setColumns(10);
		pitchUpdated.setBounds(80, 233, 61, 22);
		getContentPane().add(pitchUpdated);
		
		JLabel lblRoll_1 = new JLabel("roll");
		lblRoll_1.setBounds(12, 265, 56, 16);
		getContentPane().add(lblRoll_1);
		
		rollUpdated = new JTextField();
		rollUpdated.setColumns(10);
		rollUpdated.setBounds(80, 262, 61, 22);
		getContentPane().add(rollUpdated);
		
		JLabel lblYaw = new JLabel("yaw");
		lblYaw.setBounds(12, 294, 56, 16);
		getContentPane().add(lblYaw);
		
		yawUpdated = new JTextField();
		yawUpdated.setColumns(10);
		yawUpdated.setBounds(80, 291, 61, 22);
		getContentPane().add(yawUpdated);
		
		JLabel lblBattery = new JLabel("battery");
		lblBattery.setBounds(12, 323, 56, 16);
		getContentPane().add(lblBattery);
		
		battery = new JTextField();
		battery.setColumns(10);
		battery.setBounds(80, 320, 61, 22);
		getContentPane().add(battery);
		
		JLabel lblValue = new JLabel("value");
		lblValue.setBounds(80, 13, 56, 16);
		getContentPane().add(lblValue);
		
		speedMaxDelta = new JTextField();
		speedMaxDelta.setBounds(153, 41, 56, 22);
		getContentPane().add(speedMaxDelta);
		speedMaxDelta.setColumns(10);
		
		altitudeMaxDelta = new JTextField();
		altitudeMaxDelta.setColumns(10);
		altitudeMaxDelta.setBounds(153, 70, 56, 22);
		getContentPane().add(altitudeMaxDelta);
		
		pitchCompMaxDelta = new JTextField();
		pitchCompMaxDelta.setColumns(10);
		pitchCompMaxDelta.setBounds(153, 146, 56, 22);
		getContentPane().add(pitchCompMaxDelta);
		
		rollCompMaxDelta = new JTextField();
		rollCompMaxDelta.setColumns(10);
		rollCompMaxDelta.setBounds(153, 175, 56, 22);
		getContentPane().add(rollCompMaxDelta);
		
		pitchUpdatedMaxDelta = new JTextField();
		pitchUpdatedMaxDelta.setColumns(10);
		pitchUpdatedMaxDelta.setBounds(153, 233, 56, 22);
		getContentPane().add(pitchUpdatedMaxDelta);
		
		rollUpdatedMaxDelta = new JTextField();
		rollUpdatedMaxDelta.setColumns(10);
		rollUpdatedMaxDelta.setBounds(153, 262, 56, 22);
		getContentPane().add(rollUpdatedMaxDelta);
		
		yawUpdatedMaxDelta = new JTextField();
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
		ctrlState.setBounds(80, 349, 129, 22);
		getContentPane().add(ctrlState);
		ctrlState.setColumns(10);
		
		lblDroneState = new JLabel("drone state");
		lblDroneState.setBounds(12, 381, 68, 16);
		getContentPane().add(lblDroneState);
		
		droneState = new JTextField();
		droneState.setBounds(80, 378, 129, 22);
		getContentPane().add(droneState);
		droneState.setColumns(10);
		
		lblPressure = new JLabel("pressure");
		lblPressure.setBounds(12, 410, 56, 16);
		getContentPane().add(lblPressure);
		
		pressure = new JTextField();
		pressure.setBounds(80, 410, 129, 22);
		getContentPane().add(pressure);
		pressure.setColumns(10);
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
	
	public void setDroneState(String name) {this.droneState.setText(name);}
	
	public void setPressure(String val) {this.pressure.setText(val);}
}
