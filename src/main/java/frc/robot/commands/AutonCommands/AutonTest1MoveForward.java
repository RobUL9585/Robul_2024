package frc.robot.commands.AutonCommands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.cmdDriveStraight;
import frc.robot.commands.DriveCommands.cmdResetGyro;

/**
 *
 */
public class AutonTest1MoveForward extends SequentialCommandGroup {


    public AutonTest1MoveForward() {
        addCommands(new cmdResetGyro());
        addCommands(new cmdDriveStraight(5, 0.25));

    }


}