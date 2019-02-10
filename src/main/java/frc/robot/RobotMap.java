/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;

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
    public static double intakeSpeed = -.35;

    //Sparks
    public static double distance = 0;
    public static int Spark1Roller = 4;
    public static int Spark2Roller = 5;
    public static int Spark3Roller = 10; //6
    public static int Spark4Roller = 7;

    //Wrist
    public static final int Spark1Wrist = 8;//open to change
    public static final int Spark2Wrist = 9;//open to change

    //Wrist Speed
    public static final double Wrist1Speed = 0.5;
    public static final double Wrist2Speed = 0.5;



    //Arm
    public static final int Spark1Arm = 6;//open to change //10

    //arm speed
    public static final double ArmSpeed = 0.4;

     

    public static final int XboxController_Drive = 0;
    public static final int XboxController_Spin = 1;
}

