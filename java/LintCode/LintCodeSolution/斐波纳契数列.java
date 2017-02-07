package LintCode.LintCodeSolution;

import org.junit.Test;

/**
 * Created by 【王耀冲】 on 【2017/2/7】 at 【14:51】.
 */
public class 斐波纳契数列 {
    /**
     * 查找斐波纳契数列中第 N 个数。

     所谓的斐波纳契数列是指：

     前2个数是 0 和 1 。
     第 i 个数是第 i-1 个数和第i-2 个数的和。
     斐波纳契数列的前10个数字是：

     0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
     */
    public int fibonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){//如果是第一个数，返回0，如果是第二个数，返回1
            return n-1;
        }
        int i=3;
        int [] a=new int[1000];
        a[1]=0;
        a[2]=1;
        while(i<=n){
            a[i]=a[i-1]+a[i-2];
            i++;
        }
        return a[i-1];
    }
    @Test
    public void testFibonacci(){

    }
}
