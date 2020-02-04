/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveWithGyro;
import frc.robot.subsystems.TankDriveSubsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class AutonomousCommand extends CommandBase {
  private TankDriveSubsystem tankDriveSubsystem;
  /*
  private ADXRS450_Gyro m_gyro;
  double initialAngle;
  double kP = 1;
  */
  /**
   * Creates a new Autonomous.
   */
  public AutonomousCommand(TankDriveSubsystem tankdrive) {
    System.out.println("AutoCommand");
    new DriveWithGyro(0,0,0,tankdrive);
    
    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(tankDriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      //initialAngle = m_gyro.getAngle();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*
    double error = initialAngle - m_gyro.getAngle();
    tankDriveSubsystem.drive(.5 + kP * error, .5 - kP * error);
    tankDriveSubsystem.drive(0.5 , 0.5);
    */
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
