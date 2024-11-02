package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private final CANSparkMax shooterLower;
    private final CANSparkMax shooterHigher;

    public Shooter() {
        shooterHigher = new CANSparkMax(Constants.ArmConstants.shooterHigherId, MotorType.kBrushed);
        shooterHigher.setInverted(true);
        shooterLower = new CANSparkMax(Constants.ArmConstants.shooterLowerId, MotorType.kBrushed);
        shooterLower.setInverted(true);
    }

    public void autonShoot(double shooterHigherSpeed, double shooterLowerSpeed) {
        shooterHigher.set(shooterHigherSpeed);
        shooterLower.set(shooterLowerSpeed);
    }

    public void autonShootStop() {
        shooterHigher.set(0);
        shooterLower.set(0);
    }

    public void CMDTeleOp(CommandXboxController armController) {
        if (armController.rightBumper().getAsBoolean()) {
            shooterHigher.set(Constants.ArmConstants.shooterSpeedFastHigher);
            shooterLower.set(Constants.ArmConstants.shooterSpeedFastLower);
        } else if (armController.povDown().getAsBoolean()) {
            shooterHigher.set(Constants.ArmConstants.shooterSpeedIn);
            shooterLower.set(Constants.ArmConstants.shooterSpeedIn);
        } else if (armController.leftBumper().getAsBoolean()) {
            shooterHigher.set(Constants.ArmConstants.shooterSpeedSlowHigher);
            shooterLower.set(Constants.ArmConstants.shooterSpeedSlowLower);
        } else if (armController.povRight().getAsBoolean()) {
            shooterHigher.set(1);
            shooterLower.set(1);
        } else {
            shooterHigher.set(0);
            shooterLower.set(0);
        }
    }
}



