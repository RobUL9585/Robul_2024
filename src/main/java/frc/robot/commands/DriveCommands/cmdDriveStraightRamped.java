package frc.robot.commands.DriveCommands;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.units.Distance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMath;
import frc.robot.Constants.DriveConstants;


/**
 *
 */
public class cmdDriveStraightRamped extends CommandBase {
    private double targetPosition = 0; // meters
    private double initialPower = 0.15;
    private double power;
    private double targetHeading = 0;
    private boolean bDone = false;
    private double overshootValue = 0;
    private CANSparkMax.IdleMode idleMode = CANSparkMax.IdleMode.kBrake;

    

    public cmdDriveStraightRamped(double targetDistance, double speed) {

        targetPosition = targetDistance;
        initialPower = speed;
        targetHeading = 0; //RobotContainer.getInstance().m_gyro.getNormaliziedNavxAngle();


        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);
    }


    public cmdDriveStraightRamped(double targetDistance, double speed, double heading) {

        targetPosition = targetDistance;
        initialPower = speed;
        targetHeading = heading;


        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        bDone = false;
        RobotContainer.getInstance().m_driveTrain.resetMotorEncoders();
        RobotContainer.getInstance().m_driveTrain.doDrive(power, 0, 0, 1);

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        double headingDelta = RobotMath.calcTurnRate(RobotContainer.getInstance().m_gyro.getNormaliziedNavxAngle(),
                targetHeading,DriveConstants.driveForwardProportion);
        
       // double headingDelta = 0;
       if(Math.abs(RobotContainer.getInstance().m_driveTrain.getDistanceForward()) < Math.abs(targetPosition)){
        if(Math.abs(RobotContainer.getInstance().m_driveTrain.getDistanceForward()/targetPosition)<0.2){
            power = initialPower*(9*Math.abs(RobotContainer.getInstance().m_driveTrain.getDistanceForward()/targetPosition)+0.1);
        }
        else{
        
       power = Math.sqrt(1-Math.abs(RobotContainer.getInstance().m_driveTrain.getDistanceForward()/targetPosition)) * initialPower;
        }
    }
        RobotContainer.getInstance().m_driveTrain.doDrive(power, 0, headingDelta, 1);
        if (Math.abs(RobotContainer.getInstance().m_driveTrain.getDistanceForward()) >= targetPosition  ) {
            bDone = true;
            // end(false);
            RobotContainer.getInstance().m_driveTrain.stopDrive();

        }
    }
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        RobotContainer.getInstance().m_driveTrain.stopDrive();
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