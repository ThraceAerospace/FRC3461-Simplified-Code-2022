// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.DriveTrain.*;

public class DriveTrain extends SubsystemBase {
  
  private final WPI_TalonFX dtTopLeft= new WPI_TalonFX(LEFT_TOP_PORT);
  private final WPI_TalonFX dtBottomLeft= new WPI_TalonFX(LEFT_BOTTOM_PORT);
  private final WPI_TalonFX dtTopRight= new WPI_TalonFX(RIGHT_TOP_PORT);
  private final WPI_TalonFX dtBottomRight= new WPI_TalonFX(RIGHT_BOTTOM_PORT);
  private final DifferentialDrive dDrive = new DifferentialDrive(dtTopLeft, dtTopRight);

  /** Creates a new DriveTrain. */
  public DriveTrain() {

    //SmartDashboard.putData(this);
    dtBottomLeft.follow(dtTopLeft);
    dtBottomLeft.setInverted(true);
    dtBottomLeft.setInverted(InvertType.FollowMaster);

    dtBottomRight.follow(dtTopRight);
    dtBottomRight.setInverted(false);
    dtBottomRight.setInverted(InvertType.FollowMaster);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    dDrive.feed();

  }

      /**
     * set left and right speeds as a percentage of full power
     * @param rSpeed right side power percentage
     * @param lSpeed left side power percentage
     */
    public void percentDrive(double rSpeed, double lSpeed) {
      SmartDashboard.putNumber("DT left speed", lSpeed);
      SmartDashboard.putNumber("DT right speed", rSpeed); 
      //dtTopLeft.set(ControlMode.PercentOutput, lSpeed);
      //dtTopRight.set(ControlMode.PercentOutput, rSpeed);

      dDrive.tankDrive(lSpeed, rSpeed);;

      dDrive.feed(); //keep the wpilib arcade drive that we need for auto from freaking out
  }
}
