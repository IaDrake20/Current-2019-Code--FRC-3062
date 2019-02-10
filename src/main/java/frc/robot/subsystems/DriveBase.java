/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;
import frc.robot.utilities.Drive;
import frc.robot.commands.DriveCommand;;


public class DriveBase extends Subsystem {
  TalonSRX  leftFrontTalonSRX = null;
  TalonSRX  leftRearTalonSRX = null;
  TalonSRX  rightFrontTalonSRX = null;
  TalonSRX  rightRearTalonSRX = null;
  Drive drive;
  DifferentialDrive differentialDrive = null;

public DriveBase() {
  leftFrontTalonSRX = new TalonSRX(RobotMap.DRIVEBASE_LEFT_FRONT_TALON);
  leftRearTalonSRX = new TalonSRX(RobotMap.DRIVEBASE_LEFT_BACK_TALON);
 
  rightFrontTalonSRX = new TalonSRX(RobotMap.DRIVEBASE_RIGHT_FRONT_TALON);
  rightRearTalonSRX = new TalonSRX(RobotMap.DRIVEBASE_RIGHT_BACK_TALON);

 // tells the left side that is should be inverted so that we drive straight with each side having positive motor values.
 leftFrontTalonSRX.setInverted(true);
 leftRearTalonSRX.setInverted(true); 
 // DJD: the line above inverts the right back talon  

 //Set the back motors to follow the front motors.
rightRearTalonSRX.set(ControlMode.Follower, rightFrontTalonSRX.getDeviceID());
leftRearTalonSRX.set(ControlMode.Follower, leftFrontTalonSRX.getDeviceID());

//Config all talons
ConfigTalons(rightFrontTalonSRX);
ConfigTalons(rightFrontTalonSRX);
ConfigTalons(leftFrontTalonSRX);
ConfigTalons(leftFrontTalonSRX);

//(Ian)this drive uses the 4-motor setup from the Utility.Drive.java 
drive = new Drive(leftFrontTalonSRX, leftRearTalonSRX, rightFrontTalonSRX, rightRearTalonSRX);

}

public void driveArcade(double moveValue, double rotateValue)
{
  drive.driveArcade(moveValue, rotateValue);
}

public void setRaw(double varA, double varB) {

  
}

public void ConfigTalons(TalonSRX tSrx)
{
//Tells the talon that the max output that it can give is between 1 and -1 which would mean full forward and full backward.
//There is no allownace currently for anything in between
  tSrx.configPeakOutputForward(1,0);
  tSrx.configPeakOutputForward(-1,0);
  // DJD: I think one of the above should be configPeakOutputReverse()
  // tSrx.configPeakOutputReverse()

  //Tells the talon that it should current limit itself so that we don't blow a 40amp breaker.
  tSrx.configPeakCurrentLimit(40,0);
  tSrx.enableCurrentLimit(true);
  tSrx.configContinuousCurrentLimit(40,0);
  //The max output current is 40Amps for .25 of a second
  tSrx.configPeakCurrentDuration(250, 0);

  //Tells the talon that is should only appy 12 volts or less to the motor.
  tSrx.configVoltageCompSaturation(12,0);

}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }

 }
