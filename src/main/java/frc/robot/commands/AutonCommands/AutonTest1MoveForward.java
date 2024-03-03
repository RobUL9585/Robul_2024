package frc.robot.commands.AutonCommands;
import com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveCommands.cmdDriveStraight;
import frc.robot.commands.DriveCommands.cmdResetGyro;
import frc.robot.commands.DriveCommands.cmdSetMotorsBrake;
import frc.robot.commands.DriveCommands.cmdTurnByGyro;
import frc.robot.commands.*;
import frc.robot.commands.ArmCommands.cmdIntakeLiftDown;
import frc.robot.commands.ArmCommands.cmdIntakeLiftUp;
import frc.robot.commands.ArmCommands.cmdShoot;
import frc.robot.commands.ArmCommands.cmdShootStop;
import frc.robot.commands.ArmCommands.cmdSpinIntake;
import frc.robot.commands.ArmCommands.cmdSpinIntakeStop;

/**
 *
 */
public class AutonTest1MoveForward extends SequentialCommandGroup {


    public AutonTest1MoveForward() {
        addCommands(new cmdResetGyro());
        addCommands(new cmdShoot(Constants.ArmConstants.shooterSpeedFastHigher,Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new cmdDelay(1));
        addCommands(new cmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new cmdDelay(0.5));
        addCommands(new cmdSpinIntakeStop());
        addCommands(new cmdShootStop());
        addCommands(new cmdDriveStraight(2, -0.10,0));
        addCommands(new cmdSetMotorsBrake());
        addCommands(new cmdResetGyro());
        addCommands(new cmdIntakeLiftDown(Constants.ArmConstants.intakeSpeedDown));
        addCommands(new cmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedIn));
        addCommands(new cmdDriveStraight(0.21, -0.05));
        addCommands(new cmdSpinIntakeStop());
        addCommands(new cmdIntakeLiftUp(Constants.ArmConstants.intakeSpeedUp));
        addCommands(new cmdDriveStraight(2.2, 0.1));
        addCommands(new cmdShoot(Constants.ArmConstants.shooterSpeedFastHigher,Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new cmdDelay(1));
        addCommands(new cmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new cmdDelay(0.5));
        addCommands(new cmdSpinIntakeStop());
        addCommands(new cmdShootStop());
        


    }


}