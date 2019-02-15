/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*
1: A
2: B
3: X
4: Y
5: Left BMper
6: Right Bmper
7: Back
8: Start
9: Left Joystick
10: Right Joystick


//Controller (1)
A: Pick up Ball
B: Shoot Ball
X: null <-- maybe force kill
Y: Stop Intake


*/


package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmDown;
import frc.robot.commands.ArmUp;
import frc.robot.commands.CalculateEncoder;
import frc.robot.commands.ArmStop;
import frc.robot.commands.ElevatorDown;
import frc.robot.commands.ElevatorStop;
import frc.robot.commands.ElevatorUp;
import frc.robot.commands.GrabIntake;
import frc.robot.commands.ShootIntake;
import frc.robot.commands.StopIntake;
import frc.robot.commands.WristandArmDown;
import frc.robot.commands.WristStop;
import frc.robot.commands.WristandArmUp;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.CalculateEncoderBase;;

public class OI {
  public Joystick driverControllerJoystick = Joystick(RobotMap.OI_DRIVER_CONTROLLER);

  public static final double JOYSTICK_DEADZONE = 0.05;

  public final Joystick Left_Joystick = new Joystick(RobotMap.XboxController_Drive);
  public final Joystick Right_Joystick = new Joystick(RobotMap.XboxController_Drive);



  //edit below by Ian to create a joystick to use for driving that has buttons that align with Xbox controller
  XboxController driverStick = new XboxController(0); //feel free to change port, this is just placeholder

  //intake
  JoystickButton js1_GrabIntake = new JoystickButton(driverStick, 1);
  JoystickButton js1_ShootIntake = new JoystickButton(driverStick, 2);
  JoystickButton js1_StopIntake = new JoystickButton(driverStick, 4);

  //elevator
  JoystickButton js1_ElevatorStop = new JoystickButton(driverStick, 3);
  JoystickButton js1_ElevatorUp = new JoystickButton(driverStick, 5);//these are reversed
  JoystickButton js1_ElevatorDown = new JoystickButton(driverStick, 6);

  //Arm
  JoystickButton js1_WristandArmUp = new JoystickButton(driverStick, 7);
  JoystickButton js1_WristandArmDown = new JoystickButton(driverStick, 8);

  //Wrist
 // JoystickButton js1_WristUp = new JoystickButton(driverStick, 7);
 // JoystickButton js1_WristDown = new JoystickButton(driverStick, 8);

  //print encoder value
  //JoystickButton js1_PrintEncoderVal = new JoystickButton(driverStick, 1);
  
    
    //Encoder cmds
    CalculateEncoder ce = new CalculateEncoder();

    //Arm cmd
    ArmDown ad = new ArmDown();
    ArmUp au = new ArmUp();
    ArmStop as = new ArmStop();

    //Wrist
    WristandArmUp wau = new WristandArmUp();
    WristandArmDown wad = new WristandArmDown();
    WristStop ws = new WristStop();



    //INTAKE cmd
    GrabIntake gi = new GrabIntake(); 
    StopIntake si = new StopIntake(); 
    ShootIntake shootI = new ShootIntake();  

    //elevator stop cmd
    ElevatorStop es = new ElevatorStop();
    //elevator up cmd
    ElevatorUp eu = new ElevatorUp();
    //elevator down cmd
    ElevatorDown ed = new ElevatorDown();



  
  public OI() {
     
    js1_GrabIntake.whileHeld(gi);
    js1_ShootIntake.whenPressed(shootI);
    js1_StopIntake.whenPressed(si);


    js1_ElevatorStop.whileHeld(es);
    js1_ElevatorUp.whileHeld(eu);
    js1_ElevatorDown.whenPressed(ed);


    js1_WristandArmUp.whileHeld(wau);
    js1_WristandArmUp.whenReleased(ws);

    js1_WristandArmDown.whileHeld(wad);
    js1_WristandArmDown.whenReleased(ws);


    //js1_ArmUp.whileHeld(au);
    //js1_ArmUp.whenReleased(as);

    //js1_ArmDown.whileHeld(ad);
    //js1_ArmDown.whenReleased(as);

    //print out encoder vals
    //js1_PrintEncoderVal.whenPressed(ce);



    

    }

    public double getYSpeedController_Drive() {

        return -driverStick.getRawAxis(RobotMap.XboxController_Drive);
    }

    
    public double getXSpeedController_Speed() {

        return -driverStick.getRawAxis(RobotMap.XboxController_Spin);
    }

    


    private Joystick Joystick(int oiDriverController) {
        return null;
    }

    public double getLeftJoystickXVal() {

        double raw = Left_Joystick.getX();
        return Math.abs(raw) < JOYSTICK_DEADZONE ? 0.0 : raw;
    }

    public double getLeftJoystickYVal() {

        double raw = Left_Joystick.getY();
        return Math.abs(raw) < JOYSTICK_DEADZONE ? 0.0 : raw;
    }

    
}
