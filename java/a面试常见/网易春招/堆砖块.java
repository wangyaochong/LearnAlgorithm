package a面试常见.网易春招;

import java.util.ArrayList;
import java.util.Scanner;

public class 堆砖块 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String count = in.nextLine();
        String numStr = in.nextLine();
        String[] split = numStr.split(" ");
        int[] nums=new int[split.length];
        int total=0;
        ArrayList<Integer> candidate=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            nums[i] =Integer.parseInt(split[i]);
            total+=nums[i];
            candidate.add(nums[i] );
        }
        getResult(candidate,0,0,total/2);
        System.out.println(maxHeight);;
    }
    public static int maxHeight=-1;
    public static void getResult(ArrayList<Integer> candidate, int towerA, int towerB,int half){
        if(towerA!=0&& towerA==towerB&&maxHeight<towerA){
            maxHeight=towerA;
        }
        if(towerA>=half){
            return ;
        }
        for(int i=0;i<candidate.size();i++){
            Integer remove = candidate.remove(i);
            getResult(candidate,towerA+remove,towerB,half);//给A
            getResult(candidate,towerA,towerB+remove,half);//给B
            candidate.add(remove);
        }
    }
}
