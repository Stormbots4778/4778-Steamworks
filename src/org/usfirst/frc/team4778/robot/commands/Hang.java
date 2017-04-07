package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Hang extends Command {
	double power;

	public Hang(double pwr) {
		power = pwr;
	}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		RobotMap.hangingMechanism1.set(-power);
		RobotMap.hangingMechanism2.set(power);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		RobotMap.hangingMechanism1.set(0);
		RobotMap.hangingMechanism2.set(0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
