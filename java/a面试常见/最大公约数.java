package a面试常见;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by【王耀冲】on 【2017/5/30】 at 【21:36】.
 */
public class 最大公约数 {
    @Test
    public void test(){
        System.out.println(findGCD(1,12));
    }
    public int findGCD(int a,int b){
        int mod=a%b;
        while(mod!=0){
            a=b;
            b=mod;
            mod=a%b;
        }
        return b;
    }
}
