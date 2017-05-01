package LeetCode.LeetCodeSolution;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/30】 at 【15:55】.
 */
public class S_43_MultiplyStrings {
    @Test
    public void testAdd(){
        System.out.println(add("123","1"));
    }
    @Test
    public void testMul(){
        System.out.println(multiply("9","9"));
    }
    public String multiplyChar(String num,char c,int zeroCount){
        StringBuilder sb=new StringBuilder();
        int carryIn=0;
        int lastResult;
        int tenMi=1;
        for(int i=num.length()-1;i>=0;i--) {
            lastResult = (num.charAt(i) - '0') * (c - '0') * tenMi + carryIn;
            carryIn = lastResult / 10;
            sb.append(lastResult%10);
        }
        if(carryIn!=0){
            sb.append(carryIn);
        }
        StringBuilder reverse = sb.reverse();
        while(zeroCount>0){
            reverse.append("0");
            zeroCount--;
        }
        return reverse.toString();
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        String result="0";
        int zeroCount=0;
        for(int j=num2.length()-1;j>=0;j--){
                String tmp=multiplyChar(num1,num2.charAt(j),zeroCount);
                result=add(tmp,result);
                zeroCount++;
        }
        return result;
    }
    public String add(String num1,String num2){
        int num1Loc=num1.length()-1;
        int num2Loc=num2.length()-1;
        int maxLen=num1.length()>num2.length()?num1.length():num2.length();
        int carryIn=0;
        int lastResult=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<maxLen;i++){
            char num1Char='0';
            char num2Char='0';
            if(num1Loc-i>=0){
                num1Char=num1.charAt(num1Loc-i);
            }
            if(num2Loc-i>=0){
                num2Char=num2.charAt(num2Loc-i);
            }
            lastResult=num1Char-'0'+num2Char-'0'+carryIn;
            carryIn=lastResult/10;
            sb.append(lastResult%10);
        }
        if(carryIn!=0){
            sb.append(carryIn);
        }
        return sb.reverse().toString();
    }
}
