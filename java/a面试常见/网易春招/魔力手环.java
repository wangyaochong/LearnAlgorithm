package a面试常见.网易春招;

import Util.UtilDisplay;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/4】 at 【16:38】.
 */
public class 魔力手环 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        int time= Integer.parseInt(s.split(" ")[1]);
        String numStr = in.nextLine();
        String[] split = numStr.split(" ");
        ArrayList<Integer> nums=new ArrayList<>();
        for(int i=0;i<split.length;i++){
            nums.add(Integer.parseInt(split[i]));
        }
        int numSize=nums.size();
        while(time>0){
            int num0=nums.get(0);
            for(int i=0;i<nums.size();i++){
                int sum=nums.get(i)+(i+1==numSize? num0:nums.get(i+1));
                nums.set(i,sum%100);
            }
            time--;
        }
        for(int i=0;i<nums.size();i++){
            System.out.print(nums.get(i));
            if(i!= nums.size()-1){
                System.out.print(" ");
            }
        }
    }
}
