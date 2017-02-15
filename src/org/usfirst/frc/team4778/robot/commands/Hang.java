package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Hang extends Command {
	public Hang() {
		requires(Robot.hanger);
	}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		RobotMap.HM.set(1);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		RobotMap.HM.set(0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
