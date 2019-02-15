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

    Spark Wrist;

    public Wrist(Spark wristSpark){

    Wrist = wristSpark;
        Wrist.enableDeadbandElimination(true);
    }

    
    public void Up() {

        Wrist.set(-RobotMap.WristUpSpeed); //negative is forward, positive is backward
    }

    public void Down() {

        Wrist.set(RobotMap.WristDownSpeed);
    }

    public void Stop() {

        
        Wrist.set(-0.001);
    }

    @Override
    protected void initDefaultCommand() {
    }
  }
