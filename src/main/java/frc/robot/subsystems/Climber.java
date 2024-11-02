package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
    private final CANSparkMax climberLeft;
    private final CANSparkMax climberRight;

    private double climberLeftZeroOffset = 0;
    private double climberRightZeroOffset = 0;
    private boolean limit = true;

    public Climber() {
        climberLeft = new CANSparkMax(Constants.ArmConstants.climberLeftId, MotorType.kBrushless);
        climberLeft.setInverted(false);
        climberLeft.setIdleMode(IdleMode.kBrake);

        climberRight = new CANSparkMax(Constants.ArmConstants.climberRightId, MotorType.kBrushless);
        climberRight.setInverted(true);
        climberRight.setIdleMode(IdleMode.kBrake);

        resetEncoderClimberLeft();
        resetEncoderClimberRight();
    }

    public void resetEncoderClimberLeft() {
        climberLeftZeroOffset = climberLeft.getEncoder().getPosition();
    }

    public void resetEncoderClimberRight() {
        climberRightZeroOffset = climberRight.getEncoder().getPosition();
    }

    public double getPositionLeft() {
        return climberLeft.getEncoder().getPosition() - climberLeftZeroOffset;
    }

    public double getPositionRight() {
        return climberRight.getEncoder().getPosition() - climberRightZeroOffset;
    }

    public void disableLimit() {
        limit = false;

    }

    public void enableLimit() {
        limit = true;
    }

    public void CMDTeleOp(CommandXboxController driveController) {
        if (limit) {
            if (driveController.a().getAsBoolean() && getPositionLeft() > Constants.ArmConstants.climberMinPosition)
                climberLeft.set(Constants.ArmConstants.climberSpeedHYPERDOWN);
            else if (driveController.y().getAsBoolean() && getPositionLeft() < Constants.ArmConstants.climberMaxPosition)
                climberLeft.set(Constants.ArmConstants.climberSpeedHYPERUP);
            else if (driveController.b().getAsBoolean() && getPositionLeft() < Constants.ArmConstants.climberMaxPosition)
                climberLeft.set(Constants.ArmConstants.climberSpeedUp);
            else if (driveController.x().getAsBoolean() && getPositionLeft() > Constants.ArmConstants.climberMinPosition)
                climberLeft.set(Constants.ArmConstants.climberSpeedDown);
            else climberLeft.set(0);

            if ((driveController.povDown().getAsBoolean() ||
                    driveController.povDownLeft().getAsBoolean() ||
                    driveController.povDownRight().getAsBoolean()) &&
                    getPositionRight() > Constants.ArmConstants.climberMinPosition)
                climberRight.set(Constants.ArmConstants.climberSpeedHYPERDOWN);
            else if ((driveController.povUp().getAsBoolean() ||
                    driveController.povUpLeft().getAsBoolean() ||
                    driveController.povUpRight().getAsBoolean()) &&
                    getPositionRight() < Constants.ArmConstants.climberMaxPosition)
                climberRight.set(Constants.ArmConstants.climberSpeedHYPERUP);
            else if (driveController.povRight().getAsBoolean() &&
                    getPositionRight() < Constants.ArmConstants.climberMaxPosition)
                climberRight.set(Constants.ArmConstants.climberSpeedUp);
            else if (driveController.povLeft().getAsBoolean() &&
                    getPositionRight() > Constants.ArmConstants.climberMinPosition)
                climberRight.set(Constants.ArmConstants.climberSpeedDown);
            else climberRight.set(0);

        } else {
            if (driveController.a().getAsBoolean()) climberLeft.set(Constants.ArmConstants.climberSpeedHYPERDOWN);
            else if (driveController.y().getAsBoolean()) climberLeft.set(Constants.ArmConstants.climberSpeedHYPERUP);
            else if (driveController.b().getAsBoolean()) climberLeft.set(Constants.ArmConstants.climberSpeedUp);
            else if (driveController.x().getAsBoolean()) climberLeft.set(Constants.ArmConstants.climberSpeedDown);
            else climberLeft.set(0);

            if (driveController.povDown().getAsBoolean())
                climberRight.set(Constants.ArmConstants.climberSpeedHYPERDOWN);
            else if (driveController.povUp().getAsBoolean())
                climberRight.set(Constants.ArmConstants.climberSpeedHYPERUP);
            else if (driveController.povRight().getAsBoolean()) climberRight.set(Constants.ArmConstants.climberSpeedUp);
            else if (driveController.povLeft().getAsBoolean())
                climberRight.set(Constants.ArmConstants.climberSpeedDown);
            else climberRight.set(0);
        }
    }
}

