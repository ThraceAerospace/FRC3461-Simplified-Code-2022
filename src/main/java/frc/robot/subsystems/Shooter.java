// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.Shooter.*;
import static frc.robot.Constants.Climber.*;

public class Shooter extends SubsystemBase {
  private final WPI_TalonSRX hoodMotor = new WPI_TalonSRX(HOOD_PORT);
  private final CANSparkMax turretMotor = new CANSparkMax(TURRET_PORT, MotorType.kBrushless);

  private final WPI_TalonFX leftFlywheel = new WPI_TalonFX(MIDDLE_WINCH_TOP_PORT);
  private final WPI_TalonFX rightFlywheel = new WPI_TalonFX(MIDDLE_WINCH_BOTTOM_PORT);

  /** Creates a new Hood. */
  public Shooter() {

    rightFlywheel.follow(leftFlywheel);
    rightFlywheel.setInverted(InvertType.FollowMaster);

    //PID Controls
    SmartDashboard.putNumber("shooter kp", 0);
    SmartDashboard.putNumber("shooter ki", 0);
    SmartDashboard.putNumber("shooter kd", 0);
    SmartDashboard.putNumber("shooter kf", 0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  
    double p = SmartDashboard.getNumber("shooter kp", 0);
    double i = SmartDashboard.getNumber("shooter ki", 0);
    double d = SmartDashboard.getNumber("shooter kd", 0);
    double f = SmartDashboard.getNumber("shooter kf", 0);


    configPID(f, p, i, d);  
  
  }

  public void setHoodSpeed(double speed) {
    hoodMotor.set(speed);
  }

  public void setNumericalSpeed(double speed) {
      leftFlywheel.set(speed);
  }


  public void setPIDSpeed(double pidVelocity) {
    leftFlywheel.set(ControlMode.Velocity, pidVelocity);
  }

  public void setTurretSpeed(double speed) {
    turretMotor.set(speed);
  }



  private void configPID(double kF, double kP, double kI, double kD){
    leftFlywheel.config_kF(0, kF);
    leftFlywheel.config_kP(0, kP);
    leftFlywheel.config_kI(0, kI);
    leftFlywheel.config_kD(0, kD);
    leftFlywheel.configClosedloopRamp(2);
  }

}
