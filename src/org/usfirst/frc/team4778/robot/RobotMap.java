package org.usfirst.frc.team4778.robot;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

public class RobotMap {
	// Practice Setup
	// Left Motors
	public static Victor L0 = new Victor(0);
	public static Victor L1 = new Victor(1);
	// Right Motors
	public static Victor R0 = new Victor(2);
	public static Victor R1 = new Victor(3);
	// Shooter
	public static TalonSRX S0 = new TalonSRX(4);
	public static TalonSRX S1 = new TalonSRX(5);
	// Intake
	public static VictorSP IN = new VictorSP(6);
	// Hopper
	public static VictorSP HP = new VictorSP(7);
	// Hanging Mechanism
	public static VictorSP HM = new VictorSP(8);
	/*
	// Competition Setup
	// Left Motors
	public static VictorSP L0 = new VictorSP(0);
	public static VictorSP L1 = new VictorSP(1);
	// Right Motors
	public static VictorSP R0 = new VictorSP(2);
	public static VictorSP R1 = new VictorSP(3);
	// Shooter
	public static TalonSRX S0 = new TalonSRX(4);
	public static TalonSRX S1 = new TalonSRX(5);
	// Intake
	public static VictorSP IN = new VictorSP(6);
	// Hopper
	public static VictorSP HP = new VictorSP(7);
	// Hanging Mechanism
	public static TalonSRX HM = new TalonSRX(8);
	*/
}
