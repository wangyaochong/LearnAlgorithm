package a面试常见.网易春招;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/4】 at 【16:21】.
 */
public class 调整队形 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String queue = in.nextLine();
        ArrayList<Character> q=new ArrayList<>();
        ArrayList<Character> q2=new ArrayList<>();
        for(int i=0;i<queue.length();i++){
            q.add(queue.charAt(i));
            q2.add(queue.charAt(i));
        }
        int minCount1=0;
        for(int i=1;i<q.size();i++){
            for(int j=i;j>=1;j--){
                if(q.get(j)<q.get(j-1)){//交换位置
                    minCount1++;
                    char tmp=q.get(j);
                    q.set(j,q.get(j-1));
                    q.set(j-1,tmp);
                }else{
                    break;
                }
            }
        }
        int minCount2=0;
        for(int i=1;i<q2.size();i++){
            for(int j=i;j>=1;j--){
                if(q2.get(j)>q2.get(j-1)){//交换位置
                    minCount2++;
                    char tmp=q2.get(j);
                    q2.set(j,q2.get(j-1));
                    q2.set(j-1,tmp);
                }else{
                    break;
                }
            }
        }
        System.out.println(Math.min(minCount1,minCount2));
    }
}
