/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.PIDController;

public class TankDrive extends SubsystemBase {
  /**
   * Creates a new TankDrive.
   */
  private Talon fl, ml, bl, fr, mr, br;
  private SpeedControllerGroup left;
  private SpeedControllerGroup right;
  private DifferentialDrive drivetrain;
  public TankDrive() {
    /*
    fl = new Talon();
    ml = new Talon();
    bl = new Talon();
    fr = new Talon();
    mr = new Talon();
    br = new Talon();
    */
    //TODO get port numbers for each motor
    left = new SpeedControllerGroup(fl, ml, bl);
    right = new SpeedControllerGroup(fr, mr, br);
    drivetrain = new DifferentialDrive(left, right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
