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
  public final static double PID_Enable_Delay = 0.25;
  public final static double Kp = 0.02;
  public final static double Ki = 0.00;
  public final static double Kd = 20000;
  
  
  ////Cargo Setting////
  public final static byte Intake_Motor_R = 9;
  public final static byte Intake_Motor_L = 7;
  public final static byte Intake_Motor_Pitch = 5;
  public final static boolean Intake_Motor_R_Invert = false;
  public final static boolean Intake_Motor_L_Invert = true;
  public final static boolean Intake_Motor_Pitch_invert = false;
  public final static double IntakePowerPercentage = 1;
  public final static double IntakePitchPowerPercentage = 0.35;
  ////Controller Setting////
  public final static int Joystick_Port = 0;
  public final static double Joystick_ERR = 0.2;
  public final static boolean Joystick_Y_Invert = false;
  public final static boolean Joystick_X_Invert = true;
  public final static boolean Joystick_Y_Linear = false;
  public final static boolean Joystick_X_Linear = false;
  public final static byte Down_Button = 1; //A-YELLOW
  public final static byte Right_Button = 2;//B-RED
  public final static byte Left_Button = 3;//X-BLUE
  public final static byte Up_Button = 4;//Y-YELLOW
  public final static byte LB_Button = 5;
  public final static byte RB_Button = 6;
  public final static byte Back_Button = 7;
  public final static byte Start_Button = 8;
  public final static byte Joystick_LT = 2;
  public final static byte Joystick_RT = 3;
  public final static byte Joystick_LX = 0;
  public final static byte Joystick_LY = 1;
  public final static byte Joystick_RX = 4;
  public final static byte Joystick_RY = 5;
  public final static byte JL_Button = 9;
  public final static byte JR_Button = 10;

  ////Debug Setting////
  public static boolean GryoDebug = false;
}
