package frc.robot;

public class Constants {
    public static final class DriveConstants {
        public static final double superHyperMaxSpeed = 0.85;
        public static final double maxSpeed = 0.5;
        public static final int leftFrontId = 1;
        public static final int leftBackId = 2;
        public static final int rightFrontId = 3;
        public static final int rightBackId = 4;

        /**
         * Wheel diameter is in meters
         */
        public static final double wheelDiameter = 0.1524;
        public static final double gearRatio = 0.2;

        public static final double driveForwardProportion = 0.014;
    }

    public static final class ArmConstants {
        public static final int intakeLiftId = 7;
        public static final int intakeSpinId = 10;
        public static final double intakeSpinSpeedIn = 0.3;
        public static final double intakeSpinSpeedOut = -0.7;

        public static final double intakeSpeedUp = 0.35;
        public static final double intakeSpeedDown = -0.35;
        public static final double intakeMaxPosition = -3;
        public static final double intakeMinPosition = -74;
        public static final double intakeMidPosition = -48;

        public static final int shooterLowerId = 8;
        public static final int shooterHigherId = 9;
        public static final double shooterSpeedFastHigher = 0.8;
        public static final double shooterSpeedFastLower = 0.85;
        public static final double shooterSpeedSlowHigher = 0.18;
        public static final double shooterSpeedSlowLower = 0.21;
        public static final double shooterSpeedIn = -0.2;

        public static final int climberLeftId = 6;
        public static final int climberRightId = 5;

        public static final double climberSpeedUp = 0.15;
        public static final double climberSpeedDown = -0.15;

        public static final double climberSpeedHYPERDOWN = -1;
        public static final double climberSpeedHYPERUP = 1;

        public static final double climberMaxPosition = -10;
        public static final double climberMinPosition = -700;
    }
}

