package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	private boolean isFinished = false;
	private int time = 0;
	private double endTime;

	public AutoDrive(int time) {
		this.time = time;
	}

	// SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE
	@Override
	protected void initialize() {
		//RobotMap.leftEncoder.setDistancePerPulse(0.073017485503355); // Get ALL THE DIGITS
		//RobotMap.rightEncoder.setDistancePerPulse(0.073017485503355);
		endTime = Timer.getFPGATimestamp() + time;
	}

	@Override
	protected void execute() {
		Robot.drive.tankDrive(0.4, 0.4);
		if (Timer.getFPGATimestamp() >= endTime) {
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
