package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Dispense extends Command {
	public Dispense() {}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		RobotMap.hopper.set(-0.5);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		RobotMap.hopper.set(0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
