package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Useful;
import frc.robot.commands.Cargo.BasicCargo;

public class Cargo extends Subsystem {
  public VictorSP Motor_R = new VictorSP(RobotMap.Intake_Motor_R);
  public VictorSP Motor_L = new VictorSP(RobotMap.Intake_Motor_L);
  public VictorSP Motor_Pitch = new VictorSP(RobotMap.Intake_Motor_Pitch);
  public Cargo(){
    Motor_R.setInverted(true);
    Motor_L.setInverted(true);
    Motor_Pitch.setInverted(true);
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

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new BasicCargo());
  }
}
