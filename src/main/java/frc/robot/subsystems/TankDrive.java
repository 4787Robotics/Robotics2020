/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.controller.PIDController;

public class TankDrive extends SubsystemBase {
  /**
   * Creates a new TankDrive.
   */
  private Talon fl, bl, fr, br;
  private SpeedControllerGroup left;
  private SpeedControllerGroup right;
  private DifferentialDrive drivetrain;

  public TankDrive() {
    fl = new Talon(Constants.motor_fl);
    bl = new Talon(Constants.motor_bl);
    fr = new Talon(Constants.motor_fr);
    br = new Talon(Constants.motor_br);
    
    left = new SpeedControllerGroup(fl, bl);
    right = new SpeedControllerGroup(fr, br);
    drivetrain = new DifferentialDrive(left, right);
  }

  /*
  public void drive(double x, double y, double z){
    drivetrain.tankDrive(x, y);
  }
  */
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
