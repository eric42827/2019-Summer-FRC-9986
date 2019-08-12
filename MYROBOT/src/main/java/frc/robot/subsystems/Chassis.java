package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
//import frc.robot.commands.Chassis.JoystickDrive;
import frc.robot.commands.Chassis.PIDJoystickDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;

public class Chassis extends Subsystem {
  public WPI_TalonSRX Motor_RA = new WPI_TalonSRX(RobotMap.Motor_RA);
  public WPI_TalonSRX Motor_RB = new WPI_TalonSRX(RobotMap.Motor_RB);
  public WPI_TalonSRX Motor_LA = new WPI_TalonSRX(RobotMap.Motor_LA);
  public WPI_TalonSRX Motor_LB = new WPI_TalonSRX(RobotMap.Motor_LB);
  public Timer PID_Timer = new Timer();
  public ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

  private double Error = 0;
  private double SetPoint = 0;
  private double Intergral = 0;
  private double Derivative = 0;
  private double Pre_Error = 0;
  private double InitAngle = 0;
  private boolean Enable_PID = true;
  private double PID_Previous_Time = 0;

  public Chassis(){
    Motor_RA.setInverted(RobotMap.Motor_RA_Invert);
    Motor_RB.setInverted(RobotMap.Motor_RB_Invert);
    Motor_LA.setInverted(RobotMap.Motor_LA_Invert);
    Motor_LB.setInverted(RobotMap.Motor_LB_Invert);
    Motor_RB.follow(Motor_RA);
    Motor_LB.follow(Motor_LA);
    PID_Timer.reset();
    PID_Timer.start();
  }

  public void SetSpeed(double Rspd,double Lspd){
    Motor_RA.set(Rspd*RobotMap.ChassisPowerPercentage);
    //Motor_RB.set(Rspd*RobotMap.ChassisPowerPercentage);
    Motor_LA.set(Lspd*RobotMap.ChassisPowerPercentage);
    //Motor_LB.set(Rspd*RobotMap.ChassisPowerPercentage);
  }

  public void InitGryo(){
    gyro.calibrate();
    gyro.reset();
  }

  public void SetInitAngle(double Value){
    InitAngle = Value;
  }
  /*
  public void AddInitAngle(){
    InitAngle = (InitAngle + 90)%360;
  }

  public void MinusInitAngle(){
    InitAngle = (InitAngle - 90)%360;
  }
  */
  
  public double ReadAngle(){
    return gyro.getAngle() % 360;
  }
  
  public double ReadNowAngle(double Value){
    return ((((Value + (360 - InitAngle)) % 360) + 180) % 360) - 180;
  }

  public void DisablePID(){
    PID_Previous_Time = PID_Timer.get();
    Enable_PID = false;
  }

  public void EnablePID(){
    if(Enable_PID == false && PID_Timer.get() > PID_Previous_Time + RobotMap.PID_Enable_Delay){
      Enable_PID = true;
      SetInitAngle(ReadAngle());
    }
  }

  public double PID(double Value,double Kp,double Ki,double Kd){
    if(Enable_PID){
      Error = SetPoint - Value;
      Intergral = Intergral + Error;
      Derivative = Error - Pre_Error;
      Pre_Error = Error;
      return Kp*Error + Ki*Intergral * Kd*Derivative;
    }else{
      return 0;
    }
  }

  public void SetInitPIDVariable(){
    Error = 0;
    Pre_Error = 0;
    Intergral = 0;
    Derivative = 0;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new PIDJoystickDrive());
  }
}
