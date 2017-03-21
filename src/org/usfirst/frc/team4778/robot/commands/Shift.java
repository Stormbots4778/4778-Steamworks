package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shift extends Command {
	private boolean isFinished = false;

	public Shift() {
		requires(Robot.shift);
	}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		Robot.shift.shift(true);
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}
}
