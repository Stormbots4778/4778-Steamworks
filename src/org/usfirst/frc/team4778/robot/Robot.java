package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.auto.AutoCenterGear;
import org.usfirst.frc.team4778.robot.commands.auto.AutoCrossLine;
import org.usfirst.frc.team4778.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.CameraServer;
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
		// Camera
		CameraServer.getInstance().addAxisCamera("10.47.78.11");
		initSmartDashboard();
		updateSmartDashboard();
	}

	public void initSmartDashboard() {
		System.out.println("+robot init-smartdashboard");
		RobotMap.auto.addObject("Drive Forward (Cross Line)", new AutoCrossLine());
		RobotMap.auto.addObject("Center Gear", new AutoCenterGear());
	}

	public void updateSmartDashboard() {
		System.out.println("+robot update-smartdashboard");
		SmartDashboard.putBoolean("Gear Chute Status: ", RobotMap.isGearChuteOpen);
		SmartDashboard.putBoolean("Shooter Status: ", RobotMap.isShooterOn);
		SmartDashboard.putBoolean("Ball Feed Status", RobotMap.isFeedOn);
		SmartDashboard.putNumber("Pressure: ", RobotMap.pressureSensor.getValue());
		SmartDashboard.putData("Auto Chooser", RobotMap.auto);
		//		SmartDashboard.putBoolean("Inverted Controls Status: ", RobotMap.isInverted);
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
		CameraServer.getInstance().getVideo();
		Scheduler.getInstance().run();
		updateSmartDashboard();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
