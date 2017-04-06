package org.usfirst.frc.team4778.robot.commands.auto;

import org.usfirst.frc.team4778.robot.commands.AutoDrive;
import org.usfirst.frc.team4778.robot.commands.Chute;
import org.usfirst.frc.team4778.robot.commands.Delay;

public class AutoCenterGear extends Auto {
	@Override
	public void autoRun() {
		addSequential(new AutoDrive(2));
		addSequential(new Delay(0.5));
		addSequential(new Chute());
		addSequential(new Delay(1));
		addSequential(new AutoDrive(0.5, -1));
	}
}
