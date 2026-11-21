// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.SparkMax;

public class Climber extends SubsystemBase {
  private SparkMax rightMotor = new SparkMax(1, motorType);
  private SparkMax leftMotor = new SparkMax(2, motorType);
  private Joystick controller = new Joystick(0);
  private JoystickButton raiseButton;
  private JoystickButton lowerButton;
  private int BTN_1 = 0;
  private int BTN_2 = 1;


  public Climber() {
    rightMotor.follow(leftMotor);
    new JoystickButton(controller, BTN_1).raiseButton.whileTrue(raiseClimber());
    new JoystickButton(controller, BTN_2).lowerButton.whileTrue(lowerClimber()); 
  }

  public void raise() {
    leftMotor.set(0.5);
  }

  public void lower() {
    leftMotor.set(-0.5);
  }

  public void stop() {
    leftMotor.stopMotor();
  }

  public Command raiseClimber() {
    return this.startEnd(this.raise(), this.stop());
  }

  public Command lowerClimber() {
    return this.startEnd(this.lower(), this.stop());
  }

  public void run(){
 
  }
}
