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
import frc.robot.commands.ArmCommands.cmdIntakeLiftUp;
import frc.robot.commands.ArmCommands.cmdShoot;
import frc.robot.commands.ArmCommands.cmdShootStop;
import frc.robot.commands.ArmCommands.cmdSpinIntake;
import frc.robot.commands.ArmCommands.cmdSpinIntakeStop;
import frc.robot.commands.DriveCommands.cmdDriveStraight;

/**
 *
 */
public class Auton4ShootTurnRightGoForward extends SequentialCommandGroup {


    public Auton4ShootTurnRightGoForward() {
        addCommands(new cmdResetGyro());
        addCommands(new cmdShoot(Constants.ArmConstants.shooterSpeedFastHigher,Constants.ArmConstants.shooterSpeedFastLower));
        addCommands(new cmdDelay(0.5));
        addCommands(new cmdSpinIntake(Constants.ArmConstants.intakeSpinSpeedOut));
        addCommands(new cmdDelay(0.25));
        addCommands(new cmdSpinIntakeStop());
        addCommands(new cmdShootStop());

        addCommands(new cmdResetGyro());
        addCommands(new cmdDriveStraight(1, -0.40,0));
    
        addCommands(new cmdResetGyro());
        addCommands(new cmdTurnByGyro(35, 0.2, true));

        addCommands(new cmdResetGyro());
        addCommands(new cmdDriveStraight(0.5, -0.20,0));
        addCommands(new cmdSetMotorsBrake());
        addCommands(new cmdResetGyro());
    }


}