// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Tower;

public class TowerManager extends CommandBase {
  private final Tower ballHandeler;
  private final RobotContainer container;
  /** Creates a new TowerManager. */
  public TowerManager(Tower tower, RobotContainer container) {
    ballHandeler = tower;
    this.container = container;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(tower);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Tower.armsUp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    int pov = container.getOperatorJoystick().getPOV();
    //System.out.println(pov);
    if (pov == 180) {
      //Forward
      ballHandeler.intake();
    } else if (pov == 0) {
      //reverse
      ballHandeler.eject();
    } else {
      //No input
      ballHandeler.stop();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ballHandeler.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
