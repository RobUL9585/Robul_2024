package frc.robot.commands.DriveCommands;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DriveConstants;
import frc.robot.RobotContainer;
import frc.robot.RobotMath;

public class CmdDriveStraight extends Command {
    private final double initialPower = 0.15;
    private final double power;
    private final double overshootValue = 0;
    private final CANSparkMax.IdleMode idleMode = CANSparkMax.IdleMode.kBrake;
    /**
     * in meters
     */
    private final double targetPosition;
    /**
     * in meters
     */
    private final double targetHeading;
    private boolean bDone = false;

    public CmdDriveStraight(double targetDistance, double speed) {
        targetPosition = targetDistance;
        power = speed;
        targetHeading = 0; //RobotContainer.getInstance().gyro.getNormalizedNavxAngle();
    }

    public CmdDriveStraight(double targetDistance, double speed, double heading) {
        targetPosition = targetDistance;
        power = speed;
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