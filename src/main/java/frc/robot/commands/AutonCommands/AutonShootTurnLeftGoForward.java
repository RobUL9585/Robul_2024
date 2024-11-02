package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.ArmCommands.CmdShoot;
import frc.robot.commands.ArmCommands.CmdShootStop;
import frc.robot.commands.ArmCommands.CmdSpinIntake;
import frc.robot.commands.ArmCommands.CmdSpinIntakeStop;
import frc.robot.commands.CmdDelay;
import frc.robot.commands.DriveCommands.CmdDriveStraight;
import frc.robot.commands.DriveCommands.CmdResetGyro;
import frc.robot.commands.DriveCommands.CmdSetMotorsBrake;
import frc.robot.commands.DriveCommands.CmdTurnByGyro;

/**
 *
 */
public class AutonShootTurnLeftGoForward extends SequentialCommandGroup {

    public AutonShootTurnLeftGoForward() {
        addCommands(new CmdResetGyro());
        addCommands(new CmdShoot(Constants.ArmConstants.shooterSpeedFastHigher, Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new CmdDelay(0.5));
        addCommands(new CmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new CmdDelay(0.25));
        addCommands(new CmdSpinIntakeStop());
        addCommands(new CmdShootStop());

        addCommands(new CmdResetGyro());
        addCommands(new CmdDriveStraight(1, -0.40, 0));

        addCommands(new CmdResetGyro());
        addCommands(new CmdTurnByGyro(-35, 0.2, false));

        addCommands(new CmdResetGyro());
        addCommands(new CmdDriveStraight(0.5, -0.20, 0));
        addCommands(new CmdSetMotorsBrake());
        addCommands(new CmdResetGyro());
    }

}