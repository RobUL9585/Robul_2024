package frc.robot.commands.DriveCommands;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMath;
import frc.robot.Constants.DriveConstants;



public class cmdTurnByGyro extends CommandBase {
    private double targetPosition = 0; // meters
    private double power = 0;
    private double targetHeading = 0;
    private boolean bDone = false;
    private double overshootValue = 0;
    private CANSparkMax.IdleMode idleMode = CANSparkMax.IdleMode.kBrake;
    private boolean clockwise;


    public cmdTurnByGyro(double targetHeading, double speed, boolean clockwise) {

        this.targetHeading = targetHeading;
        power = speed;
        this.clockwise = clockwise;

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        bDone = false;
        if(clockwise){ 
        
            RobotContainer.getInstance().m_driveTrain.doDrive(0, power, 0, 1);
        }
        else{
    
         RobotContainer.getInstance().m_driveTrain.doDrive(0,-power, 0, 1);
    }
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if(clockwise){
        if(RobotContainer.getInstance().m_gyro.getNormaliziedNavxAngle() >= targetHeading){
            bDone =true;
        }}
        else if(RobotContainer.getInstance().m_gyro.getNormaliziedNavxAngle() <= targetHeading){
            bDone= true;
    }}

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