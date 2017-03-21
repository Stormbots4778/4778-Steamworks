package org.usfirst.frc.team4778.robot;

import com.ctre.CANTalon;

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
	public static CANTalon S0 = new CANTalon(10);
	public static CANTalon S1 = new CANTalon(11);
	// Intake
	public static CANTalon IN = new CANTalon(6);
	// Hopper
	public static CANTalon HP = new CANTalon(7);
	// Hanging Mechanism
	public static CANTalon HM = new CANTalon(8);
	// Feeder
	public static VictorSP FD = new VictorSP(9);
	// Gear Shifting
	//public static Solenoid out = new Solenoid(x); // ID TBD
	//public static Solenoid in = new Solenoid(x); // ID TBD
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
	// Feeder
	public static VictorSP FD = new VictorSP(9);
	*/
}
