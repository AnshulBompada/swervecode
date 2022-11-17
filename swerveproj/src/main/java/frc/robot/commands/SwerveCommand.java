package frc.robot.commands;
import frc.robot.subsystems.Swervesubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SwerveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Swervesubsystem m_SwerveSubsystem;
  private DoubleSupplier m_x;
  private DoubleSupplier m_y;
  private DoubleSupplier m_z;

  public SwerveCommand(DoubleSupplier x, DoubleSupplier y, DoubleSupplier z, Swervesubsystem subsystem) {
    x = m_x;
    y = m_y;
    z = m_z;
    subsystem = m_SwerveSubsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_SwerveSubsystem.swerve_mode(m_x.getAsDouble(), m_y.getAsDouble(), m_z.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
