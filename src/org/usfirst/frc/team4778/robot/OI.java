package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Dispense;
import org.usfirst.frc.team4778.robot.commands.Hang;
import org.usfirst.frc.team4778.robot.commands.Intake;
import org.usfirst.frc.team4778.robot.commands.Shoot;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static Joystick leftJoystick = new Joystick(1);
	public static Joystick rightJoystick = new Joystick(0);
	public static JoystickButton coil = new JoystickButton(leftJoystick, 3);
	public static JoystickButton uncoil = new JoystickButton(leftJoystick, 2);
	//public static JoystickButton intake = new JoystickButton(Joystick, Button);
	//public static JoystickButton shoot = new JoystickButton(Joystick, Button);
	//public static JoystickButton dispense = new JoystickButton(Joystick, Button);

	public OI() {
		//Dispense.toggleWhenPressed(new Intake());
		coil.toggleWhenPressed(new Hang());
		//intake.toggleWhenPressed(new Intake());
		//shoot.toggleWhenPressed(new Shoot());
	}
}
