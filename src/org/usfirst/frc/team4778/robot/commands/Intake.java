package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command {
	public Intake() {}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		RobotMap.IN.set(1);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		RobotMap.IN.set(0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
