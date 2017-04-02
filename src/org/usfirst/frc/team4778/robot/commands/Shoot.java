package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	StringBuilder _sb = new StringBuilder();
	int _loops = 0;

	public Shoot() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		/* first choose the sensor */
		RobotMap.S0.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		RobotMap.S0.reverseSensor(false);
		//_talon.configEncoderCodesPerRev(XXX), // if using FeedbackDevice.QuadEncoder
		//_talon.configPotentiometerTurns(XXX), // if using FeedbackDevice.AnalogEncoder or AnalogPot
		/* set the peak and nominal outputs, 12V means full */
		RobotMap.S0.configNominalOutputVoltage(+0.0f, -0.0f);
		RobotMap.S0.configPeakOutputVoltage(+12.0f, -12.0f);
		/* set closed loop gains in slot0 */
		RobotMap.S0.setProfile(0);
		RobotMap.S0.setF(0.1097);
		RobotMap.S0.setP(0.22);
		RobotMap.S0.setI(0);
		RobotMap.S0.setD(0);
	}

	@Override
	public void execute() {
		RobotMap.S0.enableBrakeMode(false);
		RobotMap.S1.enableBrakeMode(false);
		double motorOutput = RobotMap.S0.getOutputVoltage() / RobotMap.S0.getBusVoltage();
		/* prepare line to print */
		_sb.append("\tout:");
		_sb.append(motorOutput);
		_sb.append("\tspd:");
		_sb.append(RobotMap.S0.getSpeed());
		/* Speed mode */
		double targetSpeed = 3087; //leftYstick * 1500.0; /* 1500 RPM in either direction */
		RobotMap.S0.changeControlMode(TalonControlMode.Speed);
		RobotMap.S0.set(-targetSpeed); /* 1500 RPM in either direction */
		RobotMap.S1.set(-targetSpeed); /* 1500 RPM in either direction */
		/* append more signals to print when in speed mode. */
		_sb.append("\terr:");
		_sb.append(RobotMap.S0.getClosedLoopError());
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
		RobotMap.S0.set(0);
		RobotMap.S1.set(0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
