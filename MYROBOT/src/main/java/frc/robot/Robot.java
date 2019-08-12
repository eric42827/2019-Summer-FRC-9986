package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.OI;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Panel;
import frc.robot.subsystems.Cargo;
//import frc.robot.shootingclas;
//import frc.robot.lift;


//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  //Subsystem Declaration//
  Camera m_cam = new Camera();
  public static Chassis m_Chassis = new Chassis(2);
  /*
    2:PIDori
    LY for forward/back
    RX for left/right
  */
  public static Lift m_Lift = new Lift(0);
  /*
    2:test mode
    RY for lift
    RB climb forward
    LB climb back
  */
  public static Cargo m_Cargo = new Cargo(1); 
  /*
    AB for in/out
    XY for up/down
  */
  public static Panel m_Panel = new Panel(1);
  /*
    LX for swin panel
  */
  public static OI m_oi = new OI();
  //Command m_autonomousCommand;
  //SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    Robot.m_Chassis.InitGryo();
    m_cam.cameraInit();
  }
  @Override
  public void robotPeriodic() {
    
  }

  
  //About Disable Function
  @Override
  public void disabledInit() {

  }
  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }


  //About Autonoumous Function
  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_chooser.getSelected();
    //if (m_autonomousCommand != null) {
      //m_autonomousCommand.start();
    //}
  }
  @Override
  public void autonomousPeriodic() {
    //Scheduler.getInstance().run();
  }

  //About Teleop Function
  @Override
  public void teleopInit() {
    //if (m_autonomousCommand != null) {
    //  m_autonomousCommand.cancel();
    //}
  }
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }


  //About Test Function
  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }
}
