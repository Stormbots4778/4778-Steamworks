package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4778.robot.subsystems.Feeder;
import org.usfirst.frc.team4778.robot.subsystems.Hanger;
import org.usfirst.frc.team4778.robot.subsystems.Hopper;
import org.usfirst.frc.team4778.robot.subsystems.Intake;
import org.usfirst.frc.team4778.robot.subsystems.Shooter;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final RobotDrive drive = new RobotDrive(RobotMap.L0, RobotMap.L1, RobotMap.R0, RobotMap.R1);
	public static final Shooter shooter = new Shooter();
	public static final Hanger hanger = new Hanger();
	public static final Intake intake = new Intake();
	public static final Hopper hopper = new Hopper();
	public static final Feeder feeder = new Feeder();
	public Solenoid gearChuteIn = RobotMap.gearChuteIn;
	public Solenoid gearChuteOut = RobotMap.gearChuteOut;
	public static OI oi = new OI();
	Command autonomousCommand;
	StringBuilder _sb = new StringBuilder();
	int _loops = 0;

	@Override
	public void robotInit() {
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		gearChuteIn.set(true);
		gearChuteIn.set(false);
		/* first choose the sensor */
		RobotMap.S0.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		RobotMap.S0.reverseSensor(false);
		//_talon.configEncoderCodesPerRev(XXX), // if using FeedbackDevice.QuadEncoder
		//_talon.configPotentiometerTurns(XXX), // if using FeedbackDevice.AnalogEncoder or AnalogPot
		/* set the peak and nominal outputs, 12V means full */
		RobotMap.S0.configNominalOutputVoltage(+0.0f, -0.0f);
		RobotMap.S0.configPeakOutputVoltage(+12.0f, -12.0f);
		/* set closed loop gains in slot0 */
		RobotMap.S0.setProfile(0);
		RobotMap.S0.setF(0.1097);
		RobotMap.S0.setP(0.22);
		RobotMap.S0.setI(0);
		RobotMap.S0.setD(0);
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		if (autonomousCommand != null) autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null) autonomousCommand.cancel();
	}

	@Override
	public void disabledInit() {}

	// SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI SPAGHETTI
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		double motorOutput = RobotMap.S0.getOutputVoltage() / RobotMap.S0.getBusVoltage();
		/* prepare line to print */
		_sb.append("\tout:");
		_sb.append(motorOutput);
		_sb.append("\tspd:");
		_sb.append(RobotMap.S0.getSpeed());
		if (OI.gamepad.getRawButton(2)) {
			/* Speed mode */
			double targetSpeed = 1160.25; //leftYstick * 1500.0; /* 1500 RPM in either direction */
			RobotMap.S0.changeControlMode(TalonControlMode.Speed);
			RobotMap.S0.set(targetSpeed); /* 1500 RPM in either direction */
			/* append more signals to print when in speed mode. */
			_sb.append("\terr:");
			_sb.append(RobotMap.S0.getClosedLoopError());
			_sb.append("\ttrg:");
			_sb.append(targetSpeed);
		} else {
			/* Percent voltage mode */
			RobotMap.S0.changeControlMode(TalonControlMode.PercentVbus);
			RobotMap.S0.set(0);
		}
		if (++_loops >= 10) {
			_loops = 0;
			System.out.println(_sb.toString());
		}
		_sb.setLength(0);
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
