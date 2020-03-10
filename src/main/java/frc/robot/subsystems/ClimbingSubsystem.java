/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ClimbingSubsystem extends SubsystemBase {
  /**
   * Creates a new ClimbingSubsystem.
   */
  private WPI_TalonSRX climber;

  public ClimbingSubsystem() {
    climber = new WPI_TalonSRX(Constants.climber);
  }

  public void climbUp() {
    climber.set(.5);
    System.out.println("Climbing down");
  }

  public void climbDown() {
    climber.set(-.5);
    System.out.println("Climbing down");
  }

  public void stopClimbing() {
    climber.set(0);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
