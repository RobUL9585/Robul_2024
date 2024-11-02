package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class CmdIntakeLiftMid extends Command {
    private boolean bDone = false;
    private boolean bWait = false;

    public CmdIntakeLiftMid() {
    }

    public CmdIntakeLiftMid(double speed, boolean bWait) {
        this.bWait = bWait;
    }

    @Override
    public void initialize() {
        bDone = false;
        RobotContainer.getInstance().intake.povLeftPressed = true;

    }

    @Override
    public void execute() {
        if (bWait) {
            if (!RobotContainer.getInstance().intake.povLeftPressed) {
                bDone = true;
            }
        } else {
            bDone = true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        bDone = true;
        RobotContainer.getInstance().intake.autonLiftArm(0);
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