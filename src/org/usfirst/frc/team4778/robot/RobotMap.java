package org.usfirst.frc.team4778.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
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
	public static CANTalon IN = new CANTalon(12);
	// Hopper
	public static CANTalon HP = new CANTalon(13);
	// Hanging Mechanism
	public static CANTalon HM = new CANTalon(14);
	// Feeder
	public static VictorSP FD = new VictorSP(9);
	// Drive Gear Shifting
	public static Solenoid gearChuteOut = new Solenoid(0);
	public static Solenoid gearChuteIn = new Solenoid(1);
}
