/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;

public class IndexSystem extends SubsystemBase {
  /**
   * Creates a new IndexSystem.
   */

  private PWMVictorSPX conveyerLeft;
  private PWMVictorSPX conveyerRight;
  private DigitalInput PEsensor;

  public IndexSystem() {
    conveyerLeft = new PWMVictorSPX(Constants.conveyerLeft);
    conveyerRight = new PWMVictorSPX(Constants.conveyerRight);
    PEsensor = new DigitalInput(Constants.PEsensor);
  }

  public boolean getSensor(){
    return PEsensor.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
