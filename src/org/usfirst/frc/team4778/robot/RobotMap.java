package org.usfirst.frc.team4778.robot;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class RobotMap {
	// Practice Setup
	// Auto
	public static SendableChooser auto = new SendableChooser();
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
	public static Solenoid gearChute = new Solenoid(1);
	// Pressure Sensor
	public static AnalogInput pressureSensor = new AnalogInput(0);
	// NavX-MXP
	public static AHRS ahrs = new AHRS(SerialPort.Port.kMXP);
	public static boolean isGearChuteOpen = false;
	public static boolean isShooterOn = false;
	public static boolean isFeedOn = false;
	//public static boolean isInverted = false;
}
