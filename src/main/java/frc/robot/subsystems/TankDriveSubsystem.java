/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class TankDriveSubsystem extends SubsystemBase {
  /**
   * Creates a new TankDrive.
   */
  //private Talon fl, bl, fr, br;
  private SpeedControllerGroup left;
  private SpeedControllerGroup right;
  private DifferentialDrive drivetrain;

  private WPI_VictorSPX fl, bl, fr, br;

  public TankDriveSubsystem() {
    fl = new WPI_VictorSPX(Constants.motor_fl);
    bl = new WPI_VictorSPX(Constants.motor_bl);
    fr = new WPI_VictorSPX(Constants.motor_fr);
    br = new WPI_VictorSPX(Constants.motor_br);
    left = new SpeedControllerGroup(fl, bl);
    right = new SpeedControllerGroup(fr, br);
    drivetrain = new DifferentialDrive(left, right);
  }

  public void drive(double y, double z, boolean goSlow){
    //drivetrain.arcadeDrive(Constants.getRx(), Constants.getRy(), Constants.getRz());
    //drivetrain.tankDrive(y,-x);
    //drivetrain.arcadeDrive(y, z);
    drivetrain.arcadeDrive(-y,(0.75 *  z), goSlow);
    //System.out.println("x = " + x + ", y = " + y);
  }

  public void stop(){
    drivetrain.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
