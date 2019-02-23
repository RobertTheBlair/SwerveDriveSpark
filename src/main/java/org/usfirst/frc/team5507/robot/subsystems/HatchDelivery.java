/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5507.robot.subsystems;

import org.usfirst.frc.team5507.robot.commands.HatchIn;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchDelivery extends Subsystem {
  DoubleSolenoid solenoid1 = new DoubleSolenoid(4, 5);
  DoubleSolenoid solenoid2 = new DoubleSolenoid(2, 3);
  private boolean isRetracted = true;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new HatchIn());
  }

  public void retractHatch() {
    solenoid1.set(DoubleSolenoid.Value.kForward);
    solenoid2.set(DoubleSolenoid.Value.kForward);
  }

  public void placeHatch() {
    solenoid1.set(DoubleSolenoid.Value.kReverse);
    solenoid2.set(DoubleSolenoid.Value.kReverse);
  }
  public boolean getRetracted()
  {
    return isRetracted;
  }
}
