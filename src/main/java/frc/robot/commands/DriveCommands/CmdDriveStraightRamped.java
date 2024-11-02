package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DriveConstants;
import frc.robot.RobotContainer;
import frc.robot.RobotMath;

public class CmdDriveStraightRamped extends Command {
    private final double targetPosition; // meters
    private final double initialPower;
    private final double targetHeading;
    private double power;
    private boolean bDone = false;

    public CmdDriveStraightRamped(double targetDistance, double speed) {
        targetPosition = targetDistance;
        initialPower = speed;
        targetHeading = 0; //RobotContainer.getInstance().gyro.getNormalizedNavxAngle();
    }

    public CmdDriveStraightRamped(double targetDistance, double speed, double heading) {
        targetPosition = targetDistance;
        initialPower = speed;
        targetHeading = heading;
    }

    @Override
    public void initialize() {
        bDone = false;
        RobotContainer.getInstance().driveTrain.resetMotorEncoders();
        RobotContainer.getInstance().driveTrain.doDrive(power, 0, 0, 1);

    }

    @Override
    public void execute() {

        double headingDelta = RobotMath.calcTurnRate(RobotContainer.getInstance().gyro.getNormalizedNavxAngle(),
                targetHeading, DriveConstants.driveForwardProportion);

        // double headingDelta = 0;
        if (Math.abs(RobotContainer.getInstance().driveTrain.getDistanceForward()) < Math.abs(targetPosition)) {
            if (Math.abs(RobotContainer.getInstance().driveTrain.getDistanceForward() / targetPosition) < 0.2) {
                power = initialPower * (9 * Math.abs(RobotContainer.getInstance().driveTrain.getDistanceForward() / targetPosition) + 0.1);
            } else {

                power = Math.sqrt(1 - Math.abs(RobotContainer.getInstance().driveTrain.getDistanceForward() / targetPosition)) * initialPower;
            }
        }
        RobotContainer.getInstance().driveTrain.doDrive(power, 0, headingDelta, 1);
        if (Math.abs(RobotContainer.getInstance().driveTrain.getDistanceForward()) >= targetPosition) {
            bDone = true;
            // end(false);
            RobotContainer.getInstance().driveTrain.stopDrive();

        }
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