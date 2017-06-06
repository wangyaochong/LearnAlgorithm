package LeetCode.LeetCodeSolution;
import Util.UtilDisplay;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/5/1】 at 【9:03】.
 */
public class S_46_Permutations_final {

    @Test
    public void testInsert(){
        ArrayList<Integer> a=new ArrayList<>();
        a.add(0,1);
        UtilDisplay.display(a);
    }
    public static void checkInvert(List<List<Integer>>result){
        for (List<Integer> arrayList : result) {
            int invertCount=0;
            for(int i=0;i<arrayList.size();i++){
                for(int j=0;j<i;j++){
                    if(arrayList.get(i)<arrayList.get(j)){
                        invertCount++;
                        System.out.println(arrayList.get(i)+"小于"+arrayList.get(j));
                    }
                }
            }
//            System.out.println(invertCount);
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(solve(n, k));
    }
    public static int solve(int n, int k) {
        visitedLoc=new byte[n];
        intResult=0;
        getResult(n ,new ArrayList<Integer>(),0,0,k);
        return intResult%10000;
    }
    public static void getResult(int numInput , ArrayList<Integer> orderPath,int currentLen,int currentInvertSize,int
            targetInvertSize ){
        if(currentLen==numInput&&currentInvertSize==targetInvertSize){
            intResult++;
            return ;
        }
        for(int i=numInput-1;i>=0;i--){
            if(visitedLoc[i]!=0)continue;
            visitedLoc[i]=1;
            currentLen++;
            int invertCount=0;
            int orderPathSize=orderPath.size();
            int start=0;
            int end=orderPathSize-1;
            if(orderPathSize==0){
                orderPath.add(i);
            }else{
                while(start<=end){
                    int mid=(start+end)/2;
                    if(i>orderPath.get(mid)){
                        start=mid+1;
                    }else if(i<orderPath.get(mid)){
                        end=mid-1;
                    }
                }
                orderPath.add(start,i);
                invertCount=orderPathSize-start;
            }
            if(currentInvertSize+invertCount<=targetInvertSize){
                getResult(numInput, orderPath,currentLen,currentInvertSize+invertCount,targetInvertSize);
            } else{
                visitedLoc[i]=0;
                orderPath.remove(start);
                currentLen--;
                break;
            }
            visitedLoc[i]=0;
            orderPath.remove(start);
            currentLen--;
        }
    }
    static  byte []visitedLoc=null;
    static  int intResult=0;
}
