/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
//import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.Robot;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.commands.Panel.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Panel extends Subsystem {
  public WPI_TalonSRX intake;
  private int _mode;
  public Panel(int mode){
    intake = new WPI_TalonSRX(RobotMap.motor);
    _mode = mode;
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    if(_mode==1){
      setDefaultCommand(new Intake());
    }

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
