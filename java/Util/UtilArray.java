package Util;

import java.util.List;

public class UtilArray {
    public static void swap(int []input,int i,int j){
        int tmp=input[i];
        input[i]=input[j];
        input[j]=tmp;
//注释的那段代码，如果下标相同时会出错
//        input[i]=input[i]+input[j];//两者之和
//        input[j]=input[i]-input[j];//j为i的值
//        input[i]=input[i]-input[j];//i为j的值
    }
    public static void swap(List input, int i, int j){
        Object o = input.get(i);
        input.set(i,input.get(j));
        input.set(j,o);
    }
    public static int[] mergeOnePart(int[] input,int leftStart,int rightStart,int end){
        int [] result=new int[end-leftStart];
        int rLoc=0;
        while(rLoc<result.length){
            if(rightStart==result.length||(leftStart<rightStart&&input[leftStart]<input[rightStart])){
                result[rLoc]=input[leftStart];
                leftStart++;
            }else{
                result[rLoc]=input[rightStart];
                rightStart++;
            }
            rLoc++;
        }
        return result;
    }
    public static int[] merge(int [] a,int []b){
        int [] result=new int[a.length+b.length];
        int ai=0;
        int bi=0;
        int ri=0;
        while(ri<result.length){
            if(bi==b.length||(ai<a.length&& a[ai]<b[bi])){
                result[ri]=a[ai];
                ai++;
            }else{
                result[ri]=b[bi];
                bi++;
            }
            ri++;
        }
        return result;
    }
}
