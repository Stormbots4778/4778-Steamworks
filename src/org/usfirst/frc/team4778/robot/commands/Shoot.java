package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	CANTalon S0 = RobotMap.S0;
	CANTalon S1 = RobotMap.S1;
	boolean isShooterOn = RobotMap.isShooterOn;
	StringBuilder _sb = new StringBuilder();
	int _loops = 0;

	public Shoot() {}

	@Override
	protected void initialize() {}

	@Override
	public void execute() {
		S0.enableBrakeMode(false);
		S1.enableBrakeMode(false);
		isShooterOn = true;
		double motorOutput = S0.getOutputVoltage() / S0.getBusVoltage();
		// Prepare line to print
		_sb.append("\tout:");
		_sb.append(motorOutput);
		_sb.append("\tspd:");
		_sb.append(S0.getSpeed());
		// Speed mode
		double targetSpeed = 3087; // 3087 RPM in either direction
		S0.changeControlMode(TalonControlMode.Speed);
		S0.set(-targetSpeed); // Set master target speed
		S1.set(-targetSpeed); // Set slave target speed
		// Append more signals to print when in speed mode
		_sb.append("\terr:");
		_sb.append(S0.getClosedLoopError());
		_sb.append("\ttrg:");
		_sb.append(targetSpeed);
		if (++_loops >= 10) {
			_loops = 0;
			System.out.println(_sb.toString());
		}
		_sb.setLength(0);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		S0.set(0);
		S1.set(0);
		isShooterOn = false;
	}

	@Override
	protected void interrupted() {
		end();
	}
}
