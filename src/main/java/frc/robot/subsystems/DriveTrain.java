// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
private TalonSRX frontLeftMotor = new TalonSRX(Constants.FRONT_LEFT_MOTOR);
private TalonSRX frontRightMotor = new TalonSRX(Constants.FRONT_RIGHT_MOTOR);
private TalonSRX backLeftMotor = new TalonSRX(Constants.BACK_LEFT_MOTOR);
private TalonSRX backRightMotor = new TalonSRX(Constants.BACK_RIGHT_MOTOR);


  /** Creates a new DriveTrain. */
  public DriveTrain() {}

  public void SetLeftMotors (double speed) {
    SetFrontLeftMotor(speed);
    SetBackLeftMotor(speed);
  };

  public void SetRightMotors (double speed) {
    SetFrontRightMotor(speed);
    SetBackRightMotor(speed);
  };


  public void SetFrontLeftMotor (double speed) {
    frontLeftMotor.set(ControlMode.PercentOutput, -speed * Constants.speedMultiplier);
  }
  public void SetFrontRightMotor (double speed) {
    frontRightMotor.set(ControlMode.PercentOutput, speed * Constants.speedMultiplier);
  }
  public void SetBackLeftMotor (double speed) {
    backLeftMotor.set(ControlMode.PercentOutput, -speed * Constants.speedMultiplier);
  }
  public void SetBackRightMotor (double speed) {
    backRightMotor.set(ControlMode.PercentOutput, speed * Constants.speedMultiplier);
  }

  
  public void ZeroMotors () {
    frontRightMotor.set(ControlMode.PercentOutput, 0);
    frontLeftMotor.set(ControlMode.PercentOutput, 0);
    backRightMotor.set(ControlMode.PercentOutput, 0);
    backLeftMotor.set(ControlMode.PercentOutput, 0);
  };

  



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }



}
 