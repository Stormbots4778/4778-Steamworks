package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	public Shoot() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		RobotMap.S0.set(0.8);
		RobotMap.S1.set(0.8);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		RobotMap.S0.set(0);
		RobotMap.S1.set(0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
