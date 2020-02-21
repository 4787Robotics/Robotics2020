/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import java.awt.*;
import edu.wpi.first.wpilibj.PWMTalonSRX;

public class IndexSystem extends SubsystemBase {
  /**
   * Creates a new IndexSystem.
   */

  private TalonSRX conveyerLeft;
  private TalonSRX conveyerRight;
  private DigitalInput PEsensor;

  public IndexSystem() {
    conveyerLeft = new TalonSRX(Constants.conveyerLeft);
    // conveyerRight = new TalonSRX(Constants.conveyerRight);
    PEsensor = new DigitalInput(Constants.PEsensor);
  }

  public boolean getSensor(){
    return PEsensor.get();
  }
  
  public void index() {
    if(getSensor() == true) {
      moveBelt();
    }
  }
  
  public void moveBelt() {
    conveyerLeft.set(ControlMode.PercentOutput, 0.5);
    System.out.println("moooooooooooooooovvveee leeeeeeeeeeeeeeffffffffffftttttttt");
    conveyerRight.set(ControlMode.PercentOutput, 0.5);
    System.out.println("mooooooooooooooooovvvvvveeeeeeee riiiiiiiiiiiggggggghhhhhhttttt");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
