// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final PneumaticHub pneumaticHub = new PneumaticHub();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    
  }

 //OI
 private final Joystick driverJoystick = new Joystick(0);
 private final Joystick operatorJoystick = new Joystick(1);
 private final Joystick climberJoystick = new Joystick(2);

 private final JoystickButton layupButton = new JoystickButton(operatorJoystick, 2);

 //Subsystems
 private final DriveTrain driveTrain = new DriveTrain();
 private final Shooter shooter = new Shooter();
 private final Tower tower = new Tower();
 private final Climber climber = new Climber();

 //Commands
 //private final DashboardManager dash = new DashboardManager();
 private final teleopDT dtTeleop = new teleopDT(driveTrain, this);
 private final autonomousDT dtAutonomous = new autonomousDT(driveTrain, shooter, tower, this);
 private final TowerManager towerManager = new TowerManager(tower, this);
 private final ManualClimb manualClimb = new ManualClimb(climber, this);
 private final LayupShot layupShot = new LayupShot(shooter);
 

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
   //Default Commands
   driveTrain.setDefaultCommand(dtTeleop);
   tower.setDefaultCommand(towerManager);
   climber.setDefaultCommand(manualClimb);

   layupButton.whileHeld(layupShot);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return dtAutonomous;
  }





  public Joystick getDriverJoystick() {
    return driverJoystick;
  }

  public Joystick getOperatorJoystick() {
    return operatorJoystick;
  }

  public Joystick getClimberJoystick() {
    return climberJoystick;
  }



  public PneumaticHub getPneumaticHub(){
    return pneumaticHub;
  }

  // public DashboardManager getDashboard() {
  //   return dash;
  // }
}
