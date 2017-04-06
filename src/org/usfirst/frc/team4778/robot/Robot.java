package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.auto.AutoCenterGear;
import org.usfirst.frc.team4778.robot.commands.auto.AutoCrossLine;
import org.usfirst.frc.team4778.robot.subsystems.Drivetrain;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final RobotDrive drive = new RobotDrive(RobotMap.L0, RobotMap.L1, RobotMap.R0, RobotMap.R1);
	Solenoid gearChute = RobotMap.gearChute;
	CANTalon S0 = RobotMap.S0;
	CANTalon S1 = RobotMap.S1;
	public static OI oi = new OI();
	Command autonomousCommand;

	@Override
	public void robotInit() {
		// Inverts drive motors
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		// Set gear chute to closed on robot init
		gearChute.set(false);
		// Chooses the sensor
		S0.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		S0.reverseSensor(false);
		// Set the peak and nominal outputs, 12V means full
		S0.configNominalOutputVoltage(+0.0f, -0.0f);
		S0.configPeakOutputVoltage(+12.0f, -12.0f);
		// Set closed loop gains in slot0
		S0.setProfile(0);
		// Set feed-forward gain and PID values
		S0.setF(0.04875);
		S0.setP(0.38);
		S0.setI(0);
		S0.setD(0);
		// Set and enable current limit at 30amps
		S0.setCurrentLimit(30);
		S1.setCurrentLimit(30);
		S0.EnableCurrentLimit(true);
		S1.EnableCurrentLimit(true);
		// Call initialization and updates smartdashboard
		initSmartDashboard();
		updateSmartDashboard();
	}

	public void initSmartDashboard() {
		System.out.println("+robot init-smartdashboard");
		RobotMap.auto.addObject("Line Auto", new AutoCrossLine());
		RobotMap.auto.addObject("Center Gear", new AutoCenterGear());
	}

	public void updateSmartDashboard() {
		System.out.println("+robot update-smartdashboard");
		SmartDashboard.putBoolean("Gear Chute Status: ", RobotMap.isGearChuteOpen);
		SmartDashboard.putBoolean("Shooter Status: ", RobotMap.isShooterOn);
		SmartDashboard.putBoolean("Ball Feed Status", RobotMap.isFeedOn);
		SmartDashboard.putNumber("Pressure: ", RobotMap.pressureSensor.getValue());
		SmartDashboard.putBoolean("Inverted Controls Status: ", RobotMap.isInverted);
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		autonomousCommand = (Command) RobotMap.auto.getSelected();
		if (autonomousCommand != null) autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null) autonomousCommand.cancel();
		RobotMap.ahrs.reset();
	}

	@Override
	public void disabledInit() {}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		updateSmartDashboard();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
