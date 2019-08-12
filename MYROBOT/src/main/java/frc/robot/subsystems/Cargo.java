/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.VictorSP;
//import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.OI;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.commands.Cargo.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Cargo extends Subsystem {
  OI o1 = new OI();
  public Joystick Controller;
  boolean Shooting;
  boolean Hold;
  boolean CAngleU;
  boolean CAngleD;
  int _mode;
  //Encoder CLE = Robot.m_Cargo.CLE;
  public VictorSP CRM = new VictorSP(RobotMap.Motor_cargor);
  public VictorSP CLM = new VictorSP(RobotMap.Motor_cargol);
  public VictorSP CLift = new VictorSP(RobotMap.Motor_cargolift);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Cargo(int mode){
    _mode = mode;
  }
  @Override
  public void initDefaultCommand() {
    if(_mode==1){
      setDefaultCommand(new Claw());
    }
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
