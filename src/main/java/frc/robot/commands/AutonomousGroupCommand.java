/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.TankDriveSubsystem;
import frc.robot.commands.AutonomousCommand;

public class AutonomousGroupCommand extends SequentialCommandGroup {
  
  /**
   * Creates a new AutonomousGroupCommand.
   */
  public AutonomousGroupCommand(TankDriveSubsystem tankdrive) {
    addCommands(
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
