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

     Spark _Arm;

     public Arm(Spark armSpark){
         
        _Arm = armSpark;
        _Arm.enableDeadbandElimination(true);
     }
    
  
    public void Up() {

        _Arm.set(RobotMap.ArmUpSpeed);
    }

    public void Down() {

        _Arm.set(RobotMap.ArmDownSpeed);
    }

    public void Stop() {

        _Arm.set(-0.001);
    }

    @Override
    protected void initDefaultCommand() {
    }



   
}
