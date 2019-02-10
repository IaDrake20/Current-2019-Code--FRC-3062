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
public class Wrist extends Subsystem{

    Spark Wrist_Motor_1 = new Spark(RobotMap.Spark1Wrist);

    
    public void Up() {

        Wrist_Motor_1.setSpeed(RobotMap.ArmSpeed);
    }

    public void Down() {

        Wrist_Motor_1.setSpeed(-RobotMap.ArmSpeed);
    }

    public void Stop() {

        Wrist_Motor_1.stopMotor();
    }

    @Override
    protected void initDefaultCommand() {
    }
  }
