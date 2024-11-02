package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.ArmCommands.*;
import frc.robot.commands.CmdDelay;
import frc.robot.commands.DriveCommands.CmdDriveStraight;
import frc.robot.commands.DriveCommands.CmdDriveStraightRamped;
import frc.robot.commands.DriveCommands.CmdResetGyro;
import frc.robot.commands.DriveCommands.CmdSetMotorsBrake;

public class AutonTestMoveForward extends SequentialCommandGroup {
    public AutonTestMoveForward() {
        addCommands(new CmdResetGyro());
        addCommands(new CmdShoot(Constants.ArmConstants.shooterSpeedFastHigher, Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new CmdDelay(0.5));
        addCommands(new CmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new CmdDelay(0.25));
        addCommands(new CmdSpinIntakeStop());
        addCommands(new CmdShootStop());
        addCommands(new CmdDriveStraightRamped(2, -0.30, 0));
        addCommands(new CmdSetMotorsBrake());
        addCommands(new CmdResetGyro());
        addCommands(new CmdIntakeLiftDown(Constants.ArmConstants.intakeSpeedDown));
        addCommands(new CmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedIn));
        addCommands(new CmdDriveStraight(0.4, -0.1));
        addCommands(new CmdSpinIntakeStop());
        addCommands(new CmdIntakeLiftUp(Constants.ArmConstants.intakeSpeedUp));
        addCommands(new CmdDriveStraightRamped(2.3, 0.4));
        addCommands(new CmdShoot(Constants.ArmConstants.shooterSpeedFastHigher, Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new CmdDelay(0.5));
        addCommands(new CmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new CmdDelay(0.25));
        addCommands(new CmdSpinIntakeStop());
        addCommands(new CmdShootStop());
    }
}