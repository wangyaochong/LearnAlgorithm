package a面试常见.网易春招;

import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/4】 at 【15:49】.
 */
public class 双核处理 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String count = in.nextLine();
        String taskString = in.nextLine();
        String[] split = taskString.split(" ");
        int[] tasks=new int[split.length];
        int capacity=0;
        for(int i=0;i<split.length;i++){
            tasks[i]=Integer.parseInt(split[i]);
            tasks[i]/=1024;
            capacity+=tasks[i];
        }
        int total=capacity;
        capacity=capacity>>1;
        int [] dp=new int[capacity+1];//dp[i]表示的是花费时间i能够处理的最多的任务
        for(int i=0;i<tasks.length;i++){
            for(int j=capacity;j>0;j--){
                if(j-tasks[i]>=0){
                    dp[j]=Math.max(dp[j],dp[j-tasks[i]]+tasks[i]);
                }
            }
        }
        System.out.println((total-dp[dp.length-1])*1024);
    }
}
