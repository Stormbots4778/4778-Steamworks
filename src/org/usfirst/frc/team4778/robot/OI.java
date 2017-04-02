package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Chute;
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
	// Logitech Gamepad
	public static Joystick gamepad = new Joystick(2);
	//
	// Update when new drivers station is built
	//
	// Hanging Mechanism
	public static JoystickButton coilG = new JoystickButton(gamepad, 8);
	public static JoystickButton uncoilG = new JoystickButton(gamepad, 7);
	// Intake
	public static JoystickButton intakeG = new JoystickButton(gamepad, 6);
	//public static JoystickButton outtakeG = new JoystickButton(gamepad, 5);
	// Shooter
	public static JoystickButton shootG = new JoystickButton(gamepad, 2);
	// Hopper
	public static JoystickButton dispenseG = new JoystickButton(gamepad, 3);
	// Ball Feed
	public static JoystickButton feedG = new JoystickButton(gamepad, 1);
	// Gear Chute
	public static JoystickButton chuteG = new JoystickButton(gamepad, 4);

	public OI() {
		// Gamepad Calls
		// Hanging Mechanism
		coilG.whileHeld(new Hang(1));
		uncoilG.whileHeld(new Hang(-1));
		// Intake
		intakeG.whileHeld(new Intake());
		//outtakeG.whileHeld(new Intake());
		// Shooter
		shootG.toggleWhenPressed(new Shoot());
		// Hopper
		dispenseG.toggleWhenPressed(new Dispense());
		// Ball Feed
		feedG.toggleWhenPressed(new Feed());
		// Gear Chute
		chuteG.whenPressed(new Chute());
	}
}
