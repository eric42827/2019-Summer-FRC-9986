package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Panel;
import frc.robot.subsystems.Cargo;

//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  //Subsystem Declaration//
  public static Chassis m_Chassis = new Chassis();
  public static Cargo m_Cargo = new Cargo();
  public static Panel m_Panel = new Panel();
  public static OI m_oi = new OI();
  //Sensor Declaration//

  
  
  //Command m_autonomousCommand;
  //SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    Robot.m_Chassis.InitGryo();
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
    Scheduler.getInstance().run();
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
