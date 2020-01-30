/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithGyro extends PIDSubsystem {
  /**
   * Creates a new DriveWithGyro.
   */

  private PWMVictorSPX fl, bl, fr, br;
  private SpeedControllerGroup left;
  private SpeedControllerGroup right;
  private DifferentialDrive drivetrain;

  private ADXRS450_Gyro m_gyro;

  public DriveWithGyro(double kp, double ki, double kd) {
    super(
        // The PIDController used by the subsystem
        new PIDController(kp, ki, kd));
    setSetpoint(m_gyro.getAngle());

    fl = new PWMVictorSPX(Constants.motor_fl);
    bl = new PWMVictorSPX(Constants.motor_bl);
    fr = new PWMVictorSPX(Constants.motor_fr);
    br = new PWMVictorSPX(Constants.motor_br);
    
    left = new SpeedControllerGroup(fl, bl);
    right = new SpeedControllerGroup(fr, br);
    drivetrain = new DifferentialDrive(left, right);
    m_gyro = new ADXRS450_Gyro();
    
    // Temporarily add widget to dashboard to play with PID setting
    SmartDashboard.putData("Angle PID", this);
  }


  public void drive(double y, double z){
    drivetrain.arcadeDrive(-y,(0.75 *  z), true);
  }

  public void stop(){
    drivetrain.stopMotor();
  }

  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here
    this.drive(0, setpoint);
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    System.out.println("Getting angle value: " + m_gyro.getAngle());
    return m_gyro.getAngle();
  }
}
