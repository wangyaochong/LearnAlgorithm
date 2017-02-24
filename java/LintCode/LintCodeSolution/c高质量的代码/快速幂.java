package LintCode.LintCodeSolution.c高质量的代码;

/**
 * Created by 【王耀冲】 on 【2017/2/24】 at 【17:04】.
 */

import org.junit.Test;

/**
 * 需要理解两点：
 * ①：(a*b)% n=(a%n)*(b%n)
 * ②：当b为偶数a^b=a^(b/2)*a^(b/2)，当b为奇数，a^b=a*a^((b-1)/2)*a^((b-1)/2)
 */
public class 快速幂 {
    public int fastPower(int a, int b, int n) {
        return (int) (reduce(a,b,n)%b);
    }
    public long reduce(int a,int b,int n){
        if(n==0){
            return 1%b;
        }
        if(n==1){
            return a%b;
        }
        long tmp=reduce(a,b,n/2)%b;
        if((n&1)==1){//如果是奇数
            return (((a%b)*tmp)%b*tmp)%b;//因为是三个数连乘，有可能会溢出，所以对于前两项，所以需要拆开来算
        }
        else{//如果是偶数
            return (tmp*tmp)%b;
        }
    }
    @Test
    public void testFastPower(){
        System.out.println(fastPower(3,7,5));

    }
}
