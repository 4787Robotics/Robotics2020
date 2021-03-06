/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */

   private WPI_TalonSRX fly;
   //private PWMVictorSPX fly2;
   private double x;
   //private DigitalInput PESensor;

  public Intake() {
    
    fly = new WPI_TalonSRX(Constants.fly1);
    //fly2 = new PWMVictorSPX(Constants.fly2);
    
    //PESensor = new DigitalInput(Constants.PEsensor);
  }

  public void stopFlywheels(){
    fly.set(0);
    //fly2.stopMotor();
  }

  public void intake(){

    fly.set(0.7);
    System.out.println("Molly is cool " + x++);
  }

  public void intakePixy() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
