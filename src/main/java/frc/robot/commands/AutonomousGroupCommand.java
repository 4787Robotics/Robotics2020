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
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.PixyCam;
import frc.robot.subsystems.PneumaticsArm;
import frc.robot.subsystems.TankDriveSubsystem;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import frc.robot.commands.AutonomousCommand;

public class AutonomousGroupCommand extends SequentialCommandGroup {
  double xTester = 0;
  double yTester = 0;

  // This is a bit of a hack, but I'm not sure of a better way to signal that one of our
  // auto commands is done or not.
  boolean commandIsDone;

  /**
   * Creates a new AutonomousGroupCommand.
   */
  public AutonomousGroupCommand(TankDriveSubsystem tankdrive, PixyCam pixy, Intake intake, PneumaticsArm pneumaticsArm) {
    addCommands(
      new FunctionalCommand(() -> {
        // initialize() - This gets run when the command initializes.
        commandIsDone = false;
      }, () -> {
        // execute() -  This code gets executed a bunch of times as needed. It's essentially a loop that FRC
        // runs, and allows FRC to interrupt it! A while loop was a bad idea (all Will's fault :-D)
        System.out.println("yooo" + this.isFinished() + xTester++);
        tankdrive.drive(0, 0.5);
        Block largestBlock = pixy.findBiggestBlock();
        if (largestBlock != null && (140 <= largestBlock.getX() && largestBlock.getX() < 170)) {
          // This is our trigger that our auto command finished
          commandIsDone = true;
       }
      }, (Boolean interrupted) -> {
        // end() - FRC has told us our command is done. Techincally I don't even have to think we need
        // to set commandIsDone to anything here, because FRC has already terminated this command.
        commandIsDone = true;
      }, () -> { 
        // isFinished() - Return whether or not the command is running. This is how we can tell the command
        // to stop executing early.
        return commandIsDone; 
      }, tankdrive)
      //.withTimeout(5)
      ,

      //turn to the right until ball x coordinate is within target range
    //    new InstantCommand(() -> {
    //      while(xTester == 0) {
    //        System.out.println("yooo" + this.isFinished() + xTester++);
    //        tankdrive.drive(0, 0.5);
    //        Block largestBlock = pixy.findBiggestBlock();
    //       if (largestBlock != null && (140 <= largestBlock.getX() && largestBlock.getX() < 170)) {
    //         break;
    //       }
    //     }
    //     System.out.println("Instant Command is still Running" + yTester++);

    //   }, tankdrive),
    //   //drive straight until ball is in close proximity
    //   new InstantCommand(() -> {
    //     while(true) {
    //       tankdrive.drive(0.5, 0);
    //       Block largestBlock = pixy.findBiggestBlock();
    //      if (largestBlock != null && (50 <= largestBlock.getY() && largestBlock.getY() < 150)){
    //        break;
    //      }
    //    }
    //  }, tankdrive),
    //  //ball is theoretically in perfect position, pick up ball!
    //  new InstantCommand(() -> {
    //   if (pneumaticsArm.isUp == false){
    //     pneumaticsArm.down();
    //   }
    //   intake.intake();
    //  }, intake),
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
