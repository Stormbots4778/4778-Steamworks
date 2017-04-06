package org.usfirst.frc.team4778.robot.commands.auto;

import org.usfirst.frc.team4778.robot.commands.AutoDrive;

public class AutoCrossLine extends Auto {
	@Override
	public void autoRun() {
		addSequential(new AutoDrive(1));
	}
}
