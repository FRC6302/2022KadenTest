// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Constants;


public class Drive extends CommandBase {
  

  

  /** Creates a new Drive. */


  public Drive() {
    addRequirements(RobotContainer.driveTrain);  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double LeftStickY = Robot.m_robotContainer.GetDriverRawAxis(Constants.LEFT_STICK_Y);
    double RightStickY = Robot.m_robotContainer.GetDriverRawAxis(Constants.RIGHT_STICK_Y);
    RobotContainer.driveTrain.SetLeftMotors(LeftStickY);
    RobotContainer.driveTrain.SetRightMotors(RightStickY);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveTrain.SetLeftMotors(0);
    RobotContainer.driveTrain.SetRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
