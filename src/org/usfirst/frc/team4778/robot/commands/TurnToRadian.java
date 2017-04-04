package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToRadian extends Command {
	private PIDController pid;
	double p, i, d;
	private boolean isFinished = false;
	private double angle;

	public TurnToRadian(double angle) {
		requires(Robot.drivetrain);
		this.angle = angle;
		pid = new PIDController(0.125, 0.0, 0.0, angle);
	}

	@Override
	protected void initialize() {
		System.out.println("-init TurnToAngle");
		pid.setTolerence(1);
		pid.setOutputLimits(-1, 1);
		System.out.println("-end-init TurnToAngle");
	}

	@Override
	protected void execute() {
		System.out.println("-exe TurnToAngle");
		double out = pid.computePID(RobotMap.ahrs.getYaw());
		Robot.drivetrain.tankDrive(-out, out);
		if (pid.onTarget()) {
			isFinished = true;
		}
		//		p = SmartDashboard.getNumber("p");
		//		i = SmartDashboard.getNumber("i");
		//		d = SmartDashboard.getNumber("d");
		//		//pid.setTunings(p, i, d);
		//		SmartDashboard.putNumber("p", p);
		//		SmartDashboard.putNumber("i", i);
		//		SmartDashboard.putNumber("d", d);
		System.out.println("-end-exe TurnToAngle");
	}

	@Override
	protected void end() {
		RobotMap.h = angle;
		Robot.drivetrain.stop();
		System.out.println("-end TurnToAngle");
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}
}
