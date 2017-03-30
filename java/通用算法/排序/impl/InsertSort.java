package 通用算法.排序.impl;

import Util.UtilArray;
import Util.UtilDisplay;
import org.junit.Test;
import 通用算法.排序.ISort;
import 通用算法.排序.ITestSort;
import 通用算法.排序.tool.Counter;

public class InsertSort  implements ISort,ITestSort {
    public void sort(int[] input) {
        for(int i=1;i<input.length;i++){
            int j=i-1;
            int flag=input[i];
            while(j>=0&&flag<input[j]){//i下标的值正好是比前面的都大，比后面的都小
                Counter.AddOne();
                input[j+1]=input[j];//依次后移
                j--;
            }
            input[j+1]=flag;//更新应该插入的位置
        }
        Counter.Display();
        UtilDisplay.display(input);
    }

    @Test
    public void testSort() {
        sort(input.clone());
    }
}
