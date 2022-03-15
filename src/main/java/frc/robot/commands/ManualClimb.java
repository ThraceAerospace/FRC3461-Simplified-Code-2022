package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Climber;

public class ManualClimb extends CommandBase{
    Climber climber;
    private RobotContainer container;

  public ManualClimb(Climber climber, RobotContainer container) {
    this.climber = climber;
    this.container = container;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Joystick climberJoystick = container.getClimberJoystick();
      climber.setArmPercent(climberJoystick.getRawAxis(1));

    if (climber.brakeState() == Value.kReverse) {
      climber.setLiftPercent(climberJoystick.getRawAxis(3));
    } else {
      climber.setLiftPercent(0);
    }
      if (climberJoystick.getRawButton(8)) { 
        climber.brakeOff();
      } else {
        climber.brakeOn();
      }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climber.brakeOn();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
