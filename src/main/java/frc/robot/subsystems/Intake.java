/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */

   private PWMVictorSPX fly1;
   private PWMVictorSPX fly2;
   private DigitalInput PEsensor;


  public Intake() {

    fly1 = new PWMVictorSPX(Constants.fly1);
    fly2 = new PWMVictorSPX(Constants.fly2);
    PEsensor = new DigitalInput(Constants.PEsensor);

  }

  public boolean getSensor(){
      return PEsensor.get();
  }

  public void stopFlywheels(){
    fly1.stopMotor();
    fly2.stopMotor();
  }

  public void intake(){
    if (getSensor()) {
      fly1.set(1.0);
      fly2.set(-1.0);
    } else {
      stopFlywheels();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
