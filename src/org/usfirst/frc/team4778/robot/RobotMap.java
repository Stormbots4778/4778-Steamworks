package org.usfirst.frc.team4778.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
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
	public static CANTalon intake = new CANTalon(12);
	// Hopper
	public static CANTalon hopper = new CANTalon(13);
	// Hanging Mechanism
	public static CANTalon hangingMechanism = new CANTalon(14);
	// Ball Feed
	public static VictorSP feed = new VictorSP(9);
	// Gear Chute
	public static Solenoid gearChute = new Solenoid(0);
	// Encoders
	public static Encoder leftEncoder = new Encoder(0, 1);
	public static Encoder rightEncoder = new Encoder(2, 3);
	// Telemetry for smartdashboard
	public static boolean isGearChuteOpen = false;
	public static boolean isShooterOn = false;
	public static boolean isFeedOn = false;
}
