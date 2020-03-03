/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveWithGyro;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TankDriveSubsystem;
import io.github.pseudoresonance.pixy2api.Pixy2;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import io.github.pseudoresonance.pixy2api.links.SPILink;
import frc.robot.subsystems.IndexSystem;
import frc.robot.subsystems.Intake;
import frc.robot.commands.IntakeIndexCommand;


public class AutonomousCommand extends WaitCommand {
  private DriveWithGyro m_driveGyro;
  private Intake intake;
  private IndexSystem index;
  private double x = 1;
  private boolean turn = false;
  private boolean flush = false;
  private boolean back = false;

  // double initialAngle;
  // double kP = 1;
  // */
  /**
   * Creates a new Autonomous.
   */

  public AutonomousCommand(TankDriveSubsystem tankdrive, IndexSystem index, Intake intake, double seconds, boolean turn, boolean flush) {
    super(seconds);
   // System.out.println("AutoCommand");
    m_driveGyro = new DriveWithGyro(0,0,0,tankdrive);
    this.turn = turn;
    index = new IndexSystem();
    intake = new Intake();
    this.flush = flush;

    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(tankdrive);
  }

  public AutonomousCommand(TankDriveSubsystem tankdrive, double seconds, boolean turn, boolean back) {
    super(seconds);
    m_driveGyro = new DriveWithGyro(0,0,0,tankdrive);
    this.turn = turn;
    this.back = back;

    // Use addRequirements() here to declare subsystem dependencies
    addRequirements(tankdrive);

  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    super.initialize();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    super.execute();
    /*
    double error = initialAngle - m_gyro.getAngle();
    tankDriveSubsystem.drive(.5 + kP * error, .5 - kP * error);
    tankDriveSubsystem.drive(0.5 , 0.5);
    */
    
    if(flush == true) {
      turn = false;
      intake.intake();
      index.index();
    }
    if(turn == false && flush == false)
    {
      if(back == true) {
        m_driveGyro.drive(-.65,0);
      }
      else if(back == false)
      {
        m_driveGyro.drive(.65,0);
      }
    }
    else if(turn == true)
    {
      m_driveGyro.drive(0,1);
    }

    
    //System.out.println("Driving autonomously");
    // Temporarily add widget to dashboard to play with PID setting
   // System.out.println("Running YOUR auto");
    SmartDashboard.putNumber("Angle PID", m_driveGyro.getMeasurement());
  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    super.end(interrupted);
    m_driveGyro.stop();
    System.out.println("Autocommand has ended");
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return super.isFinished();
    
  }
}
