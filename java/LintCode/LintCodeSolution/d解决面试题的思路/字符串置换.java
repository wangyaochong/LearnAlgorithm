package LintCode.LintCodeSolution.d解决面试题的思路;

/**
 * Created by 【王耀冲】 on 【2017/2/27】 at 【17:54】.
 */
public class 字符串置换 {
    public boolean stringPermutation(String A, String B) {
        if(A.length()!=B.length()){
            return false;
        }
        int [] chA=new int[500];
        int [] chB=new int[500];
        for(int i=0;i<A.length();i++){
            chA[A.charAt(i)]++;
            chB[B.charAt(i)]++;
        }
        for(int i=0;i<A.length();i++){
            if(chA[i]!=chB[i]){
                return false;
            }
        }
        return true;
    }
}
