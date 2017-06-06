package LeetCode.LeetCodeSolution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by【王耀冲】on 【2017/5/31】 at 【0:02】.
 */
public class S_50_Pow_x_n {
    @Test
    public void test(){
        System.out.println(myPow(1.001,2048));
    }
    public double myPow(double x, int n) {
        if(n>=0){
            return pow(x,n);
        }else{
            return 1/pow(x,-n);
        }
    }
    Map<Integer,Double> cache=new HashMap<>();
    public double pow(double x, int n){
        Double aDouble = cache.get(n);
        if(aDouble!=null){
            return aDouble;
        }
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if((n&1)==1){
            cache.put(n,pow(x,n/2)*pow(x,n/2)*x);
        }else{
            cache.put(n,pow(x,n/2)*pow(x,n/2));
        }
        return cache.get(n);
    }
}
