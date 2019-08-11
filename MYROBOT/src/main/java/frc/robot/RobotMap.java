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
  public static int Motor_RB1 = 3;//Talon
  public static int Motor_RB2 = 4;//Talon
  public static int Motor_LB1 = 1;//Talon
  public static int Motor_LB2 = 2;//Talon
  public static boolean Motor_RB_Invert = false;

  public static boolean Motor_LB_Invert = false;

  //PowerPercentage//
  public static double PowerPercentage = 0.4;
  public static double cargoShootingPP = 0.5;
  public static double cargoLiftPP = 0.35;

  //PID//
  public static double Kp = 0.1;
  public static double Ki = 0.00;
  public static double Kd = 50000;
  public static double PID_Enable_Delay = 0.5;

  ////Cargo Setting///
  public static int Motor_cargol = 1;//Victor
  public static boolean Motor_cargol_Invert = false;
  public static int Motor_cargor = 2;//Victor
  public static boolean Motor_cargor_Invert = false;
  public static int Motor_cargolift = 3;//Victor
  public static boolean Motor_cargoangle_Invert = false;
  public static double liftspeed = 0.5;
  public static double CRspeed = 0.7;
  public static double CLspeed = 0.7;
  ////Encoder Setting///
  public static int CargoLiftEncoderSA = 0;
  public static int CargoLiftEncoderSB = 1;

  //lift
  public static int lift1_pin = 11;//Talon
  public static int lift2_pin = 12;//Talon
  public static int whatever = 13;//Talon
  public static int limitPin = 1;
  public static int limitPin_0 = 0;
  public static int datStick = 0;
  public static double liftSpeed= 0.5;
  public static double climbSpeed= 0.5;
  
  ////Controller Setting////
  public static int Joystick_Port = 0;
  public static double Joystick_ERR = 0.3;
  public static boolean Joystick_Y_Invert = true;
  public static boolean Joystick_X_Invert = true;

  //Button
  public static int Down_Button = 1; //A-GREEN
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

  //panel
  public static int stick = 0;
  public static int motor = 1;//Victor(ignore)
  public static int encoder_a = 3;
  public static int encoder_b = 4;
  public static int solenoid = 2;
  public static int compressor = 5;
}
