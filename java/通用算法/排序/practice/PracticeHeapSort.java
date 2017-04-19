package 通用算法.排序.practice;

import Util.UtilDisplay;
import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/6】 at 【13:14】.
 */
public class PracticeHeapSort {
    public void initMaxHeap(int[] input){
        for(int i=input.length/2;i>=0;i--){
            sinkMin(input,i,input.length-1);
        }
    }
    public void swap(int[]input,int i,int j){
        int tmp=input[i];
        input[i]=input[j];
        input[j]=tmp;
    }
    public void sinkMin(int[] input,int curLoc,int len){
        int maxChildLoc=curLoc*2+1;
        if(maxChildLoc>len){
            return;
        }
        if(maxChildLoc+1<=len&&input[maxChildLoc+1]>input[maxChildLoc]){
            maxChildLoc=maxChildLoc+1;
        }
        if(input[curLoc]<input[maxChildLoc]){
            swap(input,curLoc,maxChildLoc);
            sinkMin(input,maxChildLoc,len);
        }
    }
    public void heapSort(int[] input){
        int loc=input.length-1;
        while(loc>0){
            swap(input,0,loc);
            sinkMin(input,0,loc-1);
            loc--;
        }
    }
    @Test
    public void testMaxHeap(){
        int[] input=new int[]{1,233,34,332,66,200,22,33,45};
        initMaxHeap(input);
        heapSort(input);
        UtilDisplay.display(input);
    }

}
