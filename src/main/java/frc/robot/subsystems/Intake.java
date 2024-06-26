// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;

import com.revrobotics.CANSparkBase.IdleMode;

import javax.print.DocFlavor.STRING;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;


// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */

    
public class Intake extends SubsystemBase {
    //L5 = levý motor na zvedání zvedače
    //P6 = pravý motor na zvedání zvedače
    //Spin7 = motor na točení koleček zvedače
    private CANSparkMax intakeLift;
    private CANSparkMax intakeSpin;

    private double intakeLiftZeroOffset;
    public boolean a_pressed;
    public boolean y_pressed;
    
    public boolean b_pressed;
    public boolean x_pressed;

    public boolean isIntaked;

    public boolean povLeft_pressed;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public Intake() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        intakeLift = new CANSparkMax(Constants.ArmConstants.intakeLiftId, MotorType.kBrushless);
        intakeLift.setInverted(false);
        intakeLift.setIdleMode(IdleMode.kBrake);
        intakeSpin = new CANSparkMax(Constants.ArmConstants.intakeSpinId, MotorType.kBrushless);
        intakeSpin.setInverted(true);
        resetEncoder();

        a_pressed = false;
        y_pressed = false;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    public void resetEncoder(){
        intakeLiftZeroOffset = intakeLift.getEncoder().getPosition();
    }

    public void setMotorsBrake(){
        intakeLift.setIdleMode(IdleMode.kBrake);
    }
    public void setMotorscoast(){
        intakeLift.setIdleMode(IdleMode.kCoast);
    }
    public String getMotorMode(){
        if(intakeLift.getIdleMode() == IdleMode.kBrake){
            return "kBrake";
        }
        else if(intakeLift.getIdleMode() == IdleMode.kCoast){
            return "kCoast";
        }
        return "undefined";
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        if(y_pressed){
            gotoPositionIn();
        }
        else if(a_pressed){
            gotoPositionOut();
        }
        else if(povLeft_pressed){
            gotoPositionMid();
        }
        else{
            intakeLift.set(0);
}
    }


    public void CMDteleOp(CommandXboxController armController){
        if(armController.x().getAsBoolean()){
            b_pressed = false;
            x_pressed = true;
        }
        else if(armController.b().getAsBoolean()){
            b_pressed = true;
            x_pressed = false;
        }
        
        else{
            b_pressed = false;
            x_pressed = false;
        }

        if(armController.y().getAsBoolean()){
            y_pressed = true;
            a_pressed = false;
            povLeft_pressed = false;
        }
        else if(armController.a().getAsBoolean()){
            a_pressed = true;
            y_pressed = false;
            povLeft_pressed = false;

        }
            else if(armController.povLeft().getAsBoolean()){
            a_pressed = false;
            y_pressed = false;
            povLeft_pressed = true;
            }

        if(x_pressed){

            intakeSpin.set(Constants.ArmConstants.intakeSpinSpeedIn);
            isIntaked = isIntaked();
        }
        else if(b_pressed){

            intakeSpin.set(Constants.ArmConstants.intakeSpinSpeedOut);
            isIntaked = false;
        }
        
        else{
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
    
    public double getIntakeSpinPosNoOffset(){
        return intakeSpin.getEncoder().getPosition();
    }

    public boolean isIntaked(){
        if(intakeSpin.getEncoder().getVelocity()<1){
            return true;
        }
        return false;
    }

    public void autonSpin(double speed){
        intakeSpin.set(speed);
    }
    public void autonSpinStop(){
        intakeSpin.set(0);
    }
    public void autonLiftArm(double speed){
        intakeLift.set(speed);
    }
    
    public void gotoPositionMid(){
        if(getPosition() > Constants.ArmConstants.intakeMidPosition - 3 && getPosition() < Constants.ArmConstants.intakeMidPosition + 3){
        povLeft_pressed = false;
        }
        else{
        if(getPosition() < Constants.ArmConstants.intakeMidPosition){
            intakeLift.set(Constants.ArmConstants.intakeSpeedUp);
        }
        else{
            if(getPosition() > Constants.ArmConstants.intakeMidPosition){
            intakeLift.set(Constants.ArmConstants.intakeSpeedDown);
            
        }}
    }}

    public void gotoPositionIn(){
        if(getPosition() < Constants.ArmConstants.intakeMaxPosition -1){
            intakeLift.set(Constants.ArmConstants.intakeSpeedUp);
            
        }
        else{
        y_pressed = false;
        }
    }
    public void gotoPositionOut(){
            if(getPosition() > Constants.ArmConstants.intakeMinPosition + 1){
            intakeLift.set(Constants.ArmConstants.intakeSpeedDown);
        }
        else{
        a_pressed = false;
        }
    }

    public double getPosition(){
        return (intakeLift.getEncoder().getPosition() - intakeLiftZeroOffset);
    }
    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

