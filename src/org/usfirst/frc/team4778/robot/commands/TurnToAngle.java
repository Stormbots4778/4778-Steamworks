package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToAngle extends Command {
	private PIDController pid;
	double p, i, d;
	private boolean isFinished = false;
	private double angle;

	public TurnToAngle(double angle) { // Angle in degrees
		requires(Robot.drivetrain);
		this.angle = angle;
		pid = new PIDController(0.125, 0.0, 0.0, angle);
		RobotMap.ahrs.reset();
	}

	@Override
	protected void initialize() { // DO NOT FORGET: -150 to 150
		pid.setTolerence(10);
		pid.setOutputLimits(-0.8, 0.8);
	}

	@Override
	protected void execute() {
		double out = pid.computePID(RobotMap.ahrs.getYaw());
		Robot.drive.tankDrive(-out, out);
		if (pid.onTarget()) {
			isFinished = true;
		}
	}

	@Override
	protected void end() {
		Robot.drive.tankDrive(0, 0);
		Robot.drive.stopMotor();
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}
}
