package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Feed extends Command {
	public Feed() {}

	@Override
	protected void initialize() {
		RobotMap.FD.set(0.8);
		RobotMap.isFeedOn = true;
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		RobotMap.FD.set(0);
		RobotMap.isFeedOn = false;
	}

	@Override
	protected void interrupted() {
		end();
	}
}
