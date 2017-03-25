package 自写代码;

import org.junit.Test;

public class 最大公约数 {
    @Test
    public void testGCD(){
        System.out.println(getGCD(12,8));
        System.out.println(zhanzhuanxiangchu(12,8));
        System.out.println(zhanzhuanxiangchu(8,12));
    }
    public int getGCD(int a,int b){
        int min =Math.min(a,b);
        int result=min;
        while(result!=1){
            if(a%result==0&&b%result==0){
                return result;
            }
            result--;
        }
        return result;
    }
    //使用辗转相除求最大公约数，最小公倍数等于两数相乘除以最大公约数
    public int zhanzhuanxiangchu(int a,int b){
        int tmp=a%b;
        while(tmp!=0){
            a=b;
            b=tmp;
            tmp=a%b;
        }
        return b;
    }
}
