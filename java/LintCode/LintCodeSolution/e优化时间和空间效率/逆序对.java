package LintCode.LintCodeSolution.e优化时间和空间效率;

public class 逆序对 {
    public long reversePairs(int[] A) {
        // Write your code here
        int reversePairesNum=0;
        for(int i=1;i<A.length;i++){
            for(int j=0;j<i;j++){
                if(A[i]-A[j]<0){
                    reversePairesNum++;
                }
            }
        }
        return reversePairesNum;
    }
}
