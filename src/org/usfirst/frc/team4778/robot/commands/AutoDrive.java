package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	private boolean isFinished = false;
	private int distance = 0;
	private PIDController pid;
	double p, i, d, power;

	public AutoDrive(int distance) {
		this.distance = distance;
	}

	@Override
	protected void initialize() {
		//RobotMap.leftEncoder.setDistancePerPulse(0.073017485503355); // Get ALL THE DIGITS
		//RobotMap.rightEncoder.setDistancePerPulse(0.073017485503355);
		pid = new PIDController(0.05, 0, 0, distance);
		pid.setTolerence(1);
		pid.setOutputLimits(-0.85, 0.85);
	}

	@Override
	protected void execute() {
		//double power = pid.computePID(RobotMap.ahrs.getVelocity);
		Robot.drive.tankDrive(power, power);
		if (pid.onTarget()) {
			isFinished = true;
		}
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
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
}
