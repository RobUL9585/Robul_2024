package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class CmdResetGyro extends Command {
    private boolean bDone = false;

    public CmdResetGyro() {
    }

    @Override
    public void initialize() {
        bDone = false;
        RobotContainer.getInstance().gyro.resetNavx();
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