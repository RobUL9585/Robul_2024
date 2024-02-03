package frc.robot;

public class RobotMath {
    public static double getSqRtValue(double input){
        if(input != Math.abs(input)){
            return -1* Math.sqrt(Math.abs(input));
        }
        
        return Math.sqrt(Math.abs(input));
    }
}
