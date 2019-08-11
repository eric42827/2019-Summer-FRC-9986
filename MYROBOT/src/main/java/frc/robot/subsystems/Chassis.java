package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
//import frc.robot.commands.Chassis.JoystickDrive;
import frc.robot.commands.Chassis.PIDJoystickDrive;
import frc.robot.commands.Chassis.PIDori;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;

public class Chassis extends Subsystem {
  public WPI_TalonSRX RBM1 = new WPI_TalonSRX(RobotMap.Motor_RB1);
  public WPI_TalonSRX RBM2 = new WPI_TalonSRX(RobotMap.Motor_RB2);
  public WPI_TalonSRX LBM1 = new WPI_TalonSRX(RobotMap.Motor_LB1);
  public WPI_TalonSRX LBM2 = new WPI_TalonSRX(RobotMap.Motor_LB2);
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
  private int _mode;
  public Chassis(int mode){
    RBM1.setInverted(RobotMap.Motor_RB_Invert);
    LBM1.setInverted(RobotMap.Motor_LB_Invert);
    RBM2.setInverted(RobotMap.Motor_RB_Invert);
    LBM2.setInverted(RobotMap.Motor_LB_Invert);
    PID_Timer.reset();
    PID_Timer.start();
    _mode = mode;
  }

  public void SetSpeed(double Rspd,double Lspd){
    LBM1.set(Lspd*RobotMap.PowerPercentage);
    RBM1.set(Rspd*RobotMap.PowerPercentage);
    LBM2.set(Lspd*RobotMap.PowerPercentage);
    RBM2.set(Rspd*RobotMap.PowerPercentage);
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
      if(_mode==1){
        setDefaultCommand(new PIDJoystickDrive());
      }
      if(_mode==2){
        setDefaultCommand(new PIDori());
      }
    

  }
}