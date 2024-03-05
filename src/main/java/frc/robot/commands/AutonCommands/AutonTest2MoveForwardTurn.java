package frc.robot.commands.AutonCommands;
import com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveCommands.cmdDriveStraightRamped;
import frc.robot.commands.DriveCommands.cmdResetGyro;
import frc.robot.commands.DriveCommands.cmdSetMotorsBrake;
import frc.robot.commands.DriveCommands.cmdTurnByGyro;
import frc.robot.commands.*;
import frc.robot.commands.ArmCommands.cmdIntakeLiftDown;
import frc.robot.commands.ArmCommands.cmdIntakeLiftMid;
import frc.robot.commands.ArmCommands.cmdIntakeLiftUp;
import frc.robot.commands.ArmCommands.cmdShoot;
import frc.robot.commands.ArmCommands.cmdShootStop;
import frc.robot.commands.ArmCommands.cmdSpinIntake;
import frc.robot.commands.ArmCommands.cmdSpinIntakeStop;
import frc.robot.commands.DriveCommands.cmdDriveStraight;

/**
 *
 */
public class AutonTest2MoveForwardTurn extends SequentialCommandGroup {


    public AutonTest2MoveForwardTurn() {
        addCommands(new cmdResetGyro());
        addCommands(new cmdShoot(Constants.ArmConstants.shooterSpeedFastHigher,Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new cmdDelay(0.5));
        addCommands(new cmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new cmdDelay(0.25));
        addCommands(new cmdSpinIntakeStop());
        addCommands(new cmdShootStop());
        addCommands(new cmdIntakeLiftMid());
        addCommands(new cmdResetGyro());
        addCommands(new cmdDriveStraightRamped(2.5, -0.30,0));
        addCommands(new cmdSetMotorsBrake());
        addCommands(new cmdResetGyro());
        addCommands(new cmdTurnByGyro(-90,0.1,false));
        addCommands(new cmdDelay(0.2));
        addCommands(new cmdIntakeLiftDown(Constants.ArmConstants.intakeSpeedDown));
        addCommands(new cmdResetGyro());
        addCommands(new cmdDriveStraight(0.9, -0.150,0));
        addCommands(new cmdDelay(0.3));
        addCommands(new cmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedIn));
        addCommands(new cmdResetGyro());
        addCommands(new cmdDriveStraight(0.5, -0.1));
        addCommands(new cmdSpinIntakeStop());
        addCommands(new cmdIntakeLiftUp(Constants.ArmConstants.intakeSpeedUp));
        addCommands(new cmdResetGyro());
        addCommands(new cmdDriveStraight(1, 0.10,0));
        addCommands(new cmdResetGyro());
        addCommands(new cmdTurnByGyro(90,0.1,true));
        addCommands(new cmdDelay(0.2));
        addCommands(new cmdResetGyro());
        addCommands(new cmdDriveStraightRamped(2.25, 0.4));
        addCommands(new cmdShoot(Constants.ArmConstants.shooterSpeedFastHigher,Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new cmdDelay(0.5));
        addCommands(new cmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new cmdDelay(0.25));
        addCommands(new cmdSpinIntakeStop());
        addCommands(new cmdShootStop());
        


    }


}