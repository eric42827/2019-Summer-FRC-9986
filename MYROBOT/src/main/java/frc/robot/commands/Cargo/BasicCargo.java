package frc.robot.commands.Cargo;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class BasicCargo extends Command {
  
  public BasicCargo() {
    requires(Robot.m_Cargo);
  }

  @Override
  protected void initialize() {
    
  }

  @Override
  protected void execute() {
    if(Robot.m_oi.GetButton(RobotMap.Button_Up)){
      Robot.m_Cargo.SetIntakeSpeed(1);
    }else if(Robot.m_oi.GetButton(RobotMap.Button_Down)){
      Robot.m_Cargo.SetIntakeSpeed(-0.25);
    }else{
      Robot.m_Cargo.SetIntakeSpeed(0);
    }
    if(Robot.m_oi.GetButton(RobotMap.Button_Right_Back)){
      Robot.m_Cargo.SetIntakePitchSpeed(1);
    }else if(Robot.m_oi.GetAxis(RobotMap.Axis_RT) > 0.7){
      Robot.m_Cargo.SetIntakePitchSpeed(-1);
    }else{
      Robot.m_Cargo.SetIntakePitchSpeed(0);
    }
  }

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
