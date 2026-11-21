package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Command.RunCommand;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.Joystick;


public class DriveTrain extends SubsystemBase {

  private SparkMax frontRight = new SparkMax(1, motorType);
  private SparkMax backRight = new SparkMax(2, motorType);
  private SparkMax frontLeft = new SparkMax(3, motorType);
  private SparkMax backLeft = new SparkMax(4, motorType);
  private Joystick controller = new Joystick(0);
  private DifferentialDrive drive;
  private double forward; 
  private double rotation;
  private Robot robot;

  public static Command run3Secs = new RunCommand(driveSystem.arcadeDrive(forward, 0));
  public arcadeValues(){
    forward = -controller.getY();
    rotation = -controller.getX();
  }

  public DriveTrain(){
    arcadeValues();
    backRight.follow(frontRight);
    backLeft.follow(frontLeft);
    drive = new DifferentialDrive(frontLeft, frontRight);
    long msToRun = 3000;
    long startingTime = Utility.getFPGATime();
    while (Utility.getFPGATime() - startingTime <= msToRun){
      run3Secs.execute();
    robot.rotateBy(90);
    }
  }
}