package 通用算法.排序.impl;

import Util.UtilArray;
import Util.UtilDisplay;
import org.junit.Test;
import 通用算法.排序.ISort;
import 通用算法.排序.ITestSort;
import 通用算法.排序.tool.Counter;

public class BubbleSort  implements ISort,ITestSort {
    public void sort(int[] input) {
        for(int i=0;i<input.length;i++){
            boolean needSort=true;
            for(int j=i;needSort&&j>=1;j--){
                Counter.AddOne();
                if(input[j-1]>input[j]){//从小到大排列
                    UtilArray.swap(input,j,j-1);
                }else{
                    needSort=!needSort;
                }
            }
        }
        Counter.Display();
        UtilDisplay.display(input);
    }

    @Test
    public void testSort() {
        sort(input.clone());
    }
}
