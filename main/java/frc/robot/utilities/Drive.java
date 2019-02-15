package frc.robot.utilities;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import com.ctre.phoenix.motorcontrol.ControlMode;


public final class Drive
{
	

	TalonSRX talon1, talon2, talon3, talon4, talon5, talon6;
	DriveMode driveMode;

	public static enum DriveMode
	{
		TWO, FOUR, SIX;
  }
  
  
  //This constructor is for 4 motors without follower

	public Drive(TalonSRX leftFront, TalonSRX leftBack, TalonSRX rightFront, TalonSRX rightBack)
	{
		driveMode = DriveMode.FOUR;
		talon1 = rightFront;
		talon2 = rightBack;
		talon3 = leftFront;
		talon4 = leftBack;
	}

	public void driveArcade(double moveValue, double rotateValue)
	{
		double leftMotorSpeed;
		double rightMotorSpeed;

		//grabs axis location to use as percentage
		//double axis = Robot.oi.getYSpeedController_Drive();

		moveValue = limitValue(moveValue);
		rotateValue = limitValue(rotateValue);
		leftMotorSpeed = 0;
		rightMotorSpeed = 0;
		
		//System.out.println("Move Value: "+moveValue + " | " + "Rotate Value: "+ rotateValue );

		//sets the area where nothing will happen
		double joystickDeadzone;
		joystickDeadzone = 0.05;


		if (moveValue >= joystickDeadzone)
		{
			
			//forwards (Quadrant 2)
			if (rotateValue >= joystickDeadzone)
			{
				leftMotorSpeed =   -0.6 * moveValue;			
				rightMotorSpeed =  -0.6 * moveValue;						
				//System.out.println("Case 1: rms=" + rightMotorSpeed + "|| lms=" + rightMotorSpeed);
				//System.out.println("Moving right:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");;
			}

			//turning right (Quadrant 1)
			else if (rotateValue <= -joystickDeadzone) 
			{
				leftMotorSpeed = 0.5 * moveValue;			
				rightMotorSpeed = -0.5 * moveValue;	
				//System.out.println("Case 2: rms=" + rightMotorSpeed + "|| lms=" + rightMotorSpeed);
				//System.out.println("Moving left:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

			}
		}

		else if (moveValue <= -joystickDeadzone)
		{
			// SHOULD turn right (Quadrant 3)
			if (rotateValue >= joystickDeadzone)
			{
				leftMotorSpeed =  -0.5 * rotateValue;		
				rightMotorSpeed = 0.5 * rotateValue; 
				//System.out.println("Case 3: rms=" + rightMotorSpeed + "|| lms=" + rightMotorSpeed);
				//System.out.println("Moving ????? :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

			}
			//SHOULD move backwards (Quadrant 4)
			else if(rotateValue <= -joystickDeadzone)
			{
				leftMotorSpeed = -0.5 *rotateValue; 
				rightMotorSpeed = -0.5 *rotateValue; 
				//System.out.println("Case 4: rms=" + rightMotorSpeed + "|| lms=" + rightMotorSpeed);
				//System.out.println("Moving ?2?@?@?@?@?@::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

			}
		}
		moveValue = limitValue(moveValue);
		rotateValue = limitValue(rotateValue);

		
		setMotorOutputs(rightMotorSpeed,leftMotorSpeed);
		
		

  }
 
  //This method will write the motor percent output to both the right and the left
  //this sets how much percentage of battery the motor is using
	public void setMotorOutputs(double left, double right)
	{
		
		if (driveMode == DriveMode.FOUR)
		{
			talon1.set(ControlMode.PercentOutput, right);
			talon2.set(ControlMode.PercentOutput, right);
			talon3.set(ControlMode.PercentOutput, left);
			talon4.set(ControlMode.PercentOutput, left);
		}
		
	}

  //This method is to limit the stick imputs to make sure that they dont go above or below 1 or -1
	private double limitValue(double value)
	{
		if (value > 1.0)
			value = 1.0;
		if (value < -1.0)
			value = -1.0;
		return value;
	}
}
