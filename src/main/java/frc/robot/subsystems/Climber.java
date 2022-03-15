
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.Climber.*;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  private WPI_TalonFX liftMasterController = new WPI_TalonFX(MIDDLE_WINCH_TOP_PORT); 
  private WPI_TalonFX liftSlaveController = new WPI_TalonFX(MIDDLE_WINCH_BOTTOM_PORT);
  //private DoubleSolenoid  leftArmWhich = new DoubleSolenoid(1, PneumaticsModuleType.REVPH, 4, 5);
    //private DoubleSolenoid secondaryArmSolenoid = new DoubleSolenoid(1, PneumaticsModuleType.REVPH, 6, 7);
  private WPI_TalonFX armWinch = new WPI_TalonFX(ARM_PORT);

  private final DoubleSolenoid armBrake = new DoubleSolenoid(1, PneumaticsModuleType.REVPH, 5, 4);


  /** Creates a new Climber. */
  public Climber() {
    liftSlaveController.follow(liftMasterController);

    liftMasterController.setInverted(false);
    liftSlaveController.setInverted(InvertType.FollowMaster);

  }
 
  public void setLiftPercent(double percent){
    liftMasterController.set(percent);
  }

  public void setArmPercent(double percent){
    armWinch.set(percent);
  }


  public void brakeOn() {
    armBrake.set(Value.kForward);
  }

  public void brakeOff() {
    armBrake.set(Value.kReverse);
  }

  public Value brakeState() {
    return armBrake.get();
  }

  // public void extendArm(){
  //   armWinch.set(1);
  // }

  // public void retractArm(){
  //   armWinch.set(-1);
  // }

  // public void stopArm() {
  //   armWinch.set(0);
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
