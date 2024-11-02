package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.ArmCommands.CmdShoot;
import frc.robot.commands.ArmCommands.CmdShootStop;
import frc.robot.commands.ArmCommands.CmdSpinIntake;
import frc.robot.commands.ArmCommands.CmdSpinIntakeStop;
import frc.robot.commands.CmdDelay;
import frc.robot.commands.DriveCommands.CmdResetGyro;

/**
 *
 */
public class AutonJustShoot extends SequentialCommandGroup {

    public AutonJustShoot() {
        addCommands(new CmdResetGyro());
        addCommands(new CmdShoot(Constants.ArmConstants.shooterSpeedFastHigher, Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new CmdDelay(0.5));
        addCommands(new CmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new CmdDelay(0.25));
        addCommands(new CmdSpinIntakeStop());
        addCommands(new CmdShootStop());
    }

}