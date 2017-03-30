package 通用算法.排序.impl;

import Util.UtilArray;
import Util.UtilDisplay;
import org.junit.Test;
import 通用算法.排序.ISort;
import 通用算法.排序.ITestSort;

public class QuickSort_对冒泡排序的优化 implements ISort,ITestSort {

    public void sort(int[] input) {
        partition(input,0,input.length-1);
        UtilDisplay.display(input);
    }
    public void partition(int[]input ,int i,int j){
        int mid=i+(j-i+1)/2;
        if(i>=j)return;
        sortCore(input,i,j);
        partition(input,i+1,mid);
        partition(input,mid,j-1);
    }
    public void sortCore(int[] input,int i,int j){
        int flag=i;
        i=i+1;
        while(i<j){
            while(i<j&& input[j]>input[flag])j--;
            UtilArray.swap(input,flag,j);
            flag=j;
            while(i<j&&input[i]<input[flag])i++;
            UtilArray.swap(input,flag,i);
            flag=i;
        }
    }
    @Test
    public void testSort() {
        sort(input.clone());
    }
}
