/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */

  private PWMTalonSRX shooter;
  //private Pixy2 pixy;

  public ShooterSubsystem() {
    shooter = new PWMTalonSRX(Constants.shooterWheel);
    //supply link based on how we wire the Pixycam
    
    
  }

  public void shoot(){
    shooter.setSpeed(1.0);
  }

  public void stopShooting(){
    shooter.stopMotor();
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
