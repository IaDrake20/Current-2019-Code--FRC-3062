/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Arm1 extends Subsystem {

  Spark Arm1;
  public Arm1(Spark armSpark1){

     Arm1 = armSpark1;
     Arm1.enableDeadbandElimination(true);
  }

 public void Up() {

     Arm1.set(RobotMap.ArmUpSpeed); }

 public void Down() {

     Arm1.set(RobotMap.ArmDownSpeed); 
 }

 public void Stop() {

     Arm1.set(-0.001);
 }

 @Override
 protected void initDefaultCommand() {
 }

}
 