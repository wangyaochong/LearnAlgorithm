package LintCode.LintCodeSolution.c高质量的代码;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 【王耀冲】 on 【2017/2/23】 at 【17:37】.
 */
public class 用递归的方法找到从1到最大的N位整数 {
    public List<Integer> numbersByRecursion(int n) {
        reduce(n,n);
        return result;
    }
    Integer [] nums={0,1,2,3,4,5,6,7,8,9};
    List<Integer> result=new ArrayList<Integer>();
    public void reduce(int n,int level){
        if(n==0){
            return ;
        }
        if(result.size()==0){
            for(int i=1;i<nums.length;i++){
                result.add(nums[i]);
            }
        }else{
            List<Integer> resultTmp=new ArrayList<Integer>();
            for(int i=getMi(level-n);i<result.size();i++){
                for(int j=0;j<nums.length;j++){
                    resultTmp.add(Integer.parseInt(result.get(i).toString()+nums[j].toString()));
                }
            }
            result.addAll(resultTmp);
        }
        reduce(n-1,level);
    }
    public int getMi(int i){
        int ri=1;
        i--;
        while(i>0){
            ri=ri*10;
            i--;
        }
        return ri-1;
    }
}
