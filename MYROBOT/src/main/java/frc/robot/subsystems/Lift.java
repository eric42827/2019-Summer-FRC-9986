/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.commands.Lift.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  WPI_TalonSRX lift_1;
  WPI_TalonSRX lift_2;
  public SpeedControllerGroup lift;
  public WPI_TalonSRX climbForward;
  public DigitalInput limitSwitch;
  public DigitalInput limitSwitch_0;
  int _mode;
  public Lift(int mode){
    lift_1 = new WPI_TalonSRX(RobotMap.lift1_pin);
    lift_2 = new WPI_TalonSRX(RobotMap.lift2_pin);
    lift = new SpeedControllerGroup(lift_1,lift_2);
    climbForward = new WPI_TalonSRX(RobotMap.whatever);
    limitSwitch = new DigitalInput(RobotMap.limitPin);
    limitSwitch_0 = new DigitalInput(RobotMap.limitPin_0);
    _mode = mode;
  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    if(_mode==1){
      setDefaultCommand(new Ponpon());
    }
    else if(_mode==2){
      setDefaultCommand(new Test());      
    }

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
