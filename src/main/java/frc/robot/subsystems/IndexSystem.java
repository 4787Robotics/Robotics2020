/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.DigitalInput;

public class IndexSystem extends SubsystemBase {
  /**
   * Creates a new IndexSystem.
   */

  private WPI_TalonSRX belt;
  //private TalonSRX conveyerRight;
  //private DigitalInput PEsensor;

  public IndexSystem() {
    belt = new WPI_TalonSRX(Constants.conveyerLeft);
    // conveyerRight = new TalonSRX(Constants.conveyerRight);
    //PEsensor = new DigitalInput(Constants.PEsensor);
  }

  public boolean getSensor(){
    //return PEsensor.get();
    return false;
  }
  
  public void indexwPE() {
    if(getSensor() == true) {
      // belt.set(ControlMode.PercentOutput, 0.5);
      belt.set(0.5);
      System.out.println("moooooooooooooooovvveee");

    } 
  }
  //indexing without the PE Sensor because I don't know if we will have it done for UIC but maybe Peoria - Yahir
  public void index() {
    // belt.set(ControlMode.PercentOutput, .5);
    belt.set(.5);
  }

  public void stopIndex(){
    belt.set(0);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run 
  }
}
