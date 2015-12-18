package dtu.cdio.tutorial;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import de.yadrone.base.ARDrone;
import de.yadrone.base.command.EmergencyCommand;
import de.yadrone.base.navdata.ControlState;
import de.yadrone.base.navdata.DroneState;
import de.yadrone.base.navdata.StateListener;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;
import dtu.cdio.tutorial.gui.DroneVariablesGUI.ButtonCmd;
import dtu.cdio.tutorial.listeners.AltitudeListenerImpl;
import dtu.cdio.tutorial.listeners.AttitudeListenerImpl;
import dtu.cdio.tutorial.listeners.BatteryListenerImpl;
import dtu.cdio.tutorial.listeners.GyroListenerImpl;
import dtu.cdio.tutorial.listeners.PressureListenerImpl;
import dtu.cdio.tutorial.listeners.SpeedListenerImpl;
import dtu.cdio.tutorial.listeners.StateListenerImpl;
import dtu.cdio.tutorial.listeners.VideoListenerImpl;

public class TutorialMain implements ActionListener
{

	private boolean emergency = false;
	DroneVariablesGUI gui;
	private ARDrone drone;
	private StateListener stateListener;
	public volatile boolean isFlying = false;
	public int speed = 25;
	public static void main(String[] args)
	{
		new TutorialMain().run();
	}
	public void run(){

		try
		{
			gui = new DroneVariablesGUI();
			// Tutorial Section 1
			drone = new ARDrone();
			drone.start();
			drone.getCommandManager().flatTrim();
//			drone.getCommandManager().m
			//			drone.getCommandManager().setVideoChannel(VideoChannel.HORI);

			// Tutorial Section 3
			//			new TutorialVideoListener(drone);

			// Tutorial Section 4
			//			TutorialCommander commander = new TutorialCommander(drone);

			drone.addSpeedListener(new SpeedListenerImpl(gui));
			drone.getNavDataManager().addAttitudeListener(new AttitudeListenerImpl(gui));
			drone.getNavDataManager().addAltitudeListener(new AltitudeListenerImpl(gui));
			drone.getNavDataManager().addBatteryListener(new BatteryListenerImpl(gui));
			drone.getNavDataManager().addGyroListener(new GyroListenerImpl(gui));
			stateListener = new StateListenerImpl(gui, this);
			drone.getNavDataManager().addStateListener(stateListener);
			
			drone.getNavDataManager().addPressureListener(new PressureListenerImpl(gui));
			drone.getVideoManager().addImageListener(new VideoListenerImpl(gui, true));
			gui.addButtonListener(this);
			//			drone.getNavDataManager().addAcceleroListener(new AcceleroListener() {
			//
			//				@Override
			//				public void receivedRawData(AcceleroRawData d) {
			//					int[] accs = d.getRawAccs();
			//				}
			//
			//				@Override
			//				public void receivedPhysData(AcceleroPhysData d) {
			//					float accsTemp = d.getAccsTemp();
			//					int alim3v3 = d.getAlim3v3();
			//					float[] physAccs = d.getPhysAccs();
			//				}
			//			});
			//
			//			drone.getNavDataManager().addAdcListener(new AdcListener() {
			//
			//				@Override
			//				public void receivedFrame(AdcFrame d) {
			//					d.getData_frame();
			//				}
			//			});

			//			drone.getNavDataManager().addAltitudeListener(new AltitudeListener() {
			//
			//				@Override
			//				public void receivedExtendedAltitude(Altitude d) {
			//					int estState = d.getEstState();
			//					float[] estVb = d.getEstVb();
			//					float obsAccZ = d.getObsAccZ();
			//					float obsAlt = d.getObsAlt();
			//					int obsState = d.getObsState();
			//					float[] obsX = d.getObsX();
			//					int raw = d.getRaw();
			//					int ref = d.getRef();
			//					int vision = d.getVision();
			//					float zVelocity = d.getZVelocity();
			//					
			//					System.err.println("altitude ext: " + d.getObsAlt());
			//				}
			//
			//				@Override
			//				public void receivedAltitude(int altitude) {
			//					System.out.println("altitude simple: " + altitude);
			//				}
			//			});

			//			drone.getNavDataManager().addAttitudeListener(new AttitudeListener() {
			//				
			//				@Override
			//				public void windCompensation(float pitch, float roll) {
			//					
			//				}
			//				
			//				@Override
			//				public void attitudeUpdated(float pitch, float roll) {
			//					
			//				}
			//				
			//				@Override
			//				public void attitudeUpdated(float pitch, float roll, float yaw) {
			//					
			//				}
			//			});

			//			drone.getNavDataManager().addBatteryListener(new BatteryListener() {
			//				
			//				@Override
			//				public void voltageChanged(int vbat_raw) {
			//					
			//				}
			//				
			//				@Override
			//				public void batteryLevelChanged(int percentage) {
			//					
			//				}
			//			});
			//
			//			drone.getNavDataManager().addCounterListener(new CounterListener() {
			//				
			//				@Override
			//				public void update(Counters d) {
			//					long nrOfDoubleTaps = d.getNrOfDoubleTaps();
			//					long nrOfFinishLines = d.getNrOfFinishLines();
			//					
			//				}
			//			});
			//			
			//			drone.getNavDataManager().addGyroListener(new GyroListener() {
			//				
			//				@Override
			//				public void receivedRawData(GyroRawData d) {
			//					short[] rawGyros = d.getRawGyros();
			//					short[] rawGyros100 = d.getRawGyros110();
			//				}
			//				
			//				@Override
			//				public void receivedPhysData(GyroPhysData d) {
			//					int alim3v3 = d.getAlim3v3();
			//					int gyroTemp = d.getGyroTemp();
			//					float[] physGyros = d.getPhysGyros();
			//					int vrefEpson = d.getVrefEpson();
			//					int vrefIDG = d.getVrefIDG();
			//				}
			//				
			//				@Override
			//				public void receivedOffsets(float[] offset_g) {
			//					
			//				}
			//			});

			//			drone.getNavDataManager().addMagnetoListener(new MagnetoListener() {
			//				
			//				@Override
			//				public void received(MagnetoData d) {
			//					byte calibrationOk = d.getCalibrationOk();
			//					float errorMean = d.getErrorMean();
			//					float errorVar = d.getErrorVar();
			//					float headingFusionUnwrapped = d.getHeadingFusionUnwrapped();
			//					float headingGyroUnwrapped = d.getHeadingGyroUnwrapped();
			//					float headingUnwrapped = d.getHeadingUnwrapped();
			//					short[] m = d.getM();
			//					float[] m_ = d.getM_();
			//					float[] mRaw = d.getMraw();
			//					float[] mRectified = d.getMrectified();
			//					float radius = d.getRadius();
			//					int state = d.getState();
			//					
			//				}
			//			});
			//			
			//			drone.getNavDataManager().addPressureListener(new PressureListener() {
			//				
			//				@Override
			//				public void receivedPressure(Pressure d) {
			//					int measurement = d.getMeasurement();
			//					int value = d.getValue();
			//				}
			//				
			//				@Override
			//				public void receivedKalmanPressure(KalmanPressureData d) {
			//					float covAlt = d.getCovAlt();
			//					float covPWM = d.getCovPWM();
			//					float covVitesse = d.getCovVitesse();
			//					float estBiaisPression = d.getEstBiaisPression();
			//					float estBiasPWM = d.getEstBiasPWM();
			//					float estZ = d.getEstZ();
			//					float estZdot = d.getEstZdot();
			//					float gazAlt = d.getGazAltitude();
			//					float offsetPressure = d.getOffsetPressure();
			//					float offsetUS = d.getOffsetUS();
			//					float predictionUS = d.getPredictionUS();
			//					float sommeInno = d.getSommeInno();
			//					float uMultisinus = d.getUMultisinus();
			//				}
			//			});
			//			
			//			drone.getNavDataManager().addPWMlistener(new PWMlistener() {
			//				
			//				@Override
			//				public void received(PWMData d) {
			//					float altitudeDer = d.getAltitudeDer();
			//					float altitudeIntegral = d.getAltitudeIntegral();
			//					float altitudeProp = d.getAltitudeProp();
			//					int[] currentMotor = d.getCurrentMotor();
			//					float gazAlt = d.getGazAltitude();
			//					float gazFeedForward = d.getGazFeedForward();
			//					short[] motor = d.getMotor();
			//					short[] satMotor = d.getSatMotor();
			//					float uGazPlanif = d.getUGazPlanif();
			//					int[] uPlanifPry = d.getUPlanifPRY();
			//					int[] upry = d.getUPRY();
			//					float vzRef = d.getVzRef();
			//					float yawUi = d.getYawUI();
			//				}
			//			});

			//			drone.getNavDataManager().addReferencesListener(new ReferencesListener() {
			//				
			//				@Override
			//				public void receivedReferences(ReferencesData d) {
			//					
			//				}
			//				
			//				@Override
			//				public void receivedRcReferences(int[] rc_ref) {
			//					// TODO Auto-generated method stub
			//					
			//				}
			//			});

			//			drone.getNavDataManager().addStateListener(new StateListener() {
			//				
			//				@Override
			//				public void stateChanged(DroneState state) {
			//					
			//					if(state.isEmergency()) drone.getCommandManager().setCommand(new EmergencyCommand());
			//					
			//				}
			//				
			//				@Override
			//				public void controlStateChanged(ControlState state) {
			//					
			//				}
			//			});	

			//			if(emergency){
			//				System.err.println("was in emergency");
			//				drone.getCommandManager().setCommand(new EmergencyCommand());
			//			}


		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
//		finally
//		{
//			if (drone != null)
//				while(isFlying){};
//				drone.stop();
//		}
	}

	public void delay(long ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals(ButtonCmd.LAND.name())) drone.getCommandManager().landing();
		else if(cmd.equals(ButtonCmd.TAKE_OFF.name())) drone.getCommandManager().takeOff();
		else if(cmd.equals(ButtonCmd.SPEED_DOWN.name())) drone.setSpeed(speed -= gui.getSpeedDecr());
		else if(cmd.equals(ButtonCmd.SPEED_UP.name())) drone.setSpeed(speed += gui.getSpeedIncr());
		else if(cmd.equals(ButtonCmd.EMERGENCY.name())) drone.getCommandManager().emergency();
		else if(cmd.equals(ButtonCmd.TRIM.name())) drone.getCommandManager().flatTrim();
		else System.err.println("unknown button command");
		
		
	}
}
