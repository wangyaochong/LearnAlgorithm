package 通用算法.排序.practice;
import java.util.Scanner;
public class 小石头的存钱罐 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        int opCount=Integer.parseInt(s);
        int caseIndex=1;
        while(opCount>0){
            String s1 = scanner.nextLine();
            int i = Integer.parseInt(s1);
            count(0,i);
            System.out.println("Case #"+caseIndex+": "+count);
            count=0;
            caseIndex++;
            opCount--;
        }
    }
    public static int count=0;
    public static void count(int coinCount,int leftCount){
        if(leftCount==0&&coinCount==0){
            count++;
            return ;
        }
        if(leftCount==0){
            return ;
        }
        if(coinCount>0){
            count(coinCount-1,leftCount-1);
        }
        count(coinCount+1,leftCount-1);
    }
}
