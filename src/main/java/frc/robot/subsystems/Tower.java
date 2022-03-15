// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.Tower.*;

public class Tower extends SubsystemBase {
  
  private final WPI_TalonSRX arms = new WPI_TalonSRX(ARMS_PORT);
  private final WPI_TalonSRX tower = new WPI_TalonSRX(TRAVERSIAL_PORT);
  private final WPI_TalonSRX gatekeeper = new WPI_TalonSRX(GATEKEEPER_PORT);
  private final static DoubleSolenoid armSolenoid = new DoubleSolenoid(1, PneumaticsModuleType.REVPH, 2, 3);
  
  /** Creates a new Tower. */
  public Tower() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static void armsUp() {
    armSolenoid.set(Value.kForward);
  }

  public void armsDown() {
    armSolenoid.set(Value.kReverse);
  }

  public void armsToggle() {
    armSolenoid.toggle();
  }

  public void intake() {
    arms.set(1);
    tower.set(0.75);
  }

  public void feedgatekeeper() {
    tower.set(0.5);
    gatekeeper.set(1);
  }

  public void eject() {
    arms.set(-1);
    tower.set(-1);
    gatekeeper.set(-0.5);
  }

  public void stop() {
    arms.set(0);
    tower.set(0);
    gatekeeper.set(0);
  }

}
