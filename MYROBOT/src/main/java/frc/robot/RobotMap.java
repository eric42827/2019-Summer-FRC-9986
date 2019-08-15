package frc.robot;

public class RobotMap {
  ////Chassis Setting////
  public final static byte Motor_RA = 1;
  public final static byte Motor_RB = 2;
  public final static byte Motor_LA = 3;
  public final static byte Motor_LB = 4;
  public final static boolean Motor_RA_Invert = false;
  public final static boolean Motor_RB_Invert = false;
  public final static boolean Motor_LA_Invert = false;
  public final static boolean Motor_LB_Invert = false;
  public final static double ChassisPowerPercentage = 0.5;
  public final static double PID_Enable_Delay = 0.35;
  public final static double Kp = 0.01;
  public final static double Ki = 0.00;
  public final static double Kd = 5000;
  
  
  ////Cargo Setting////
  public final static byte Intake_Motor_R = 11;
  public final static byte Intake_Motor_L = 12;
  public final static byte Intake_Motor_Pitch = 13;
  public final static boolean Intake_Motor_R_Invert = true;
  public final static boolean Intake_Motor_L_Invert = true;
  public final static boolean Intake_Motor_Pitch_invert = false;
  public final static double IntakePowerPercentage = 0.6;
  public final static double IntakePitchPowerPercentage = 0.35;
  public final static int Encoder_Pitch_DIOA = 9;
  public final static int Encoder_Pitch_DIOB = 8;
  public final static boolean Encoder_Pitch_Invert = false;

  ////Panel Setting////
  public final static byte Panel_Motor = 0;
  public final static boolean Panel_Motor_Invert = true;
  public final static double PanelPowerPercentage = 0.3;

  ////Controller Setting////
  public final static int Joystick_Port = 0;
  public final static double Joystick_ERR = 0.2;
  public final static boolean Joystick_Y_Invert = false;
  public final static boolean Joystick_X_Invert = true;
  public final static boolean Joystick_Y_Linear = false;
  public final static boolean Joystick_X_Linear = false;
  public final static double Joystick_Y_Ratio = 1;
  public final static double Joystick_X_Ratio = 0.75;
  public final static byte Button_Down = 1; //A-YELLOW
  public final static byte Button_Right = 2;//B-RED
  public final static byte Button_Left = 3;//X-BLUE
  public final static byte Button_Up = 4;//Y-YELLOW
  public final static byte Button_Left_Back = 5;
  public final static byte Button_Right_Back = 6;
  public final static byte Button_Back = 7;
  public final static byte Button_Start = 8;
  public final static byte Button_Joystick_L = 9;
  public final static byte Button_Joysticl_R = 10;
  public final static byte Axis_LT = 2;
  public final static byte Axis_RT = 3;
  public final static byte Joystick_LX = 0;
  public final static byte Joystick_LY = 1;
  public final static byte Joystick_RX = 4;
  public final static byte Joystick_RY = 5;
  
  ////Debug Setting////
  public static boolean GryoDebug = false;
}
