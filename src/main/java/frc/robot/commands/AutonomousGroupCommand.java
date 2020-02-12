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

public class AutonomousGroupCommand extends SequentialCommandGroup {
  
  /**
   * Creates a new AutonomousGroupCommand.
   */
  public AutonomousGroupCommand(TankDriveSubsystem tankdrive) {
    addCommands(
      new AutonomousCommand(tankdrive, 2.0, false),
      new AutonomousCommand(tankdrive, 1.0, true)

    );
  }

  
}
