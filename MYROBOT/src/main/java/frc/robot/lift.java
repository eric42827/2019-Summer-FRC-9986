package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;

public class lift{
    OI o1 = new OI();
    WPI_TalonSRX lift_1;
    WPI_TalonSRX lift_2;
    SpeedControllerGroup lift;
    WPI_TalonSRX climbForward;
    DigitalInput limitSwitch;
    DigitalInput limitSwitch_0;
    lift(){
        lift_1 = new WPI_TalonSRX(RobotMap.lift1_pin);
        lift_2 = new WPI_TalonSRX(RobotMap.lift2_pin);
        lift = new SpeedControllerGroup(lift_1,lift_2);
        climbForward = new WPI_TalonSRX(RobotMap.whatever);
        limitSwitch = new DigitalInput(RobotMap.limitPin);
        limitSwitch_0 = new DigitalInput(RobotMap.limitPin_0);
    }
    public void execute(){
        liftOn();
    }

    protected void liftOn() {
        if (o1.Controller.getRawButton(RobotMap.Left_Button)){
            while(limitSwitch_0.get()){
                lift.set(RobotMap.liftSpeed);
            }
            while (limitSwitch.get()){
                climbForward.set(RobotMap.climbSpeed);
            }
        }
    }
}