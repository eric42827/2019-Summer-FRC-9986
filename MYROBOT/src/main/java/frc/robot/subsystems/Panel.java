package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Useful;
import frc.robot.commands.Panel.BasicPanel;

public class Panel extends Subsystem {
  private VictorSP Motor_Arm = new VictorSP(RobotMap.Panel_Motor);

  public Panel(){
    Motor_Arm.setInverted(RobotMap.Panel_Motor_Invert);
  }

  public void SetSpeed(double Spd){
    Spd = Useful.Constrain(Spd, 1, -1);
    Motor_Arm.set(Spd*RobotMap.PanelPowerPercentage);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new BasicPanel());
  }
}
