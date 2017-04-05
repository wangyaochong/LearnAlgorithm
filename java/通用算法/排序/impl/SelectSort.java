package 通用算法.排序.impl;

import Util.UtilArray;
import Util.UtilDisplay;
import org.junit.Test;
import 通用算法.排序.ISort;
import 通用算法.排序.ITestSort;

/**
 * Created by【王耀冲】on 【2017/4/2】 at 【17:08】.
 */
public class SelectSort implements ISort,ITestSort{

    @Test
    public void testSort() {
        sort(input.clone());
    }

    public void sort(int[] input) {
        UtilDisplay.display(input);
        System.out.println("开始");
        for(int i=0;i<input.length;i++){
            int minLoc=i;
            for(int j=i;j<input.length;j++){
                if(input[minLoc]>input[j]){
                    minLoc=j;
                }
            }
            UtilArray.swap(input,minLoc,i);
            UtilDisplay.display(input);
            System.out.println("");
        }
        UtilDisplay.display(input);
    }
}
