package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Dispense;
import org.usfirst.frc.team4778.robot.commands.Feed;
import org.usfirst.frc.team4778.robot.commands.Hang;
import org.usfirst.frc.team4778.robot.commands.Intake;
import org.usfirst.frc.team4778.robot.commands.Shoot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	// Joysticks
	public static Joystick leftJoystick = new Joystick(1);
	public static Joystick rightJoystick = new Joystick(0);
	// Redundant Gamepad
	public static Joystick gamepad = new Joystick(2);
	// Button Board 
	//
	// Update when new drivers station is built
	//
	/*
	// Hanging Mechanism
	public static JoystickButton coil = new JoystickButton(nip, value);
	public static JoystickButton uncoil = new JoystickButton(nip, value);
	// Intake
	public static JoystickButton intake = new JoystickButton(nip, value);
	public static JoystickButton outtake = new JoystickButton(nip, value);
	// Shooter
	public static JoystickButton shoot = new JoystickButton(nip, value);
	// Hopper
	public static JoystickButton dispense = new JoystickButton(nip, value);
	// Ball Feed
	public static JoystickButton feedG = new JoystickButton(nip, value);
	*/
	// Redundant Gamepad Buttons (note: G is for Gamepad)
	// Hanging Mechanism
	public static JoystickButton coilG = new JoystickButton(leftJoystick, 1);
	public static JoystickButton uncoilG = new JoystickButton(rightJoystick, 1);
	// Intake
	public static JoystickButton intakeG = new JoystickButton(gamepad, 6);
	public static JoystickButton outtakeG = new JoystickButton(gamepad, 5);
	// Shooter
	public static JoystickButton shootG = new JoystickButton(gamepad, 2);
	// Hopper
	public static JoystickButton dispenseG = new JoystickButton(gamepad, 3);
	// Ball Feed
	public static JoystickButton feedG = new JoystickButton(gamepad, 1);

	public OI() {
		/*
		Will be button board calls
		// Hanging Mechanism
		coil.whileHeld(new Hang(1));
		uncoil.whileHeld(new Hang(-1));
		// Intake
		intake.whileHeld(new Intake(1));
		outtake.whileHeld(new Intake(-1));
		// Shooter
		shoot.toggleWhenPressed(new Shoot());
		// Hopper
		dispense.toggleWhenPressed(new Dispense());
		// Ball Feed
		feed.toggleWhenPressed(new Feed());
		*/
		// Redundant Gamepad Calls
		// Hanging Mechanism
		coilG.whileHeld(new Hang(1));
		uncoilG.whileHeld(new Hang(-1));
		// Intake
		intakeG.whileHeld(new Intake(1));
		outtakeG.whileHeld(new Intake(-1));
		// Shooter
		shootG.toggleWhenPressed(new Shoot());
		// Hopper
		dispenseG.toggleWhenPressed(new Dispense());
		// Ball Feed
		feedG.toggleWhenPressed(new Feed());
	}
}
