package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {
	private boolean isFinished = false;

	public DriveForward() {}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		Robot.drive.tankDrive(-0.5, -0.5);
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		Robot.drive.tankDrive(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
