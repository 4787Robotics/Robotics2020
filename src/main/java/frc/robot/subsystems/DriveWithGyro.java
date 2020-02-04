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
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SPI.Port;
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

  private Talon fl, bl, fr, br;
  private SpeedControllerGroup left;
  private SpeedControllerGroup right;
  private DifferentialDrive drivetrain;

  private ADXRS450_Gyro m_gyro;
  private TankDriveSubsystem tankdrive;

  public DriveWithGyro(double kp, double ki, double kd,TankDriveSubsystem tankdrive) {
    super(
        // The PIDController used by the subsystem
        new PIDController(kp, ki, kd));
    this.tankdrive = tankdrive;
    // fl = new Talon(Constants.motor_fl);
    // bl = new Talon(Constants.motor_bl);
    // fr = new Talon(Constants.motor_fr);
    // br = new Talon(Constants.motor_br);
    
    // left = new SpeedControllerGroup(fl, bl);
    // right = new SpeedControllerGroup(fr, br);
    // drivetrain = new DifferentialDrive(left, right);
    System.out.println("Gyrooooo");
    m_gyro = new ADXRS450_Gyro(Port.kOnboardCS2);

    setSetpoint(m_gyro.getAngle());
    
    // Temporarily add widget to dashboard to play with PID setting
    SmartDashboard.putNumber("Angle PID", m_gyro.getAngle());
  }


  public void drive(double y, double z){
    //drivetrain.arcadeDrive(-y,(0.75 *  z), true);
    tankdrive.drive(-y,(0.75 *  z));
  }

  public void stop(){
    //drivetrain.stopMotor();
    tankdrive.stop();
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
    SmartDashboard.putNumber("Angle PID", m_gyro.getAngle());
    return m_gyro.getAngle();
  }
}
