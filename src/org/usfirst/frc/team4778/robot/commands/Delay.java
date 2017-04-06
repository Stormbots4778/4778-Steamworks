package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Delay extends Command {
	public boolean isFinished = false;
	public double delay = 0;

	public Delay(double delay) {
		this.delay = delay;
	}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		Timer.delay(delay);
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {
		end();
	}
}
