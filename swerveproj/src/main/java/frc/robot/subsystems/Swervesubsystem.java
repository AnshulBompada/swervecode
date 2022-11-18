package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import java.lang.Math;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.geometry.Rotation2d;

public class Swervesubsystem extends SubsystemBase {
  private WPI_TalonSRX RightFront;
  private WPI_TalonSRX LeftFront;
  private WPI_TalonSRX RightBack;
  private WPI_TalonSRX LeftBack;
  private WPI_TalonSRX r_RightFront;
  private WPI_TalonSRX r_LeftFront;
  private WPI_TalonSRX r_RightBack;
  private WPI_TalonSRX r_LeftBack;
  private double global_allwheel;
  private Timer m_timer;

  public Swervesubsystem() {
      RightFront = new WPI_TalonSRX(1);
      LeftFront = new WPI_TalonSRX(2);
      RightBack = new WPI_TalonSRX(3);
      LeftBack = new WPI_TalonSRX(4);
      r_RightFront = new WPI_TalonSRX(5);
      r_LeftFront = new WPI_TalonSRX(6);
      r_RightBack = new WPI_TalonSRX(7);
      r_LeftBack = new WPI_TalonSRX(8);

      RightFront.setNeutralMode(NeutralMode.Brake);
      RightBack.setNeutralMode(NeutralMode.Brake);
      LeftFront.setNeutralMode(NeutralMode.Brake);
      LeftBack.setNeutralMode(NeutralMode.Brake);
      r_RightFront.setNeutralMode(NeutralMode.Brake);
      r_RightBack.setNeutralMode(NeutralMode.Brake);
      r_LeftFront.setNeutralMode(NeutralMode.Brake);
      r_LeftBack.setNeutralMode(NeutralMode.Brake);
  }

  public void swerve_mode(double x_speed, double y_speed, double orientation) {
    while(x_speed == 0 & y_speed == 0) {
      RightFront.set(-orientation);
      LeftFront.set(orientation);
      RightBack.set(-orientation);
      LeftBack.set(orientation);



      //Create code for setting the motrs to an anlge
    }

    while(orientation == 0) {
      Vector2d sped_vector = new Vector2d(x_speed, y_speed);
      Rotation2d rot_vector = new Rotation2d(x_speed, y_speed);
      double magnitude = sped_vector.magnitude();
      double sign = Math.signum(y_speed);
      double u_magnitude = sign * magnitude;
      double rotation = rot_vector.getDegrees()/360;

      RightFront.set(u_magnitude);
      LeftFront.set(u_magnitude);
      RightBack.set(u_magnitude);
      LeftBack.set(u_magnitude);

      turntoang(RightFront, rotation);
      turntoang(LeftFront, rotation);
      turntoang(RightBack, rotation);
      turntoang(LeftBack, rotation);
      //Create code for setting the motors to an angle
    }
    //Work out code for rotating while translation
  }

  public void turntoang(WPI_TalonSRX motor, double rotation) {
    double time = (75 / (13*180))/rotation;
    turntime(motor, 1, time);
    global_allwheel =+ rotation/180;
  }

  public void turntime(WPI_TalonSRX motor, double speed, double time){
    Timer timer = new Timer();
    timer.start();
    while(m_timer.get() < time) {
      motor.set(speed);
    }
    motor.set(0);
  }
  @Override
  public void periodic() {

  }

  @Override
  public void simulationPeriodic() {

  }
}
