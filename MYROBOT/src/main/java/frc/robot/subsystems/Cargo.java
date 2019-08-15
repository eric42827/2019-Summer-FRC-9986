package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Useful;
import frc.robot.commands.Cargo.BasicCargo;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;


public class Cargo extends Subsystem {
  private WPI_TalonSRX Motor_R = new WPI_TalonSRX(RobotMap.Intake_Motor_R);
  private WPI_TalonSRX Motor_L = new WPI_TalonSRX(RobotMap.Intake_Motor_L);
  private WPI_TalonSRX Motor_Pitch = new WPI_TalonSRX(RobotMap.Intake_Motor_Pitch);
  private Encoder Encoder_Pitch = new Encoder(RobotMap.Encoder_Pitch_DIOA,RobotMap.Encoder_Pitch_DIOB,RobotMap.Encoder_Pitch_Invert);

  private double Error = 0;
  private double SetPoint = 0;
  private double Intergral = 0;
  private double Derivative = 0;
  private double Pre_Error = 0;
  
  public Cargo(){
    Motor_R.setInverted(RobotMap.Intake_Motor_R_Invert);
    Motor_L.setInverted(RobotMap.Intake_Motor_L_Invert);
    Motor_Pitch.setInverted(RobotMap.Intake_Motor_Pitch_invert);
    Encoder_Pitch.reset();
  }

  public void SetIntakeSpeed(double Spd){
    Spd = Useful.Constrain(Spd, 1, -1);
    Motor_R.set(Spd*RobotMap.IntakePowerPercentage);
    Motor_L.set(Spd*RobotMap.IntakePowerPercentage);
  }

  public void SetIntakePitchSpeed(double Spd){
    Spd = Useful.Constrain(Spd, 1, -1);
    Motor_Pitch.set(Spd*RobotMap.IntakePitchPowerPercentage);
  }

  public void EncoderReset(){
    Encoder_Pitch.reset();
    Encoder_Pitch.getDistancePerPulse();
  }

  public double PID(double Value,double Kp,double Ki,double Kd){
    Error = SetPoint - Value;
    Intergral = Intergral + Error;
    Derivative = Error - Pre_Error;
    Pre_Error = Error;
    return Kp*Error + Ki*Intergral * Kd*Derivative;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new BasicCargo());
  }
}
