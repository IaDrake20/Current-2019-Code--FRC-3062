/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class ArmDown extends Command {
  public ArmDown() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    System.out.println("Initialize Down:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::;;");

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.arm.Down();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.arm.Stop();
    System.out.println("End of Down:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::;;");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}