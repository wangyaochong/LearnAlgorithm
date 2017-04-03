package a面试常见;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/2】 at 【12:26】.
 */
public class 找出一个数的二进制有多少个1 {
    public int findOneNumber (int x){
        int count=0;
        while(x!=0){
            x=x&(x-1);
            count++;
        }
        return count;
    }
    @Test
    public void testFindOneNumber(){
        System.out.println(findOneNumber(1));
    }
}
