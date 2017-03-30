package Util;

public class UtilArray {
    public static void swap(int []input,int i,int j){
        input[i]=input[i]+input[j];//两者之和
        input[j]=input[i]-input[j];//j为i的值
        input[i]=input[i]-input[j];//i为j的值
    }
}
