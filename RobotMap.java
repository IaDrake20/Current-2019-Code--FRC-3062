/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;

public class RobotMap {
   public static final int DRIVEBASE_LEFT_FRONT_TALON = 1;
   public static final int DRIVEBASE_LEFT_BACK_TALON = 3;
   public static final int DRIVEBASE_RIGHT_FRONT_TALON = 2;
   public static final int DRIVEBASE_RIGHT_BACK_TALON = 0;

   //Encoder Digital Inputs
   DigitalInput encoder1 = new DigitalInput(0);
   

   // Joystick
    public static final int OI_DRIVER_CONTROLLER = 0;
    public static final int DRIVER_CONTROLLER_MOVE_AXIS = 1;
    public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 2;
    
    //Intake
    public static double shootSpeed = .8;
    public static double intakeSpeed = -.3;

    //Sparks
    public static double distance = 0;
    public static int SparkArm1 = 1; //arm1
    public static int SparkArm2 = 0; //arm2
    public static int SparkIntake = 4; //intake
    public static int SparkElevator = 5; //elevator
    public static int SparkWrist1 = 2;           //2;//wrist1
    public static int SparkWrist2 = 3;//wrist2

	public static AnalogInput elevatorPot;

    //Wrist

    //Wrist Speeds
    public static double WristUpSpeed = 0.29;
    public static double WristDownSpeed = 0.1;

    //Elevator


    //Arm

    //arm speed
    public static double ArmUpSpeed = 0.25;
    public static double ArmDownSpeed = 0.25; 

    public static final int XboxController_Drive = 0;
    public static final int XboxController_Spin = 1;
	public static final Spark elevatorMotor = null;
}

