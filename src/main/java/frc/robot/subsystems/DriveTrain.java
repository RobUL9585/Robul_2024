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


import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.RobotMath;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
public CANSparkMax leftFront;
public CANSparkMax leftBack;
public CANSparkMax rightFront;
public CANSparkMax rightBack;

private double leftFrontZeroOffset;
private double leftBackZeroOffset;
private double rightFrontZeroOffset;
private double rightBackZeroOffset;


public boolean isRychly = false;



private double rightFrontPower = 0;
private double rightBackPower = 0;
private double leftFrontPower = 0;
private double leftBackPower = 0;

//v metrech
private double driveForwardDistance = 0;
private double driveForwardSpeed = 0;
private double driveForwardStartAngle = 0;
private boolean bDone  = true;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
leftFront = new CANSparkMax(Constants.DriveConstants.leftFrontId, MotorType.kBrushless);
leftFront.setInverted(true);
leftFront.setSmartCurrentLimit(35);
leftFront.setIdleMode(IdleMode.kBrake);
leftFront.burnFlash();
leftBack = new CANSparkMax(Constants.DriveConstants.leftBackId, MotorType.kBrushless);
leftBack.setInverted(true);
leftBack.setSmartCurrentLimit(35);
leftBack.setIdleMode(IdleMode.kBrake);
leftBack.burnFlash();
rightFront = new CANSparkMax(Constants.DriveConstants.rightFrontId, MotorType.kBrushless);
rightFront.setInverted(false);
rightFront.setSmartCurrentLimit(35);
rightFront.setIdleMode(IdleMode.kBrake);
rightFront.burnFlash();
rightBack = new CANSparkMax(Constants.DriveConstants.rightBackId, MotorType.kBrushless);
rightBack.setInverted(false);
rightBack.setSmartCurrentLimit(35);
rightBack.setIdleMode(IdleMode.kBrake);
rightBack.burnFlash();


resetMotorEncoders();


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    public void CMDteleOp(CommandXboxController driveController, CommandXboxController armController) {
        //tank drive
         //doDrive(-1* driveController.getLeftY(), driveController.getLeftX(), driveController.getRightTriggerAxis()*0.6);

        //mecanum drive
        if(driveController.leftBumper().getAsBoolean()){
            isRychly = true;
 doDrive(-1* driveController.getLeftY(), driveController.getRightX(), driveController.getLeftX(),
            RobotMath.getSqRtValue(driveController.getRightTriggerAxis())*Constants.DriveConstants.superHyperMaxSpeed);
        }
        else{
            
        isRychly = false;
         doDrive(-1* driveController.getLeftY(), driveController.getRightX(), driveController.getLeftX(),
            RobotMath.getSqRtValue(driveController.getRightTriggerAxis())*Constants.DriveConstants.maxSpeed);
        //}
        if(!bDone){
            driveForwardStraight();
        }
        //mechanum drive using pov (šipky)
    /* 
        if(driveController.povUp().getAsBoolean()){
            doDrive(1, driveController.getRightX(), 0,
           RobotMath.getSqRtValue(driveController.getRightTriggerAxis())*Constants.DriveConstants.maxSpeed);
        }
        else if(driveController.povUpLeft().getAsBoolean()){
            doDrive(1, driveController.getRightX(), -1,
           RobotMath.getSqRtValue(driveController.getRightTriggerAxis())*Constants.DriveConstants.maxSpeed);
        }
        else if(driveController.povLeft().getAsBoolean()){
            doDrive(0, driveController.getRightX(), -1,
           RobotMath.getSqRtValue(driveController.getRightTriggerAxis())*Constants.DriveConstants.maxSpeed);
        }
        else if(driveController.povDownLeft().getAsBoolean()){
            doDrive(-1, driveController.getRightX(), -1,
           RobotMath.getSqRtValue(driveController.getRightTriggerAxis())*Constants.DriveConstants.maxSpeed);
        }
        else if(driveController.povDown().getAsBoolean()){
            doDrive(-1, driveController.getRightX(), 0,
           RobotMath.getSqRtValue(driveController.getRightTriggerAxis())*Constants.DriveConstants.maxSpeed);
        }
        else if(driveController.povDownRight().getAsBoolean()){
            doDrive(-1, driveController.getRightX(), 1,
           RobotMath.getSqRtValue(driveController.getRightTriggerAxis())*Constants.DriveConstants.maxSpeed);
        }
        else if(driveController.povRight().getAsBoolean()){
            doDrive(0, driveController.getRightX(), 1,
           RobotMath.getSqRtValue(driveController.getRightTriggerAxis())*Constants.DriveConstants.maxSpeed);
        }
        else if(driveController.povUpRight().getAsBoolean()){
            doDrive(1, driveController.getRightX(), 1,
           RobotMath.getSqRtValue(driveController.getRightTriggerAxis())*Constants.DriveConstants.maxSpeed);
        }
        else{
            doDrive(0, driveController.getRightX(), 0, RobotMath.getSqRtValue(driveController.getRightTriggerAxis())*Constants.DriveConstants.maxSpeed);
        }
        */

        //mecanum bez odmocniny
        //doDrive(-1* driveController.getLeftY(), driveController.getRightX(), driveController.getLeftX(),
          // driveController.getRightTriggerAxis()*Constants.DriveConstants.maxSpeed);

           
       

    

     }

    //pozitvni turn = po smeru hodinovych rucicek
   /* public void doDrive(double forward, double turn, double speed){
        leftFrontPower = forward - turn;
        leftBackPower = forward - turn;
        rightFrontPower = forward + turn;
        rightBackPower = forward + turn;
        
        scaleMotorPowers(getMaxMotorPower());
        
        leftFrontPower *= speed;
        leftBackPower *= speed;
        rightFrontPower *= speed;
        rightBackPower *= speed;

        setMotorPowers();

    }
 */
    }
    

    //pro mecanum drive
    public void doDrive(double forward, double turn, double strafe, double speed){
        leftFrontPower = forward - turn + strafe;
        leftBackPower = forward - turn - strafe;
        rightFrontPower = forward + turn - strafe;
        rightBackPower = forward + turn + strafe;
        
        scaleMotorPowers(getMaxMotorPower());
        
        leftFrontPower *= speed;
        leftBackPower *= speed;
        rightFrontPower *= speed;
        rightBackPower *= speed;

        setMotorPowers();
    }

 public void setMotorsBrake(){
    leftBack.setIdleMode(IdleMode.kBrake);
    leftFront.setIdleMode(IdleMode.kBrake);
    rightBack.setIdleMode(IdleMode.kBrake);
    rightFront.setIdleMode(IdleMode.kBrake);

 }

    public double getMaxMotorPower(){
        double maxValue = -5;
        if(Math.abs(leftFrontPower)>maxValue){
            maxValue = Math.abs(leftFrontPower);
        }
        if(Math.abs(leftBackPower)>maxValue){
            maxValue = Math.abs(leftBackPower);
        }
        if(Math.abs(rightFrontPower)>maxValue){
            maxValue = Math.abs(rightFrontPower);
        }
        if(Math.abs(rightBackPower)>maxValue){
            maxValue = Math.abs(rightBackPower);
        }

        return maxValue;
    }

    public void scaleMotorPowers(double maxValue){
        if(maxValue>1){
            leftFrontPower /= maxValue;
            leftBackPower /= maxValue;
            rightFrontPower /= maxValue;
            rightBackPower /= maxValue;
        }
    }

    public void setMotorPowers(){
        leftFront.set(leftFrontPower);
        leftBack.set(leftBackPower);
        rightFront.set(rightFrontPower);
        rightBack.set(rightBackPower);
    }

    public void stopDrive(){
        leftFront.set(0);
        leftBack.set(0);
        rightFront.set(0);
        rightBack.set(0);
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }
    


    public void resetMotorEncoders(){
    leftBackZeroOffset = leftBack.getEncoder().getPosition();
    leftFrontZeroOffset = leftFront.getEncoder().getPosition();
    rightBackZeroOffset = rightBack.getEncoder().getPosition();
    rightFrontZeroOffset = rightFront.getEncoder().getPosition();


    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void cmddriveForward(double distance, double speed){
        driveForwardDistance = distance;
        driveForwardSpeed = speed;
        driveForwardStartAngle = RobotContainer.getInstance().m_gyro.getNormaliziedNavxAngle();
        bDone = false;
        resetMotorEncoders();


    }
    public void driveForwardStraight(){
        if(getDistanceForward() >= driveForwardDistance){
            bDone = true;
        }
        else{
            double gyroTurnCorrection = RobotMath.calcTurnRate(RobotContainer.getInstance().m_gyro.getNormaliziedNavxAngle(),driveForwardStartAngle,Constants.DriveConstants.driveForwardProportion);
            doDrive(driveForwardSpeed,gyroTurnCorrection,0, 1);
        }
        



    }

    public double getDistanceForward(){
        double offsetAvg = (leftBackZeroOffset + leftFrontZeroOffset + rightBackZeroOffset + rightFrontZeroOffset) * 0.25;
        double encoderAvg = (leftBack.getEncoder().getPosition() + leftFront.getEncoder().getPosition() + rightBack.getEncoder().getPosition() + rightFront.getEncoder().getPosition()) * 0.25;
        double motorRotsAvg = encoderAvg - offsetAvg;
        return motorRotsAvg * Math.PI * Constants.DriveConstants.wheelDiameter * Constants.DriveConstants.gearRatio;
    }

}


