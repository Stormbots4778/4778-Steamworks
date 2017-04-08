package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Chute;
import org.usfirst.frc.team4778.robot.commands.Hang;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	// Joysticks
	public static Joystick leftJoystick = new Joystick(1);
	public static Joystick rightJoystick = new Joystick(0);
	// Xbox Gamepad
	public static Joystick gamepad = new Joystick(2);
	//           
	// Update when new drivers station is built - rip
	//
	// Hanging Mechanism
	public static JoystickButton coilG = new JoystickButton(gamepad, 7);
	public static JoystickButton uncoilG = new JoystickButton(gamepad, 8);
	// Gear Chute
	public static JoystickButton chuteG = new JoystickButton(gamepad, 4);
	// Invert Drive
	//public static JoystickButton invert = new JoystickButton(leftJoystick, 1);

	public OI() {
		// Gamepad Calls
		// Hanging Mechanism
		coilG.whileHeld(new Hang(-0.25));
		uncoilG.whileHeld(new Hang(-1));
		// Gear Chute
		chuteG.whenPressed(new Chute());
		// Invert controls
		//invert.whenPressed(new InvertDrive());
	}
}
