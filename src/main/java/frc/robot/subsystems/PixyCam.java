/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.links.SPILink;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.TankDriveSubsystem;

import java.util.ArrayList;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PixyCam extends SubsystemBase {
  /**
   * Creates a new PixyCam.
   */

  private Pixy2 pixy;
  private static final int blockSignature = 1;

  public PixyCam() {
    pixy = Pixy2.createInstance(new SPILink());
    pixy.init();
    pixy.setLamp((byte) 1, (byte) 1);
    pixy.setLED(0, 255, 0);
  }

  public Block findBiggestBlock(){
    int blockCount = pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 20);
    if (blockCount == 0){
      System.out.println("No blocks found");
      return null;
    }
    ArrayList<Block> blocks = pixy.getCCC().getBlocks();
    Block targetBlock = null;
    if (blocks == null){
      System.out.println("No blocks");
      return null;
    }
    for (Block block : blocks){
        if (block.getSignature() == blockSignature){
          if (targetBlock == null){
            targetBlock = block;
          } else if (block.getWidth() > targetBlock.getWidth()){
            targetBlock = block;
          }
        }
    }
    SmartDashboard.putNumber("Ball x", targetBlock.getX());
    SmartDashboard.putNumber("Ball y", targetBlock.getY());
    return targetBlock;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
