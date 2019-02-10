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
public class Intake extends Subsystem {

    Spark _Wheel;

    public Intake( Spark wheel){
		
	  
		//Wheel = new Spark(RobotMap.p_Spark1Roller);
		_Wheel = wheel;
		_Wheel.enableDeadbandElimination(true);	
	}
	
	
	public void grabIntake() {
		
		//stopIntake();
		_Wheel.set(RobotMap.intakeSpeed);
	

	}
	
	public void shootIntake() {
		
		//stopIntake();
		_Wheel.set(RobotMap.shootSpeed);//-.35);
	 
	}
	
	public void stopIntake() {
		
		_Wheel.stopMotor();
        //_Wheel.set(0);
        
	
		
    }

    @Override
    protected void initDefaultCommand() {
    }
}
