package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
//import frc.robot.commands.Chassis.JoystickDrive;
import frc.robot.commands.Chassis.PIDJoystickDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;



public class Chassis extends Subsystem {
  public VictorSP RBM = new VictorSP(RobotMap.Motor_RB);
  public VictorSP LBM = new VictorSP(RobotMap.Motor_LB);
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
    RBM.setInverted(RobotMap.Motor_RB_Invert);
    LBM.setInverted(RobotMap.Motor_LB_Invert);
    PID_Timer.reset();
    PID_Timer.start();
  }

  public void SetSpeed(double Rspd,double Lspd){
    LBM.set(Lspd*RobotMap.PowerPercentage);
    RBM.set(Rspd*RobotMap.PowerPercentage);
  }

  public void InitGryo(){
    gyro.calibrate();
    gyro.reset();
  }

  public void SetInitAngle(double Value){
    InitAngle = Value;
  }

  public double ReadAngle(){
    return gyro.getAngle() % 360;
  }

  public double ReadNowAngle(double Value){
    return ((((Value + (360 - InitAngle)) % 360) + 180) % 360) - 180;
  }

  public void DisablePID(){
    PID_Previous_Time = PID_Timer.get();
    Enable_PID = false;
    System.out.println(Enable_PID + " " + PID_Timer.get());
  }

  public void EnablePID(){
    System.out.println(Enable_PID + " " + PID_Timer.get());
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