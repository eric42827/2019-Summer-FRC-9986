package frc.robot;

public class Useful {
    public static double Constrain(double value,double max,double min){
        if(value > max){
            value = max;
        }else if(value < min){
            value = min;
        }
        return value;
    }

    public static double Map(double value,double InMax,double InMin,double OutMax,double OutMin){
        return (value - InMin) * (OutMax - OutMin) / (InMax - InMin) + OutMin;
    }

    public static int Boolean_To_Int(boolean Value){
        if(Value){
            return 1;
        }else{
            return -1;
        }
    }
}
