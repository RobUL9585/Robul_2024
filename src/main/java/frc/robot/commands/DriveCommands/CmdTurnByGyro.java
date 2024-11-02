package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class CmdTurnByGyro extends Command {
    private final boolean clockwise;
    private double power = 0;
    private double targetHeading = 0;
    private boolean bDone = false;

    public CmdTurnByGyro(double targetHeading, double speed, boolean clockwise) {
        this.targetHeading = targetHeading;
        power = speed;
        this.clockwise = clockwise;

    }

    @Override
    public void initialize() {
        bDone = false;
        if (clockwise) RobotContainer.getInstance().driveTrain.doDrive(0, power, 0, 1);
        else RobotContainer.getInstance().driveTrain.doDrive(0, -power, 0, 1);
    }

    @Override
    public void execute() {
        if ((clockwise && RobotContainer.getInstance().gyro.getNormalizedNavxAngle() >= targetHeading) ||
                (!clockwise && RobotContainer.getInstance().gyro.getNormalizedNavxAngle() <= targetHeading))
            bDone = true;
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.getInstance().driveTrain.stopDrive();
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