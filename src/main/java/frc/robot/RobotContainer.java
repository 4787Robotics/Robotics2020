/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
//import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import io.github.pseudoresonance.pixy2api.Pixy2;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController.Button;
import io.github.pseudoresonance.pixy2api.links.Link;

import java.util.Set;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  //Ignore that stuff
  private final TankDriveSubsystem tankDriveSubsystem = new TankDriveSubsystem();
  private final Intake m_intake = new Intake();
  private final Joystick joyStick = new Joystick(0);
  // private final DriveWithGyro m_driveWithGyro = new DriveWithGyro(0, 0, 0, tankDriveSubsystem);
  private final IndexSystem index = new IndexSystem();
  private final PneumaticsArm parm = new PneumaticsArm();
  private final ShooterSubsystem shooterWheel = new ShooterSubsystem();
  private final PixyCam pixy = new PixyCam();

  //private final ADXRS450_Gyro m_gyro = new ADXRS450_Gyro();
  //private final USBCamera camera = new USBCamera();

  private final DriveCommand m_driveCommand = new DriveCommand(tankDriveSubsystem);
  // private final AutonomousCommand m_autoCommand = new AutonomousCommand(tankDriveSubsystem,2,false);
  private final AutonomousGroupCommand AGCommand = new AutonomousGroupCommand(tankDriveSubsystem, pixy, m_intake, parm, index);
  private final IntakeCommand m_intakeCommand = new IntakeCommand(m_intake);
  private final IndexCommand m_indexCommand = new IndexCommand(index);
  private final IntakeIndexCommand intakeIndex = new IntakeIndexCommand(m_intake, index);
  private double x;
  private boolean AutoOn = false;
  private Link link;
  


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    System.out.println("RobotContainer");
    tankDriveSubsystem.setDefaultCommand(
      new RunCommand( 
        () -> {
           tankDriveSubsystem.drive(joyStick.getY(), joyStick.getZ());
        },
        tankDriveSubsystem
      )
    );

    // index.setDefaultCommand(
    //   new RunCommand(
    //     () -> {
    //       index.index();
    //     },
    //     index
    //   )
    // );

    
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //joystick button one is now used to turn on intake flywheel and index pulley system
    new JoystickButton(joyStick, 1).whileHeld(intakeIndex);
    //new JoystickButton(joyStick, 2).whileHeld(m_intakeCommand);
    new JoystickButton(joyStick, 7).whenPressed( 
      new InstantCommand(
        () -> {
         parm.toggle();
         System.out.println("Pneumatics " + x++);
      }
      , parm
    ));
    new JoystickButton(joyStick, 10).whenPressed( 
      new InstantCommand(
        () -> {
         shooterWheel.shoot();
         System.out.println("Shooting");
      }
      , shooterWheel
    ));
    new JoystickButton(joyStick, 11).whenPressed(
      new InstantCommand(
        () -> {
          tankDriveSubsystem.drive(2,3);
        }
      , tankDriveSubsystem
    ));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

   
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    return AGCommand;
  }
}
