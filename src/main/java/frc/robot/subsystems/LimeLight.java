// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimeLight extends SubsystemBase {
  /** Creates a new LimeLight. */
  public LimeLight() {}


  private static double x;
  private static double y;
  private static double area;
  private static double skew;

  public static double getX() {
    return x;
  }
  public static double getY() {
    return y;
  }
  public static double getArea() {
    return area;
  }
  public static double getSkew() {
    return skew;
  }


  @Override
  public void periodic() {

    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);

    NetworkTable table = NetworkTableInstance.getDefault().getTable("LimeLight");
    NetworkTableEntry horizontalAngle = table.getEntry("tx");
    NetworkTableEntry verticalAngle = table.getEntry("ty");
    NetworkTableEntry limelightArea = table.getEntry("ta");
    NetworkTableEntry limelightSkew = table.getEntry("ts");

    x = horizontalAngle.getDouble(0.0);
    y = verticalAngle.getDouble(0.0);
    area = limelightArea.getDouble(0.0);
    skew = limelightSkew.getDouble(0.0);
  }
}
