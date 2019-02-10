/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem{

    Spark Arm_Motor_1 = new Spark (RobotMap.Spark1Arm);
    

    public void Up() {

        Arm_Motor_1.setSpeed(RobotMap.ArmSpeed);
    }

    public void Down() {

        Arm_Motor_1.setSpeed(-RobotMap.ArmSpeed);
    }

    public void Stop() {

        Arm_Motor_1.stopMotor();
    }

    @Override
    protected void initDefaultCommand() {
    }



   
}
