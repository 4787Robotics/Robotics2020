/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.PixyCam;
import frc.robot.subsystems.PneumaticsArm;
import frc.robot.subsystems.TankDriveSubsystem;
import frc.robot.commands.AutonomousCommand;

public class AutonomousGroupCommand extends SequentialCommandGroup {
  
  /**
   * Creates a new AutonomousGroupCommand.
   */
  public AutonomousGroupCommand(TankDriveSubsystem tankdrive, PixyCam pixy, Intake intake, PneumaticsArm pneumaticsArm) {
    addCommands(
      //turn to the right until ball x coordinate is within target range
       new InstantCommand(() -> {
         while(true) {
           tankdrive.drive(0, 0.5);
          if (140 <= pixy.findBiggestBlock().getX() && pixy.findBiggestBlock().getX() < 170){
            break;
          }
        }
      }, tankdrive),
      //drive straight until ball is in close proximity
      new InstantCommand(() -> {
        while(true) {
          tankdrive.drive(0.5, 0);
         if (50 <= pixy.findBiggestBlock().getY() && pixy.findBiggestBlock().getY() < 150){
           break;
         }
       }
     }, tankdrive),
     //ball is theoretically in perfect position, pick up ball!
     new InstantCommand(() -> {
      if (pneumaticsArm.isUp == false){
        pneumaticsArm.down();
      }
      intake.intake();
     }, intake),
      //new WaitUntilCommand(140 < pixy.findBiggestBlock().getX() <= 170),
      // new WaitUntilCommand(pixy.findBiggestBlock().getX() == 100),
      new AutonomousCommand(tankdrive, 1, false),
      new AutonomousCommand(tankdrive, 0.9, true),
      new AutonomousCommand(tankdrive, .8, false),
      new AutonomousCommand(tankdrive, 1.6, true),
      new AutonomousCommand(tankdrive, .6, false),
      new AutonomousCommand(tankdrive, 2, true, true),
      new AutonomousCommand(tankdrive, 1.2, false, false)

    );
  }

  
}
