/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.controller.PIDController;

public class DriveWithGyro extends PIDSubsystem {
  /**
   * Creates a new DriveWithGyro.
   */

  private int Kp;
  private int Ki;
  private int Kd;

  private Talon fl, bl, fr, br;
  private SpeedControllerGroup left;
  private SpeedControllerGroup right;
  private DifferentialDrive drivetrain;
  private ADXRS450_Gyro m_gyro;
  private double initialAngle;

  public DriveWithGyro() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0, 0, 0));
    fl = new Talon(Constants.motor_fl);
    bl = new Talon(Constants.motor_bl);
    fr = new Talon(Constants.motor_fr);
    br = new Talon(Constants.motor_br);
    
    left = new SpeedControllerGroup(fl, bl);
    right = new SpeedControllerGroup(fr, br);
    drivetrain = new DifferentialDrive(left, right);
    m_gyro = new ADXRS450_Gyro();
    initialAngle = m_gyro.getAngle();
  }

  public void drive(double y, double z){
    drivetrain.arcadeDrive(-y,(0.75 *  z), true);
  }

  public void stop(){
    drivetrain.stopMotor();
  }

  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here
    drivetrain.arcadeDrive(-y, 0.75*z);
    if (getMeasurement() == initialAngle){ 

    } else {

    }
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return m_gyro.getAngle();
  }
}
