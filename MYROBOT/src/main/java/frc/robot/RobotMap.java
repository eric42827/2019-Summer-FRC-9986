/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  ////Chassis Setting////
  public static int Motor_RB = 2;
  public static boolean Motor_RB_Invert = false;
  public static int Motor_LB = 1;
  public static boolean Motor_LB_Invert = false;
  //PowerPercentage//
  public static double PowerPercentage = 0.7;
  //PID//
  public static double Kp = 0.02;
  public static double Ki = 0.00;
  public static double Kd = 20000;
  public static double PID_Enable_Delay = 0.3;
  

  ////Controller Setting////
  public static int Joystick_Port = 0;
  public static double Joystick_ERR = 0.25;
  public static boolean Joystick_Y_Invert = true;
  public static boolean Joystick_X_Invert = true;
  public static boolean Joystick_Y_Linear = false;
  public static boolean Joystick_X_Linear = false;
  //Button
  public static int Down_Button = 1; //A-YELLOW
  public static int Right_Button = 2;//B-RED
  public static int Left_Button = 3;//X-BLUE
  public static int Up_Button = 4;//Y-YELLOW
  public static int LB_Button = 5;
  public static int RB_Button = 6;
  public static int Back_Button = 7;
  public static int Start_Button = 8;
  //Analog
  public static int LT_Analog = 2;
  public static int RT_Analog = 3;
  //Joystick
  public static int Joystick_LX = 0;
  public static int Joystick_LY = 1;
  public static int Joystick_RX = 4;
  public static int Joystick_RY = 5;
  public static int JL_Button = 9;
  public static int JR_Button = 10;

  ////Debug Setting////
  public static boolean GryoDebug = false;
}
