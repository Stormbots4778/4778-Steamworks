package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Hang;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static Joystick leftJoystick = new Joystick(1);
	public static Joystick rightJoystick = new Joystick(0);
	public static JoystickButton coil = new JoystickButton(leftJoystick, 3);
	public static JoystickButton uncoil = new JoystickButton(leftJoystick, 2);

	public OI() {
		coil.whileHeld(new Hang());
		uncoil.whileHeld(new Hang());
	}
}
