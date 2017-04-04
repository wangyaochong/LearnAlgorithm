package 通用算法.动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/3】 at 【21:40】.
 */
public class 背包01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count=Integer.parseInt( s.split(" ")[0]);
        int capacity=Integer.parseInt(s.split(" ")[1]);
        ArrayList<Integer> consumption=new ArrayList<>();
        ArrayList<Integer> values=new ArrayList<>();
        while(count>0){
            String[] split = in.nextLine().split(" ");
            consumption.add(Integer.parseInt(split[0]));
            values.add(Integer.parseInt(split[1]));
            count--;
        }
        System.out.println(maxValue(consumption,values,capacity));

    }
    public static int maxValue(ArrayList<Integer> consumption, ArrayList<Integer>values,int capacity){
        int[] dp=new int[capacity+1];//dp[i]=容量为i的时候的最大value
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<consumption.size();j++){
                if(i+consumption.get(j)<capacity){//如果容量没有占满
                    dp[i+consumption.get(j)]=Math.max(dp[i+consumption.get(j)],dp[i]+values.get(j));
                }else{
                    break;
                }
            }
        }
        int max=0;
        for(int i=0;i<dp.length;i++){
            if(max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }

}
