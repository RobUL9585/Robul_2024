package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class CmdSpinIntakeStop extends Command {
    private boolean bDone = false;

    @Override
    public void initialize() {
        bDone = false;
        RobotContainer.getInstance().intake.autonSpinStop();
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