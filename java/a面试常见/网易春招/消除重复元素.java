package a面试常见.网易春招;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/4】 at 【16:33】.
 */
public class 消除重复元素 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String count = scanner.nextLine();
        String nums = scanner.nextLine();
        String[] split = nums.split(" ");
        ArrayList<String> result=new ArrayList<>();
        for(int i=split.length-1;i>=0;i--){
            if(!result.contains(split[i])){
                result.add(split[i]);
            }
        }
        for(int i=result.size()-1;i>=0;i--){
            System.out.print(result.get(i));
            if(i!=0){
                System.out.print(" ");
            }
        }
    }
}
