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
public class Wrist1 extends Subsystem {

  Spark Wrist1;

    public Wrist1(Spark wristSpark1){

    Wrist1 = wristSpark1;
        Wrist1.enableDeadbandElimination(true);
    }

    
    public void Up() {

        Wrist1.set(RobotMap.WristUpSpeed);//negative is up, positive is down 
    }

    public void Down() {

        Wrist1.set(RobotMap.WristDownSpeed);
    }

    public void Stop() {

        //Wrist.stopMotor();
        Wrist1.set(-0.001);
    }

    @Override
    protected void initDefaultCommand() {
    }
  }

