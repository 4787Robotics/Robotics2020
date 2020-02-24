/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.I2C.Port;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int motor_fr = 3;
	public static int motor_fl = 2;
	public static int motor_br = 4;
	public static int motor_bl = 1;

	public static int fly1 = 5;
	public static int fly2 = 6;

	public static int PEsensor = 7;
	public static int conveyerLeft = 8;
	public static int conveyerRight = 9;

	public static int shooterWheel = 0;

	public static Joystick m_Joystick = new Joystick(0);

	public Joystick getJoystick() {
		return m_Joystick;
	}
	
	public static double getRx() {
		return Math.pow(m_Joystick.getX(), 1);
	}
	
	public static double getRy() {
		return Math.pow(m_Joystick.getY(), 1);
	}
	
	public static double getRz() {
		return Math.pow(m_Joystick.getZ(), 1);
	}

	public static boolean getButtonTwo() {
		return m_Joystick.getRawButtonPressed(2);
	}
	
}
