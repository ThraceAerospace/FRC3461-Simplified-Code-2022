// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.*;

public class autonomousDT extends CommandBase {
    
    private final Shooter shooter;
    private final DriveTrain driveTrain;
    private final Tower ballHandler;
    private final RobotContainer container;
  
    private double timer = Timer.getFPGATimestamp();
    private boolean isfinished = false;

  /** Creates a new Autonomous. */
  public autonomousDT(DriveTrain driveTrain, Shooter shooter, Tower intake, RobotContainer container) {
    this.driveTrain = driveTrain;
    this.shooter = shooter;
    this.ballHandler = intake;;
    this.container = container;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain, ballHandler);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   double time = Timer.getFPGATimestamp() - timer;
    if(time < 1.1){
      driveTrain.percentDrive(0.5, 0.5);
      ballHandler.armsDown();
      ballHandler.intake();
    } else if (time < 1.6){
      Tower.armsUp();
      ballHandler.stop();
      driveTrain.percentDrive(-0.5, 0.5);
    } else if (time < 2){
      driveTrain.percentDrive(0, 0);
      // turret.turretRotations(-0.4);
    } else {
      driveTrain.percentDrive(0, 0);
      isfinished = true;
    }
   

  //shooter.setShooterSpeed(3500); //todo PID Loop
  //shooter.setHoodSpeed(80); //todo Make this an angle converter
   
  // if (time > 3) {
  //   ballHandler.intake();
  // }
  // if (time > 8) {
  //   isfinished = true;
  // }
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.setShooterSpeed(0);
    ballHandler.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isfinished;
  }
}
