package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
  //public JoystickController Controller = new JoystickController(RobotMap.Joystick_Port);
  private XboxController Controller = new XboxController(RobotMap.Joystick_Port);

  //private JoystickButton Button_Up = new JoystickButton(Controller, RobotMap.Button_Up);
  //private JoystickButton Button_Down = new JoystickButton(Controller, RobotMap.Button_Down);
  //private JoystickButton Button_Right = new JoystickButton(Controller, RobotMap.Button_Right);
  //private JoystickButton Button_Left = new JoystickButton(Controller, RobotMap.Button_Left);
  //private JoystickButton Button_Back_L = new JoystickButton(Controller, RobotMap.Button_Left_Back);
  //private JoystickButton Button_Back_R = new JoystickButton(Controller, RobotMap.Button_Right_Back);
  //private JoystickButton Button_Back = new JoystickButton(Controller, RobotMap.Button_Back);
  //private JoystickButton Button_Start = new JoystickButton(Controller, RobotMap.Button_Start);
  //private JoystickButton Button_Joystick_L = new JoystickButton(Controller, RobotMap.Button_Joystick_L);
  //private JoystickButton Button_Joystick_R = new JoystickButton(Controller, RobotMap.Button_Joysticl_R);

  public boolean GetButton(int ButtonID){
    return Controller.getRawButton(ButtonID);
  }

  public double GetAxis(int AxisID){
    return Controller.getRawAxis(AxisID);
  }

  public int GetPov(){
    return Controller.getPOV();
  }

  public void SetRumble(double L_Intensity,double R_Intensity){
    L_Intensity = Useful.Constrain(L_Intensity, 1, 0);
    R_Intensity = Useful.Constrain(R_Intensity, 1, 0);
    Controller.setRumble(RumbleType.kLeftRumble, L_Intensity);
    Controller.setRumble(RumbleType.kRightRumble, R_Intensity);
  }
  public void SetRumble(double Intensity){
    Intensity = Useful.Constrain(Intensity, 1, 0);
    Controller.setRumble(RumbleType.kLeftRumble, Intensity);
    Controller.setRumble(RumbleType.kRightRumble, Intensity);
  }

  public OI(){
  // button.whileHeld(new ExampleCommand());
  // button.whenReleased(new ExampleCommand());
  }
}
