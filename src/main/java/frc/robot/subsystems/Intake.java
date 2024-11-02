package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;

@SuppressWarnings("unused")
public class Intake extends SubsystemBase {
    //L5 = levy motor na zvedani zvedace
    //P6 = pravy motor na zvedani zvedace
    //Spin7 = motor na toceni kolecek zvedace
    private final CANSparkMax intakeLift;
    private final CANSparkMax intakeSpin;
    public boolean aPressed;
    public boolean yPressed;
    public boolean bPressed;
    public boolean xPressed;
    public boolean isIntaked;
    public boolean povLeftPressed;
    private double intakeLiftZeroOffset;

    public Intake() {
        intakeLift = new CANSparkMax(Constants.ArmConstants.intakeLiftId, MotorType.kBrushless);
        intakeLift.setInverted(false);
        intakeLift.setIdleMode(IdleMode.kBrake);
        intakeSpin = new CANSparkMax(Constants.ArmConstants.intakeSpinId, MotorType.kBrushless);
        intakeSpin.setInverted(true);
        resetEncoder();

        aPressed = false;
        yPressed = false;
    }

    public void resetEncoder() {
        intakeLiftZeroOffset = intakeLift.getEncoder().getPosition();
    }

    public void setMotorsBrake() {
        intakeLift.setIdleMode(IdleMode.kBrake);
    }

    public void setMotorsCoast() {
        intakeLift.setIdleMode(IdleMode.kCoast);
    }

    public String getMotorMode() {
        if (intakeLift.getIdleMode() == IdleMode.kBrake) return "kBrake";
        else if (intakeLift.getIdleMode() == IdleMode.kCoast) return "kCoast";
        return "undefined";
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        if (yPressed) {
            gotoPositionIn();
        } else if (aPressed) {
            gotoPositionOut();
        } else if (povLeftPressed) {
            gotoPositionMid();
        } else {
            intakeLift.set(0);
        }
    }

    public void CMDteleOp(CommandXboxController armController) {
        if (armController.x().getAsBoolean()) {
            bPressed = false;
            xPressed = true;
        } else if (armController.b().getAsBoolean()) {
            bPressed = true;
            xPressed = false;
        } else {
            bPressed = false;
            xPressed = false;
        }

        if (armController.y().getAsBoolean()) {
            yPressed = true;
            aPressed = false;
            povLeftPressed = false;
        } else if (armController.a().getAsBoolean()) {
            aPressed = true;
            yPressed = false;
            povLeftPressed = false;

        } else if (armController.povLeft().getAsBoolean()) {
            aPressed = false;
            yPressed = false;
            povLeftPressed = true;
        }

        if (xPressed) {
            intakeSpin.set(Constants.ArmConstants.intakeSpinSpeedIn);
            isIntaked = isIntaked();
        } else if (bPressed) {

            intakeSpin.set(Constants.ArmConstants.intakeSpinSpeedOut);
            isIntaked = false;
        } else {
            intakeSpin.set(0);
        }
    }
        /*
        if(armController.y().getAsBoolean() && getPosition() < Constants.ArmConstants.intakeMaxPosition){
            intakeLeft.set(Constants.ArmConstants.intakeSpeedUp);
            intakeRight.set(Constants.ArmConstants.intakeSpeedUp);
            
        }
        else if(armController.a().getAsBoolean() && getPosition() > Constants.ArmConstants.intakeMinPosition){
            intakeLeft.set(Constants.ArmConstants.intakeSpeedDown);
            intakeRight.set(Constants.ArmConstants.intakeSpeedDown);
            
        }
        else{
            intakeLeft.set(0);
            intakeRight.set(0);}
        }
        */

    public double getIntakeSpinPosNoOffset() {
        return intakeSpin.getEncoder().getPosition();
    }

    public boolean isIntaked() {
        return intakeSpin.getEncoder().getVelocity() < 1;
    }

    public void autonSpin(double speed) {
        intakeSpin.set(speed);
    }

    public void autonSpinStop() {
        intakeSpin.set(0);
    }

    public void autonLiftArm(double speed) {
        intakeLift.set(speed);
    }

    public void gotoPositionMid() {
        if (getPosition() > Constants.ArmConstants.intakeMidPosition - 3 && getPosition() < Constants.ArmConstants.intakeMidPosition + 3) {
            povLeftPressed = false;
        } else {
            if (getPosition() < Constants.ArmConstants.intakeMidPosition) {
                intakeLift.set(Constants.ArmConstants.intakeSpeedUp);
            } else {
                if (getPosition() > Constants.ArmConstants.intakeMidPosition) {
                    intakeLift.set(Constants.ArmConstants.intakeSpeedDown);

                }
            }
        }
    }

    public void gotoPositionIn() {
        if (getPosition() < Constants.ArmConstants.intakeMaxPosition - 1) {
            intakeLift.set(Constants.ArmConstants.intakeSpeedUp);

        } else {
            yPressed = false;
        }
    }

    public void gotoPositionOut() {
        if (getPosition() > Constants.ArmConstants.intakeMinPosition + 1) {
            intakeLift.set(Constants.ArmConstants.intakeSpeedDown);
        } else {
            aPressed = false;
        }
    }

    public double getPosition() {
        return (intakeLift.getEncoder().getPosition() - intakeLiftZeroOffset);
    }

}

