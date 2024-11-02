package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.ArmCommands.*;
import frc.robot.commands.CmdDelay;
import frc.robot.commands.DriveCommands.*;

public class AutonTestMoveForwardTurn extends SequentialCommandGroup {
    public AutonTestMoveForwardTurn() {
        addCommands(new CmdResetGyro());
        addCommands(new CmdShoot(Constants.ArmConstants.shooterSpeedFastHigher, Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new CmdDelay(0.5));
        addCommands(new CmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new CmdDelay(0.25));
        addCommands(new CmdSpinIntakeStop());
        addCommands(new CmdShootStop());
        addCommands(new CmdIntakeLiftMid());
        addCommands(new CmdResetGyro());
        addCommands(new CmdDriveStraightRamped(2.5, -0.30, 0));
        addCommands(new CmdSetMotorsBrake());
        addCommands(new CmdResetGyro());
        addCommands(new CmdTurnByGyro(-90, 0.1, false));
        addCommands(new CmdDelay(0.2));
        addCommands(new CmdIntakeLiftDown(Constants.ArmConstants.intakeSpeedDown));
        addCommands(new CmdResetGyro());
        addCommands(new CmdDriveStraight(0.9, -0.150, 0));
        addCommands(new CmdDelay(0.3));
        addCommands(new CmdResetGyro());
        addCommands(new CmdDriveStraight(0.9, -0.150, 0));
        addCommands(new CmdIntakeLiftDown(Constants.ArmConstants.intakeSpeedDown));
        addCommands(new CmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedIn));
        addCommands(new CmdResetGyro());
        addCommands(new CmdDriveStraight(0.5, -0.1));
        addCommands(new CmdSpinIntakeStop());
        addCommands(new CmdIntakeLiftUp(Constants.ArmConstants.intakeSpeedUp));
        addCommands(new CmdResetGyro());
        addCommands(new CmdDriveStraight(1, 0.10, 0));
        addCommands(new CmdResetGyro());
        addCommands(new CmdTurnByGyro(90, 0.1, true));
        addCommands(new CmdDelay(0.2));
        addCommands(new CmdResetGyro());
        addCommands(new CmdDriveStraightRamped(2.25, 0.4));
        addCommands(new CmdShoot(Constants.ArmConstants.shooterSpeedFastHigher, Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new CmdDelay(0.5));
        addCommands(new CmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new CmdDelay(0.25));
        addCommands(new CmdSpinIntakeStop());
        addCommands(new CmdShootStop());
    }
}