/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.PixyCam;
import frc.robot.subsystems.PneumaticsArm;
import frc.robot.subsystems.TankDriveSubsystem;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.IndexSystem;

public class AutonomousGroupCommand extends SequentialCommandGroup {
  double xTester = 0;
  double yTester = 0;

  // This is a bit of a hack, but I'm not sure of a better way to signal that one of our
  // auto commands is done or not.
  boolean commandIsDone;

  /**
   * Creates a new AutonomousGroupCommand.
   */
  public AutonomousGroupCommand(TankDriveSubsystem tankdrive, PixyCam pixy, Intake intake, PneumaticsArm pneumaticsArm, IndexSystem index) {
    addCommands(
      // new FunctionalCommand(() -> {
      //   // initialize() - This gets run when the command initializes.
      //   commandIsDone = false;
      // }, () -> {
      //   // execute() -  This code gets executed a bunch of times as needed. It's essentially a loop that FRC
      //   // runs, and allows FRC to interrupt it! A while loop was a bad idea (all Will's fault :-D)
      //   System.out.println("yooo" + this.isFinished() + xTester++);
      //   tankdrive.drive(0, 0.5);
      //   Block largestBlock = pixy.findBiggestBlock();
      //   if (largestBlock != null && (140 <= largestBlock.getX() && largestBlock.getX() < 170)) {
      //     // This is our trigger that our auto command finished
      //     commandIsDone = true;
      //  }
      // }, (Boolean interrupted) -> {
      //   // end() - FRC has told us our command is done. Techincally I don't even have to think we need
      //   // to set commandIsDone to anything here, because FRC has already terminated this command.
      //   commandIsDone = true;
      // }, () -> { 
      //   // isFinished() - Return whether or not the command is running. This is how we can tell the command
      //   // to stop executing early.
      //   return commandIsDone; 
      // }, tankdrive)
      // //.withTimeout(5)
      // ,

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

      //new AutonomousCommand(tankdrive, index, intake, seconds, turn?, flush?)
      //There is also a new autonomous parameter that wont need to take in flush since it would be a lot to type out.
      //Make it easier for us. and I will implement a negative drive back for when we are at the wall. It goes like
      //new AutonomousCommand(tankdrive, seconds, turn, back)

      //IF WE ARE ON THE FAR RIGHTTTTTT ThEN THIS IS THE CODE WE SHOULD USE TO GO TO THE SHOOTER
      //This theoretical code, I didn't measure the distances since the robot is being worked on.
      new AutonomousCommand(tankdrive, index, intake, 1.0, false, false),
      new AutonomousCommand(tankdrive, index, intake, .5, true, false),
      new AutonomousCommand(tankdrive, index, intake, 2.5, false, false),
      new AutonomousCommand(tankdrive, index, intake, .5, true, false),
      new AutonomousCommand(tankdrive, index, intake, 1.25, false, false),

      //SHOOT 3 TIMES  BABY! I tried using a for loop and it didn't work so I just wrote it out 3 times. -Yahir
      new AutonomousCommand(tankdrive, index, intake, .1, false, true),
      new AutonomousCommand(tankdrive, index, intake, .1, false, true),
      new AutonomousCommand(tankdrive, index, intake, .1, false, true),

      //PART II: After shooting, let's try to collect balls to shoot with or allign ourselves in a position where we can collect balls yknow.
      new AutonomousCommand(tankdrive, .5, false, true),
      new AutonomousCommand(tankdrive, 1, true, false),
      new AutonomousCommand(tankdrive, 2, false, false),
      new AutonomousCommand(tankdrive, .5, true, false),
      new AutonomousCommand(tankdrive, 1.25, false, true)

    );
    
  }

  
}