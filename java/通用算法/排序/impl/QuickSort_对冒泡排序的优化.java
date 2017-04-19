package 通用算法.排序.impl;

import Util.UtilArray;
import Util.UtilDisplay;
import org.junit.Test;
import 通用算法.排序.ISort;
import 通用算法.排序.ITestSort;

public class QuickSort_对冒泡排序的优化 implements ISort,ITestSort {


    public void sort(int[]input ,int i,int j){
        if(i>=j)return;
        int div=sortCore(input,i,j);
        sort(input,i,div-1);
        sort(input,div+1,j);
    }
    public int sortCore(int[] input,int i,int j){
        int flag=input[i];
        while(i<j){
            while(i<j&&input[j]>=flag){
                j--;
            }
            input[i]=input[j];
            while(i<j&&input[i]<=flag){
                i++;
            }
            input[j]=input[i];
        }
        input[i]=flag;
        return i;
    }

    private static void rec_quickSort(int[] a, int start, int end) {
        int index = 0;
        if(start < end) {
            index = partition2(a,start,end);
            rec_quickSort(a,start,index-1);
            rec_quickSort(a,index+1,end);
        }
    }

    private static int partition2(int[] a, int start, int end) {

        int pivot = a[start];
        while(start < end) {
            while(start < end && a[end] >= pivot)
                end--;
            a[start] = a[end];
            while(start < end && a[start] <= pivot)
                start++;
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;
    }


    @Test
    public void testSort() {
        int[] clone = input.clone();
        sort(clone,0,clone.length-1);
        UtilDisplay.display(clone);
    }

    public void sort(int[] input) {

    }
}
