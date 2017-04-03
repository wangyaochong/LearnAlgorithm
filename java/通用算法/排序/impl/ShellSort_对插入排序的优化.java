package 通用算法.排序.impl;

import Util.UtilDisplay;
import org.junit.Test;
import 通用算法.排序.ISort;
import 通用算法.排序.ITestSort;
import 通用算法.排序.tool.Counter;

public class ShellSort_对插入排序的优化 implements ISort,ITestSort {


    public void sort(int[] input) {
        int k=input.length/2;
        while(k>0){//希尔排序的内层就是一个步长为k的插入排序
            for(int i=k;i<input.length;i++){
                int j=i-k;
                int flag=input[i];
                while(j>=0&&flag<input[j]){
                    Counter.AddOne();
                    input[j+k]=input[j];
                    j=j-k;
                }
                input[j+k]=flag;
            }
            k=k/2;
        }
        Counter.Display();
        UtilDisplay.display(input);
    }
    @Test
    public void testSort() {
        sort(input.clone());
    }
}
