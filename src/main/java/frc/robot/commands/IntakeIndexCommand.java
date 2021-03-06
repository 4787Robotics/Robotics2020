/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IndexSystem;

public class IntakeIndexCommand extends CommandBase {
  /**
   * Creates a new IntakeIndexCommand.
   */
  private final Intake m_intake;
  private final IndexSystem m_index;

  public IntakeIndexCommand(Intake intake, IndexSystem index) {
    m_intake = intake;
    m_index = index;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake, index);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.intake();
    m_index.index();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.stopFlywheels();
    m_index.stopIndex();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
