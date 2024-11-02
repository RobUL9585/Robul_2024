package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class CmdIntakeLiftDown extends Command {
    private final double speed;
    private boolean bDone = false;
    private boolean bWait = false;

    public CmdIntakeLiftDown(double speed) {
        this.speed = speed;
    }

    public CmdIntakeLiftDown(double speed, boolean bWait) {
        this.speed = speed;
        this.bWait = bWait;
    }

    @Override
    public void initialize() {
        bDone = false;
        RobotContainer.getInstance().intake.aPressed = true;
    }

    @Override
    public void execute() {
        if (bWait) {
            if (RobotContainer.getInstance().intake.getPosition() <= Constants.ArmConstants.intakeMinPosition) {
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