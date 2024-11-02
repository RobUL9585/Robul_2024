package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

/**
 *
 */
public class CmdSetMotorsBrake extends Command {
    private boolean bDone = false;

    public CmdSetMotorsBrake() {

    }

    @Override
    public void initialize() {
        bDone = false;
        RobotContainer.getInstance().driveTrain.setMotorsBrake();

    }

    @Override
    public void execute() {

        bDone = true;
    }

    @Override
    public void end(boolean interrupted) {
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