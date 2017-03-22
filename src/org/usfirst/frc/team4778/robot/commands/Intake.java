package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command {
	double power;

	public Intake(double pwr) {
		requires(Robot.intake);
		pwr = power;
	}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		RobotMap.IN.set(power);
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