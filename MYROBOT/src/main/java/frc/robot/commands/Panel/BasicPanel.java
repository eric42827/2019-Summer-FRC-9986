package frc.robot.commands.Panel;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BasicPanel extends Command {
  public BasicPanel() {
    requires(Robot.m_Panel);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    int Pov = Robot.m_oi.GetPov();
    if(Pov == 0){
      Robot.m_Panel.SetSpeed(1);
    }else if(Pov == 180){
      Robot.m_Panel.SetSpeed(-1);
    }else{
      Robot.m_Panel.SetSpeed(0);
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
