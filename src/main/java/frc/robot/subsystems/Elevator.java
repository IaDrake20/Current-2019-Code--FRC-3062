/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {


  //Limit switches
  DigitalInput botLim;
  DigitalInput topLim;

  //Motor for elevator going up
  Spark lift;
  
  //encoders
  //Encoder elevatorE = new Encoder(0, 1,false, Encoder.EncodingType.k4X);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    /*
    System.out.println("We have succeeded in printing sjknfisnfiniusnfiusnfvshfnuifsni");
    elevatorE.setMaxPeriod(1);
    elevatorE.setMinRate(10);
    elevatorE.setDistancePerPulse(5);
    elevatorE.setReverseDirection(true);
    elevatorE.setSamplesToAverage(7);
    */
  }

    //here is where we can set the speeds
  public void liftUp() {
		
		lift.set(-0.5);
			
  }
  
  public void liftStop() {
		
		lift.set(-0.001);
		
	}
	
	public void liftDown() {
		
		lift.set(.5);
	
  }
  
  public boolean getTopLimit() {
		
		return topLim.get();
		
  }
  
  public boolean getBotLimit() {
		
		return botLim.get();
		
	}
}

