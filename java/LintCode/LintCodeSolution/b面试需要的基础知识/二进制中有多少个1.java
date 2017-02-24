package LintCode.LintCodeSolution.b面试需要的基础知识;

/**
 * Created by 【王耀冲】 on 【2017/2/8】 at 【15:25】.
 */

import org.junit.Test;

/**
 * 计算在一个 32 位的整数的二进制表式中有多少个 1.
 */
public class 二进制中有多少个1 {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        int oneCount=0;
        int flag=1;
        while(flag!=0){
            oneCount+=(num&flag)==0?0:1;
            //因为对于负数num，右移会导致高位填充1，
            // 所以会产生死循环，因此使用标志位左移的方法找1的个数
            flag=flag<<1;
        }
        return oneCount;
    }
    @Test
    public void testCountOnes(){
        int i = countOnes(-1);
        System.out.println(i);
    }
}
