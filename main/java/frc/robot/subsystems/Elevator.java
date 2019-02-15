/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorStop;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;

/**
 * Add your docs here.
 */
public class Elevator extends PIDSubsystem {


  //Limit switches;
  DigitalInput topLim = new DigitalInput(1);
  

  Spark elevatoSparkl;

  Spark sparkMotor = RobotMap.elevatorMotor;
  AnalogInput pot = RobotMap.elevatorPot;

  //Motor for elevator going up
  Spark lift;


  
  //encoders
  //Encoder elevatorE = new Encoder(0, 1,false, Encoder.EncodingType.k4X);

  public Elevator(Spark elevatorSpark) {
    super("Elevator", 2.0, 0.0, 0.0); 
    lift = elevatorSpark;
    lift.enableDeadbandElimination(true);	
    getPIDController().setContinuous(false);

}

@Override
  public void initDefaultCommand() {
    
  }

    //here is where we can set the speeds
  public void liftUp() {

    if (!getTopLimit()) {
        lift.set(0.3);//negative values go upwards, this is getting inverted for some reason, so its positive

         System.out.println("Limit switch not active::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");


    }
    
    else {
      lift.stopMotor();
      System.out.println("Limit switch now true:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");


    }    
			
  }
  
  public void liftStop() {
		
		lift.set(-0.001);
		
	}
	
	public void liftDown() {
		
		lift.set(-.3);//positive goes downwards,but for some reason this is inverted by default twice, so its positive
	
  }
  
  public boolean getTopLimit() {

    return topLim.get();
		
  }

  public void switchAlive() {

    System.out.println(getTopLimit());
  }
  
  
  @Override
  protected double returnPIDInput() {
    return pot.getAverageVoltage();  
  }



  @Override
  protected void usePIDOutput(double output) {
    sparkMotor.pidWrite(output);
  }

 
}

