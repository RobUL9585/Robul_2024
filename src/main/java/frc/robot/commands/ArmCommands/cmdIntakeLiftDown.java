package frc.robot.commands.ArmCommands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class cmdIntakeLiftDown extends CommandBase {
    private boolean bDone = false;
    private double speed;
    private double targetPosition;
    public cmdIntakeLiftDown(double speed) {
        this.speed = speed;
        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);

    }
    // if fixedDist = false => stagPosition is suposed to recieve the percantage to
    // be traversed in stag, in 0.xx format

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        bDone = false;
         RobotContainer.getInstance().m_intake.autonLiftArm(-Math.abs(speed));
        

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    if(RobotContainer.getInstance().m_intake.getPosition() <= Constants.ArmConstants.intakeMinPosition){
        bDone = true;
    }

        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        bDone = true;
        RobotContainer.getInstance().m_intake.autonLiftArm(0);
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