/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
//import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.OI;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import frc.robot.Useful;

public class shootingclas {
  
  
    //double CRspd = 0.0;
    //double CLspd = 0.0;
    //double CLiftspd = 0.0;
    OI o1 = new OI();
    public Joystick Controller;
    boolean Shooting;
    boolean Hold;
    boolean CAngleU;
    boolean CAngleD;
    //Encoder CLE = Robot.m_Cargo.CLE;
    public VictorSP CRM = new VictorSP(RobotMap.Motor_cargor);
    public VictorSP CLM = new VictorSP(RobotMap.Motor_cargol);
    public WPI_TalonSRX CLift = new WPI_TalonSRX(RobotMap.Motor_cargolift);
    //public Encoder  CLE = new Encoder(RobotMap.CargoLiftEncoderSA, RobotMap.CargoLiftEncoderSB);

    public void execute(){
      //initial();
      shooting();
      move();
    }
    protected void shooting(){
      if (o1.Controller.getRawButton(RobotMap.Right_Button)){
        SetSpeed(RobotMap.CRspeed,RobotMap.CLspeed);
      }
      else {
        SetSpeed(0,0);
      }
    }
    protected void move(){
      
      System.out.println(o1.Controller.getRawButton(RobotMap.Up_Button));
      //SetLiftSpeed(RobotMap.liftspeed);
      if(o1.Controller.getRawButton(RobotMap.Up_Button)){
        //System.out.println("fuk");
        SetLiftSpeed(RobotMap.liftspeed);

      }else if(o1.Controller.getRawButton(RobotMap.Down_Button)){
        //System.out.println("fuck");
        SetLiftSpeed(-RobotMap.liftspeed);
      }else{
        SetLiftSpeed(0);
      }
    }
    /*if (CAngleU){
      if(PressUP==true){
        while(CLE.get()<512){
          Robot.m_Cargo.SetLiftSpeed(1);
        }
        Robot.m_Cargo.SetLiftSpeed(0);
        CLE.reset();
        PressUP = false;
      }
    }
    else if(CAngleD){
      if(PressUP ==false){
        while(CLE.get()<-512){
          Robot.m_Cargo.SetLiftSpeed(-1);
        }
        Robot.m_Cargo.SetLiftSpeed(0);
        CLE.reset();
        PressUP = true;
      }
    }*/
  

    //public Timer Timer = new Timer();


  protected void initial() {
    CRM.setInverted(RobotMap.Motor_RB_Invert);
    CLM.setInverted(RobotMap.Motor_LB_Invert);
    //Timer.reset();
    //Timer.start();
  }

  protected void SetSpeed(double CRspd,double CLspd){
    CLM.set(CLspd*RobotMap.cargoShootingPP);
    CRM.set(CRspd*RobotMap.cargoShootingPP);
    }

  protected void SetLiftSpeed(double CLiftspd){
    CLift.set(CLiftspd*RobotMap.cargoLiftPP);
  }

  //public void InitEncoder(){
    //CLE.reset();
  //}


  // Make this return true when this Command no longer needs to run execute()

  
  // Called once after isFinished returns true

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run

}

