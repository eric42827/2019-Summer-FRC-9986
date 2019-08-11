package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.Compressor;


public class panel{
  WPI_TalonSRX intake = new WPI_TalonSRX(RobotMap.motor);
  //Encoder m_encoder = new Encoder(RobotMap.encoder_a, RobotMap.encoder_b);
  //Solenoid m_solenoid = new Solenoid(RobotMap.solenoid);
  //Compressor m_compressor = new Compressor(RobotMap.compressor);
  OI o1 = new OI();
  
  public void execute(){
    arm();
  }

  protected void arm(){
    if(o1.Controller.getRawAxis(RobotMap.Joystick_LX) > 0.1){
      intake.set(0.3);
    }else if(o1.Controller.getRawAxis(RobotMap.Joystick_LX) < -0.1){
      intake.set(-0.3);
    }else{
      intake.set(0);
    }
  }
}