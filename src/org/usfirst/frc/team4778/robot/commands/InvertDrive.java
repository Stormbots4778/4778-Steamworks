package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class InvertDrive extends Command {
	boolean finished = false;

	public InvertDrive() {}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		/*RobotMap.isInverted = !RobotMap.isInverted;
		Robot.drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, !RobotMap.isInverted);
		Robot.drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, !RobotMap.isInverted);
		Robot.drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, !RobotMap.isInverted);
		Robot.drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, !RobotMap.isInverted);*/
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
