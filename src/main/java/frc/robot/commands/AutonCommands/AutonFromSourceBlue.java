package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.ArmCommands.*;
import frc.robot.commands.CmdDelay;
import frc.robot.commands.DriveCommands.CmdDriveStraight;
import frc.robot.commands.DriveCommands.CmdResetGyro;
import frc.robot.commands.DriveCommands.CmdSetMotorsBrake;
import frc.robot.commands.DriveCommands.CmdTurnByGyro;

/**
 *
 */
public class AutonFromSourceBlue extends SequentialCommandGroup {

    public AutonFromSourceBlue() {
        addCommands(new CmdResetGyro());
        addCommands(new CmdShoot(Constants.ArmConstants.shooterSpeedFastHigher, Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new CmdDelay(0.5));
        addCommands(new CmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new CmdDelay(0.25));
        addCommands(new CmdSpinIntakeStop());
        addCommands(new CmdShootStop());
        addCommands(new CmdDriveStraight(0.28, -0.15, 0));
        addCommands(new CmdSetMotorsBrake());
        addCommands(new CmdResetGyro());

        addCommands(new CmdTurnByGyro(-45, 0.2, false));
        addCommands(new CmdResetGyro());
        addCommands(new CmdIntakeLiftDown(Constants.ArmConstants.intakeSpeedDown, false));
        addCommands(new CmdResetGyro());
        addCommands(new CmdDriveStraight(0.4, -0.3, 0));
        addCommands(new CmdResetGyro());

        //intaking
        addCommands(new CmdDelay(1.5));
        addCommands(new CmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedIn));
        addCommands(new CmdDriveStraight(0.7, -0.15));
        addCommands(new CmdSpinIntakeStop());
        addCommands(new CmdIntakeLiftUp(Constants.ArmConstants.intakeSpeedUp, true));

        //returning
        addCommands(new CmdResetGyro());
        addCommands(new CmdTurnByGyro(24, 0.2, true));
        addCommands(new CmdResetGyro());
        addCommands(new CmdDriveStraight(1.35, 0.4));

        addCommands(new CmdShoot(Constants.ArmConstants.shooterSpeedFastHigher, Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new CmdDelay(0.5));
        addCommands(new CmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new CmdDelay(0.25));
        addCommands(new CmdSpinIntakeStop());
        addCommands(new CmdShootStop());

        addCommands(new CmdResetGyro());
        addCommands(new CmdDriveStraight(5, -0.20, 0));

    }

}