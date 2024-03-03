package frc.robot.commands.DriveCommands;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMath;
import frc.robot.Constants.DriveConstants;


/**
 *
 */
public class cmdSetMotorsBrake extends CommandBase {
    private boolean bDone = false;
    

    public cmdSetMotorsBrake() {

    }



    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        bDone = false;
        RobotContainer.getInstance().m_driveTrain.setMotorsBrake();

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        bDone = true;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return bDone;
    }

    @Override
    public boolean runsWhenDisabled() {
 
        return false;

      
    }
}