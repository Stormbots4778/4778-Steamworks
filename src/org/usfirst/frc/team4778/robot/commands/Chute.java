package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Chute extends Command {
	boolean finished = false;

	public Chute() {}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		finished = false;
		boolean chuteOut = RobotMap.gearChuteOut.get();
		boolean chuteIn = RobotMap.gearChuteIn.get();
		RobotMap.gearChuteOut.set(!chuteOut);
		RobotMap.gearChuteIn.set(!chuteIn);
		finished = true;
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {
		end();
	}
}
