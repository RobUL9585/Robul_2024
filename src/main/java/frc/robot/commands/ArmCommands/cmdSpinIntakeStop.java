package frc.robot.commands.ArmCommands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class cmdSpinIntakeStop extends CommandBase {
    private boolean bDone = false;
    public cmdSpinIntakeStop() {
        
        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);

    }
    // if fixedDist = false => stagPosition is suposed to recieve the percantage to
    // be traversed in stag, in 0.xx format

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        bDone = false;
         RobotContainer.getInstance().m_intake.autonSpinStop();

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        bDone = true;
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        bDone = true;
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return bDone;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}