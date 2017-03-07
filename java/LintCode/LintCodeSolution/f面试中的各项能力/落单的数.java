package LintCode.LintCodeSolution.f面试中的各项能力;

public class 落单的数 {
    public int singleNumber(int[] A) {
        // Write your code here
        int flag=0;
        for(int i=0;i<A.length;i++){
            flag=flag^A[i];
        }
        return flag;
    }
}
