/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.InterruptableSensorBase;
import edu.wpi.first.wpilibj.Joystick;


public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */

   private PWMVictorSPX fly1;
   private PWMVictorSPX fly2;
   private double x;
   //private DigitalInput PESensor;

  public Intake() {
    
    fly1 = new PWMVictorSPX(Constants.fly1);
    fly2 = new PWMVictorSPX(Constants.fly2);
    //PESensor = new DigitalInput(Constants.PEsensor);
  }

  public void stopFlywheels(){
    fly1.stopMotor();
    fly2.stopMotor();
  }

  public void intake(){

    fly1.set(1.0);
    fly2.set(1.0);
    System.out.println("Molly is cool " + x++);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
