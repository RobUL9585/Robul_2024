package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotMath;

public class CmdDelay extends Command {

    public final double delayTime;
    public boolean bDone = false;
    public double startTime = 0;
    public double endTime = 0;

    public CmdDelay(double seconds) {
        delayTime = seconds;
    }

    @Override
    public void initialize() {
        bDone = false;
        startTime = RobotMath.getTime();
        endTime = startTime + delayTime;
        System.err.println("Delay for a bit");
    }

    @Override
    public void execute() {

        if (RobotMath.getTime() >= endTime) {
            bDone = true;
        }
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