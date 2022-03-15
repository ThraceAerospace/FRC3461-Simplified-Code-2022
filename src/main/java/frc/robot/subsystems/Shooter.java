// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.Shooter.*;

public class Shooter extends SubsystemBase {
  private final WPI_TalonSRX hoodMotor = new WPI_TalonSRX(HOOD_PORT);
  private final CANSparkMax turretMotor = new CANSparkMax(TURRET_PORT, MotorType.kBrushless);

  /** Creates a new Hood. */
  public Shooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setHoodSpeed(double speed) {
    hoodMotor.set(speed);
  }

  public void setFlywheelSpeed(double speed) {

  }

  public void setTurretSpeed(double speed) {
    turretMotor.set(speed);
  }

}
