package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class CmdShootStop extends Command {
    private boolean bDone = false;

    public CmdShootStop() {
        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);

    }
    // if fixedDist = false => stagPosition is suposed to recieve the percantage to
    // be traversed in stag, in 0.xx format

    @Override
    public void initialize() {
        bDone = false;
        RobotContainer.getInstance().shooter.autonShootStop();
    }

    @Override
    public void execute() {
        bDone = true;

    }

    @Override
    public void end(boolean interrupted) {
        bDone = true;
    }

    @Override
    public boolean isFinished() {
        return bDone;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}