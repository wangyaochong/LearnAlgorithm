package 通用算法.排序.impl;

import Util.UtilArray;
import Util.UtilDisplay;
import org.junit.Test;
import 通用算法.排序.ISort;
import 通用算法.排序.ITestSort;

/**
 * Created by【王耀冲】on 【2017/4/2】 at 【10:26】.
 */
public class MergeSort implements ISort,ITestSort {
    @Test
    public void testSort() {
        int[] clone = input.clone();
        int[] result=new int[clone.length];
        merge(clone,0,clone.length-1,result);
        UtilDisplay.display(result);
    }

    public void sort(int[] input) {

    }
    public void merge(int[] input,int start,int end,int [] result){
        int mid=start+((end-start)>>1);
        if(start<end){
            merge(input,start,mid,result);
            merge(input,mid+1,end,result);
            mergeOnePart(input,start,mid,end,result);
        }
    }
    @Test
    public void testMergeOnePart(){
        int[] result=new int[100];
        mergeOnePart(new int[]{4,1,2,3,4},0,0,4,result);
        UtilDisplay.display(result);
    }
    public void mergeOnePart(int[] input,int leftStart,int leftEnd,int rightEnd,int[] result){
        int initStart=leftStart;
        int initEnd=rightEnd;
        int rLoc=leftStart;
        int rightStart=leftEnd+1;
        while(rLoc<=rightEnd){
            if(rightStart>rightEnd||(leftStart<=leftEnd&&input[leftStart]<input[rightStart])){
                result[rLoc]=input[leftStart];
                leftStart++;
            }else{
                result[rLoc]=input[rightStart];
                rightStart++;
            }
            rLoc++;
        }
        for(int i=initStart;i<=initEnd;i++){//更新input输入归并后的值
            input[i]=result[i];
        }
    }

}
