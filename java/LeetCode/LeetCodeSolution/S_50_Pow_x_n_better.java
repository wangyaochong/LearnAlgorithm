package LeetCode.LeetCodeSolution;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/5/31】 at 【0:20】.
 */
public class S_50_Pow_x_n_better {
    @Test
    public void test(){
        System.out.println(myPow(2,-2147483648));
    }
    double myPow(double x, long n) {
        if(n==0) return 1;
        if(n<0) {
            n = -n;
            x = 1/x;
        }
        double ans = 1;
        while(n>0){
            if((n&1)==1) ans *= x;
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
