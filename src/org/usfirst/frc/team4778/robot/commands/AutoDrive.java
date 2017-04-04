package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	private boolean isFinished = false;
	private int distance = 0;

	public AutoDrive(int distance) {
		this.distance = distance;
	}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		Robot.drive.tankDrive();
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
