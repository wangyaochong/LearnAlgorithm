package LintCode.LintCodeSolution.面试的流程;

/**
 * Created by 【王耀冲】 on 【2017/2/7】 at 【14:41】.
 */

import org.junit.Test;

import java.util.ArrayList;

/**
 * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
 如果这个数被3整除，打印fizz.
 如果这个数被5整除，打印buzz.
 如果这个数能同时被3和5整除，打印fizz buzz.
 */
public class Fizz_Buzz_问题 {
    public ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> fb=new ArrayList<String>();
        for(int i=1;i<=n;i++){
            String tmp="";
            if(i%3==0){
                tmp+="fizz";
            }
            if(i%5==0){
                if(tmp.equals("")){
                    tmp+="buzz";
                }else{
                    tmp+=" buzz";
                }
            }
            if(tmp.equals("")){
                fb.add(Integer.toString(i));
            }else{
                fb.add(tmp);
            }
        }
        return fb;
    }
    @Test
    public void testFizzBuzz(){

    }
}
