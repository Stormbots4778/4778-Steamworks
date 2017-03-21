package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifters extends Subsystem {
	@Override
	public void initDefaultCommand() {}

	public void shift(boolean on) {
		RobotMap.driveShift.set(on);
	}
}
