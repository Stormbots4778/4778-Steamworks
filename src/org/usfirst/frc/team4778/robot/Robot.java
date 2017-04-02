package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4778.robot.subsystems.Feeder;
import org.usfirst.frc.team4778.robot.subsystems.Hanger;
import org.usfirst.frc.team4778.robot.subsystems.Hopper;
import org.usfirst.frc.team4778.robot.subsystems.Intake;
import org.usfirst.frc.team4778.robot.subsystems.Shooter;

import com.ctre.CANTalon.FeedbackDevice;

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
	public Solenoid gearChute = RobotMap.gearChute;
	public static OI oi = new OI();
	Command autonomousCommand;

	@Override
	public void robotInit() {
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		gearChute.set(false);
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
		RobotMap.S0.setF(0.041439);
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

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
