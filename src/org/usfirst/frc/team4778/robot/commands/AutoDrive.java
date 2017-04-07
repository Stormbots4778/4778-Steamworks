package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	private boolean isFinished = false;
	private double time = 0;
	private double endTime = 0;
	private int isForward = 1;
	private PIDController pid;
	double p, i, d, power;

	public AutoDrive(double time, int isForward) { // isFoward is either -1 or 1
		this.time = time;
		this.isForward = isForward;
	}

	public AutoDrive(double time) { // isForward default is 1
		this.time = time;
	}

	// SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE SCREW DISTANCE
	@Override
	protected void initialize() {
		//RobotMap.leftEncoder.setDistancePerPulse(0.073017485503355); // Get ALL THE DIGITS
		//RobotMap.rightEncoder.setDistancePerPulse(0.073017485503355);
		endTime = Timer.getFPGATimestamp() + 1;
		pid = new PIDController(0.125, 0, 0, 1);
		pid.setTolerence(1);
		pid.setOutputLimits(-1, 1);
	}

	@Override
	protected void execute() {
		if (Timer.getFPGATimestamp() >= endTime) {
			isFinished = true;
		}
		double tout = pid.computePID(RobotMap.ahrs.getYaw());
		Robot.drive.arcadeDrive(0.8 * isForward, tout);
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		Robot.drive.arcadeDrive(0, 0);
		Robot.drive.stopMotor();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
