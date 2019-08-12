/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Cargo;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class Claw extends Command {
  public Claw() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_Cargo);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    shooting();
    move();
  }
  protected void shooting(){
    if (Robot.m_oi.Controller.getRawButton(RobotMap.Right_Button)){
      SetSpeed(RobotMap.CRspeed,RobotMap.CLspeed);
    }
    else if(Robot.m_oi.Controller.getRawButton(RobotMap.Down_Button)){
      SetSpeed(-RobotMap.CRspeed,-RobotMap.CLspeed);
    }
    else {
      SetSpeed(0,0);
    }
  }
  protected void move(){
    
    System.out.println(Robot.m_oi.Controller.getRawButton(RobotMap.Up_Button));
    //SetLiftSpeed(RobotMap.liftspeed);
    if(Robot.m_oi.Controller.getRawButton(RobotMap.Up_Button)){
      //System.out.println("fuk");
      SetLiftSpeed(RobotMap.liftspeed);

    }else if(Robot.m_oi.Controller.getRawButton(RobotMap.Left_Button)){
      //System.out.println("fuck");
      SetLiftSpeed(-RobotMap.liftspeed);
    }else{
      SetLiftSpeed(0);
    }
  }

protected void initial() {
  Robot.m_Cargo.CRM.setInverted(RobotMap.Motor_RB_Invert);
  Robot.m_Cargo.CLM.setInverted(RobotMap.Motor_LB_Invert);
}

protected void SetSpeed(double CRspd,double CLspd){
  Robot.m_Cargo.CLM.set(CLspd*RobotMap.cargoShootingPP);
  Robot.m_Cargo.CRM.set(CRspd*RobotMap.cargoShootingPP);
  }

protected void SetLiftSpeed(double CLiftspd){
  Robot.m_Cargo.CLift.set(CLiftspd*RobotMap.cargoLiftPP);
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
