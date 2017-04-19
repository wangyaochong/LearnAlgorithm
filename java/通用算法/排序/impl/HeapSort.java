package 通用算法.排序.impl;

import Util.UtilArray;
import Util.UtilDisplay;
import org.junit.Test;
import 通用算法.排序.ISort;
import 通用算法.排序.ITestSort;
import 通用算法.排序.structure.Heap;

import java.util.ArrayList;

/**
 * Created by【王耀冲】on 【2017/4/2】 at 【14:39】.
 */
public class HeapSort implements ISort,ITestSort{

    @Test
    public void testSort() {
        int[] input=new int[]{22,3,2,6,7,23,35,69};
        sort(input);
        System.out.println();
        sortAsc(input);

    }

    public void sort(int[] input) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=0;i<input.length;i++){
            arrayList.add(input[i]);
        }
        Heap.initMinHeap(arrayList);//先初始化为最小堆
        int count=arrayList.size()-1;
        while(count>1){
            UtilArray.swap(arrayList,0,count);
            Heap.sinkMax(arrayList,0,count-1);
            count--;
        }
        UtilDisplay.display(arrayList);
    }
    public void sortAsc(int[] input){
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=0;i<input.length;i++){
            arrayList.add(input[i]);
        }
        Heap.initMaxHeap(arrayList);//先初始化为最小堆
        int count=arrayList.size()-1;
        int orderCount=0;
        while(count>1){
            UtilArray.swap(arrayList,0,count);
            Heap.sinkMin(arrayList,0,count-1);
            count--;
            orderCount++;
        }
        UtilDisplay.display(arrayList);
        System.out.println("有序个数"+orderCount);
    }
}
