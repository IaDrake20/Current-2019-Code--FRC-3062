/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.commands.CalculateEncoder;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.CalculateEncoderBase;


public class Robot extends TimedRobot {
  public static OI oi;
  public static DriveBase drivebase = null; 
  public static UsbCamera camera1; 
  //Gyro created 
  public Gyro gyro;
  double kp = 0.03;

  //create elevator object
  public static final Elevator elevator = new Elevator();
  
  //create arm object
  public static final Arm arm = new Arm();

  //create wrist object
  public static final Wrist wrist = new Wrist();

  //create intake object
  public static Spark IntakeSpark = new Spark(RobotMap.Spark3Roller);
  public static final Intake intake = new Intake(IntakeSpark);

  //create ** object
  public static CalculateEncoderBase calculateEncoder = new CalculateEncoderBase();


  




  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
 
  
  @Override
  public void robotInit() {
    oi = new OI();
    drivebase = new DriveBase();
    SmartDashboard.putData("Auto mode", m_chooser);

    camera1 = CameraServer.getInstance().startAutomaticCapture(0); 
    camera1.setResolution(320, 240);

    //creating new gyro
    gyro = new AnalogGyro(1);//check that this is the right channel
    gyro.reset();
    System.out.println("Robot Initialized");//(gyro.getAngle());

    //set Encoder


    

   
    }

 
  @Override
  public void robotPeriodic() {
  }


  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }


  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected(); 
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }  
  }

  
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
      }

      
   }

 
   

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

      //Calculate the speed multiplier by the position of the throttle
  
      //However, the value returned by the getThrottle function ranges
  
      //from -1 to 1, and we need a range of 0 to 1, so we add 1 to
  
      //make the range 0 to 2
  
    /**      drive.arcadeDrive(controllerR.getY() * (multiplier + rightboost), controllerR.getX() * (multiplier + rightboost));
  */
    
  }


  @Override
  public void testPeriodic() {
  }
}
