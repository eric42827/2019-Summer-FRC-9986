package frc.robot.commands.Cargo;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class BasicCargo extends Command {
  public Encoder Encoder_A = new Encoder(9, 8);
  
  public BasicCargo() {
    requires(Robot.m_Cargo);
  }

  @Override
  protected void initialize() {
    Encoder_A.reset();
    
  }

  @Override
  protected void execute() {
    System.out.println(Encoder_A.getDistance());
    if(Robot.m_oi.Controller.getRawButton(RobotMap.Up_Button)){
      Robot.m_Cargo.SetIntakeSpeed(1);
    }else if(Robot.m_oi.Controller.getRawButton(RobotMap.Down_Button)){
      Robot.m_Cargo.SetIntakeSpeed(-0.25);
    }else{
      Robot.m_Cargo.SetIntakeSpeed(0);
    }

    if(Robot.m_oi.Controller.getRawButton(RobotMap.JR_Button)){
      Robot.m_Cargo.SetIntakePitchSpeed(1);
    }else if(Robot.m_oi.Controller.getRawAxis(RobotMap.Joystick_RT) > 0.7){
      Robot.m_Cargo.SetIntakePitchSpeed(-1);
    }else{
      Robot.m_Cargo.SetIntakePitchSpeed(0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
