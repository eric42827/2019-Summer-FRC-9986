package frc.robot.commands.Chassis;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.Useful;

public class PIDJoystickDrive extends Command {
  //byte LT_Status = 0;
  //byte RT_Status = 0;
  
  public PIDJoystickDrive() {
    requires(Robot.m_Chassis);
  }

  @Override
  protected void initialize() {
    Robot.m_Chassis.InitGryo();
  }

  @Override
  protected void execute() {
    double Rspd = 0.0;
    double Lspd = 0.0;
    /*
    double LT = Robot.m_oi.Controller.getRawAxis(RobotMap.Joystick_LT);
    double RT = Robot.m_oi.Controller.getRawAxis(RobotMap.Joystick_RT);

    if(LT_Status == 0){
      if(LT > 0.7){
        Robot.m_Chassis.MinusInitAngle();
        LT_Status = 1;
      }
    }else if(LT_Status == 1){
      if(LT < 0.7){
        LT_Status = 2;
      }
    }else if(LT_Status == 2){
      LT_Status = 0;
    }

    if(RT_Status == 0){
      if(RT > 0.7){
        Robot.m_Chassis.AddInitAngle();
        RT_Status = 1; 
      }
    }else if(RT_Status == 1){
      if(RT < 0.7){
        RT_Status = 2;
      }
    }else if(RT_Status == 2){
      RT_Status = 0;
    }
    */
    double Joystick_Y = Robot.m_oi.Controller.getRawAxis(RobotMap.Joystick_LY) * Useful.Boolean_To_Int(RobotMap.Joystick_Y_Invert);
    double Joystick_X = Robot.m_oi.Controller.getRawAxis(RobotMap.Joystick_RX) * Useful.Boolean_To_Int(RobotMap.Joystick_X_Invert);
    
    //System.out.println("Y:"+Joystick_Y+"  X"+Joystick_X);

    if(!RobotMap.Joystick_Y_Linear){
      if(Joystick_Y > 0 && Joystick_Y < 1){
        Joystick_Y = Math.pow(Math.abs(Joystick_Y),2.15);
      }else if(Joystick_Y  < 0 && Joystick_Y > -1){
        Joystick_Y = -Math.pow(Math.abs(Joystick_Y),2.15);
      }
    }
    if(!RobotMap.Joystick_X_Linear){
      if(Joystick_X > 0 && Joystick_Y < 1){
        Joystick_X = Math.pow(Math.abs(Joystick_X),2.15);
      }else if(Joystick_X  < 0 && Joystick_X > -1){
        Joystick_X = -Math.pow(Math.abs(Joystick_X),2.15);
      }
    }
    

    if(Math.abs(Joystick_Y) < RobotMap.Joystick_ERR){
      Joystick_Y = 0;
    }
    if(Math.abs(Joystick_X) < RobotMap.Joystick_ERR){
      Robot.m_Chassis.EnablePID();
      Joystick_X = 0;
      double gryo = Robot.m_Chassis.ReadNowAngle(Robot.m_Chassis.ReadAngle());
      double pid = Robot.m_Chassis.PID(gryo, RobotMap.Kp, RobotMap.Ki, RobotMap.Kd);
      Rspd = Joystick_Y - pid;
      Lspd = Joystick_Y + pid;
    }else{
      Rspd = Joystick_Y - Joystick_X;
      Lspd = Joystick_Y + Joystick_X;
      Robot.m_Chassis.DisablePID();
      Robot.m_Chassis.SetInitPIDVariable();
    }
    Rspd = Useful.Constrain(Rspd,1,-1);
    Lspd = Useful.Constrain(Lspd,1,-1);
    Robot.m_Chassis.SetSpeed(Lspd,-Rspd);
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
  protected void interrupted() {
    this.end();
  }
}
