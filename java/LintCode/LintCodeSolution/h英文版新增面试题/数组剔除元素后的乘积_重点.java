package LintCode.LintCodeSolution.h英文版新增面试题;

import java.util.ArrayList;

public class 数组剔除元素后的乘积_重点 {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result=new ArrayList<Long>();
        if(A.size()==0){
            return result;
        }
        if(A.size()==1){
            result.add(1l);
            return result;
        }
        //两个数组都是用当前mul[i]表示A[i-1]的对应方向的乘积
        long[]mulLeft=new long[A.size()];//记录左边的乘积
        long[]mulRight=new long[A.size()];//记录右边的乘积
        mulLeft[0]=1;
        for(int i=1;i<mulLeft.length;i++){
            mulLeft[i]=A.get(i-1)*mulLeft[i-1];
        }
        mulRight[A.size()-1]=1;
        for(int i=mulRight.length-2;i>=0;i--){
            mulRight[i]=A.get(i+1)*mulRight[i+1];
        }
        for(int i=0;i<A.size();i++){
            result.add(mulLeft[i]*mulRight[i]);
        }
        return result;
    }
}
