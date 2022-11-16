package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import java.lang.Math;
import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Swervesubsystem extends SubsystemBase {
  WPI_TalonSRX RightFront;
  WPI_TalonSRX LeftFront;
  WPI_TalonSRX RightBack;
  WPI_TalonSRX LeftBack;
  WPI_TalonSRX r_RightFront;
  WPI_TalonSRX r_LeftFront;
  WPI_TalonSRX r_RightBack;
  WPI_TalonSRX r_LeftBack;

  public Swervesubsystem() {
    WPI_TalonSRX RightFront = new WPI_TalonSRX(1);
    WPI_TalonSRX LeftFront = new WPI_TalonSRX(2);
    WPI_TalonSRX RightBack = new WPI_TalonSRX(3);
    WPI_TalonSRX LeftBack = new WPI_TalonSRX(4);
    WPI_TalonSRX r_RightFront = new WPI_TalonSRX(5);
    WPI_TalonSRX r_LeftFront = new WPI_TalonSRX(6);
    WPI_TalonSRX r_RightBack = new WPI_TalonSRX(7);
    WPI_TalonSRX r_LeftBack = new WPI_TalonSRX(8);

    RightFront.setNeutralMode(NeutralMode.Brake);
    RightBack.setNeutralMode(NeutralMode.Brake);
    LeftFront.setNeutralMode(NeutralMode.Brake);
    LeftBack.setNeutralMode(NeutralMode.Brake);
  }

  public void swerve_mode(double x_speed, double y_speed, double orientation) {
    while(x_speed == 0 & y_speed == 0) {
      RightFront.set(orientation);
      LeftFront.set(orientation);
      RightBack.set(orientation);
      LeftBack.set(orientation);

      //Create code for setting the motrs to an anlge
    }

    while(orientation == 0) {
      Vector2d sped_vector = new Vector2d(x_speed, y_speed);
      double magnitude = sped_vector.magnitude();
      double sign = Math.signum(y_speed);
      double u_magnitude = sign * magnitude;

      RightFront.set(u_magnitude);
      LeftFront.set(u_magnitude);
      RightBack.set(u_magnitude);
      LeftBack.set(u_magnitude);

      //Create code for setting the motors to an angle
    }
    //Work out code for rotating while translation
  }

  @Override
  public void periodic() {

  }

  @Override
  public void simulationPeriodic() {

  }
}