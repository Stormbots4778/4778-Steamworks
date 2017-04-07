package org.usfirst.frc.team4778.robot.commands.auto;

import org.usfirst.frc.team4778.robot.commands.AutoDrive;
import org.usfirst.frc.team4778.robot.commands.TurnToAngle;

import edu.wpi.first.wpilibj.Timer;

public class AutoRightGear extends Auto {
	@Override
	public void autoRun() {
		addSequential(new AutoDrive(3));
		Timer.delay(0.1);
		addSequential(new TurnToAngle(-45));
		Timer.delay(0.1);
		addSequential(new AutoDrive(3));
		/*Timer.delay(0.1);
		addSequential(new Chute());
		Timer.delay(0.1);
		addSequential(new AutoDrive(1, -1));*/
	}
}
