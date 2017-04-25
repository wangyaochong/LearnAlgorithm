package a面试常见;

import Util.UtilDisplay;

/**
 * Created by【王耀冲】on 【2017/4/20】 at 【20:39】.
 */
public class 求出多项式每项的系数 {
    public static void main(String[] args) {
        int[] polynomial=new int[]{1,2,3,4,3};
//        UtilDisplay.display(polynomial);
        Long bitsSum = bitsSum(polynomial);
        displayPolynomial(polynomial);
        System.out.println(sumFromPolynomial(polynomial,bitsSum+1));
        Long aLong = sumFromPolynomial(polynomial,bitsSum+1);
        while(!aLong.equals(0l)){
            System.out.println(aLong%(bitsSum+1));
            aLong=aLong/(bitsSum+1);
        }
    }
    public static Long bitsSum(int[] polynomial){
        Long sum=0l;
        for(int i=0;i<polynomial.length;i++){
            sum+=polynomial[i];
        }
        return sum;
    }
    public static Long sumFromPolynomial(int[] polynomial,Long mi){
        Long sum=0l;
        Long current=1l;
        for(int i=polynomial.length-1;i>=0;i--){
            sum+=polynomial[i]*current;
            current=current*mi;
        }
        return sum;
    }
    public static void displayPolynomial(int [] polynomial){
        int current=0;
        for(int i=polynomial.length-1;i>=0;i--){
            System.out.print(polynomial[i]);
            System.out.print("次方"+current);
            System.out.println();
            current++;
        }
    }
}
