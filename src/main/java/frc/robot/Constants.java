// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
   
     public static final class DriveConstants {
        public static final double maxSpeed = 0.6;
        public static final int leftFrontId = 1;
          public static final int leftBackId = 2;
          public static final int rightFrontId = 3;
          public static final int rightBackId = 4;
       
     }
    
     public static final class ArmConstants{
          public static final int intakeLeftId = 5;
          public static final int intakeRightId = 6;
          public static final int intakeSpinId = 7;
          public static final double intakeSpinSpeedIn = 0.2;
          public static final double intakeSpinSpeedOut = -0.7;

          public static final double intakeSpeedUp = 0.25;
          public static final double intakeSpeedDown = -0.25;


          public static final int shooterLowerId = 8;
          public static final int shooterHigherId = 9;
          public static final double shooterSpeedFast = 0.7;
          public static final double shooterSpeedSlow = 0.2;
          public static final double shooterSpeedIn = -0.2;



     }
    
}
