/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class PneumaticsArm extends SubsystemBase {
  /**
   * Creates a new PneumaticsArm.
   */
  DoubleSolenoid doubleSolenoid;
  public boolean isUp;

  public PneumaticsArm() {
    doubleSolenoid = new DoubleSolenoid(1,2);
    isUp = true;
  }

  public void down() {
    doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    doubleSolenoid.set(DoubleSolenoid.Value.kOff); 
    System.out.println("Hola amigos I am down");
    isUp = false;     
  }

  public void up() {
    doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    doubleSolenoid.set(DoubleSolenoid.Value.kOff);
    System.out.println("Hola amigos I am up");
    isUp = true;
  }

  public void toggle() {
    if(isUp == true){
      down();
    }
    else {
      up();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
