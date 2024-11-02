package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class CmdSpinIntake extends Command {
    private final double speed;
    private boolean bDone = false;

    public CmdSpinIntake(double speed) {
        this.speed = speed;
    }

    @Override
    public void initialize() {
        bDone = false;
        RobotContainer.getInstance().intake.autonSpin(speed);
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