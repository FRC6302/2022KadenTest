// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Constants;


public class Mecanum extends CommandBase {
  

  

  /** Creates a new Drive. */


  public Mecanum() {
    addRequirements(RobotContainer.driveTrain);  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double leftStickY = Robot.m_robotContainer.GetDriverRawAxis(Constants.leftStickY);
    double leftStickX = Robot.m_robotContainer.GetDriverRawAxis(Constants.leftStickX);
    double rightStickX = Robot.m_robotContainer.GetDriverRawAxis(Constants.rightStickX);


    double leftFrontMotor = leftStickY + leftStickX + rightStickX;
    
    double rightFrontMotor = leftStickY - leftStickX + rightStickX;

    double leftBackMotor = leftStickY - leftStickX - rightStickX;

    double rightBackMotor = leftStickY + leftStickX - rightStickX;

    RobotContainer.driveTrain.SetFrontLeftMotor(leftFrontMotor);
    RobotContainer.driveTrain.SetFrontRightMotor(rightFrontMotor);
    RobotContainer.driveTrain.SetBackLeftMotor(leftBackMotor);
    RobotContainer.driveTrain.SetBackRightMotor(rightBackMotor);
        
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveTrain.ZeroMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
