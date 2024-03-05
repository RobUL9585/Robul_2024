package frc.robot.commands.ArmCommands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class cmdIntakeLiftMid extends CommandBase {
    private boolean bDone = false;
    private boolean bWait = false;
    private double speed;
    public cmdIntakeLiftMid() {
        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);

    }

    public cmdIntakeLiftMid(double speed, boolean bWait) {
        this.speed = speed;
        this.bWait = bWait;
        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        bDone = false;
        RobotContainer.getInstance().m_intake.povLeft_pressed = true;

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    if(bWait){
        if(!RobotContainer.getInstance().m_intake.povLeft_pressed){
            bDone = true;
        }
    }
    else{
        bDone = true;
    }    
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        bDone = true;
        RobotContainer.getInstance().m_intake.autonLiftArm(0);
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