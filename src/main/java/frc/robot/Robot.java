package frc.robot;

import edu.wpi.first.hal.FRCNetComm.tInstances;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

    private Command autonomousCommand;

    private RobotContainer robotContainer;

    @Override
    public void robotInit() {
        robotContainer = RobotContainer.getInstance();
        HAL.report(tResourceType.kResourceType_Framework, tInstances.kFramework_RobotBuilder);
        RobotContainer.getInstance().climber.enableLimit();
        RobotContainer.getInstance().intake.resetEncoder();
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
        RobotContainer.getInstance().intake.setMotorsCoast();
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = robotContainer.getAutonomousCommand();
        RobotContainer.getInstance().climber.enableLimit();

        // schedule the autonomous command (example)
        if (autonomousCommand != null) {
            autonomousCommand.schedule();
        }

        RobotContainer.getInstance().intake.setMotorsBrake();
        RobotContainer.getInstance().gyro.resetNavx();
        RobotContainer.getInstance().intake.resetEncoder();

    }

    @Override
    public void autonomousPeriodic() {
        RobotContainer.getInstance().updateSmartDashboard();
    }

    @Override
    public void teleopInit() {

        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
        RobotContainer.getInstance().intake.aPressed = false;
        RobotContainer.getInstance().intake.bPressed = false;
        RobotContainer.getInstance().intake.xPressed = false;
        RobotContainer.getInstance().intake.yPressed = false;
        RobotContainer.getInstance().climber.enableLimit();
        RobotContainer.getInstance().intake.setMotorsBrake();
        RobotContainer.getInstance().gyro.resetNavx();
    }

    @Override
    public void teleopPeriodic() {
        RobotContainer.getInstance().driveTrain.CMDTeleOp(RobotContainer.getInstance().getDriveController(), RobotContainer.getInstance().getArmController());
        RobotContainer.getInstance().intake.CMDteleOp(RobotContainer.getInstance().getArmController());
        RobotContainer.getInstance().shooter.CMDTeleOp(RobotContainer.getInstance().getArmController());
        RobotContainer.getInstance().climber.CMDTeleOp(RobotContainer.getInstance().getDriveController());
        RobotContainer.getInstance().updateSmartDashboard();

    }

    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        RobotContainer.getInstance().climber.resetEncoderClimberLeft();
        RobotContainer.getInstance().climber.resetEncoderClimberRight();
        CommandScheduler.getInstance().cancelAll();
        RobotContainer.getInstance().climber.disableLimit();
        RobotContainer.getInstance().intake.resetEncoder();

    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
        RobotContainer.getInstance().climber.CMDTeleOp(RobotContainer.getInstance().getDriveController());
        RobotContainer.getInstance().updateSmartDashboard();
    }

}
