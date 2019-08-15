package frc.robot.commands.Chassis;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.Useful;

public class JoystickDrive extends Command {
  public JoystickDrive() {
    requires(Robot.m_Chassis);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    double Rspd = 0.0;
    double Lspd = 0.0;
    double Joystick_Y = Robot.m_oi.GetAxis(RobotMap.Joystick_LY) * Useful.Boolean_To_Int(RobotMap.Joystick_Y_Invert);
    double Joystick_X = Robot.m_oi.GetAxis(RobotMap.Joystick_RX) * Useful.Boolean_To_Int(RobotMap.Joystick_X_Invert);
    if(!RobotMap.Joystick_Y_Linear){
      if(Joystick_Y > 0 && Joystick_Y < 1){
        Joystick_Y = Math.pow(Math.abs(Joystick_Y),2.5);
      }else if(Joystick_Y  < 0 && Joystick_Y > -1){
        Joystick_Y = -Math.pow(Math.abs(Joystick_Y),2.5);
      }
    }
    if(!RobotMap.Joystick_X_Linear){
      if(Joystick_X > 0 && Joystick_Y < 1){
        Joystick_X = Math.pow(Math.abs(Joystick_Y),2.5);
      }else if(Joystick_X  < 0 && Joystick_X > -1){
        Joystick_X = -Math.pow(Math.abs(Joystick_X),2.5);
      }
    }
    
    Rspd = Joystick_Y - Joystick_X;
    Lspd = Joystick_Y + Joystick_X;
    Rspd = Useful.Constrain(Rspd,1,-1);
    Lspd = Useful.Constrain(Lspd,1,-1);
    Robot.m_Chassis.SetSpeed(Lspd,Rspd);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.m_Chassis.SetSpeed(0,0);
  }

  @Override
  protected void interrupted(){
    end();
  }
}
