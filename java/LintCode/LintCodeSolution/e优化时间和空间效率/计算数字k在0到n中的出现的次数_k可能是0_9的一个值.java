package LintCode.LintCodeSolution.e优化时间和空间效率;

public class 计算数字k在0到n中的出现的次数_k可能是0_9的一个值 {
    public int digitCounts(int k, int n) {
        int count=0;
        for(int i=0;i<=n;i++){
            count+=getCount(i,k);
        }
        return count;
    }
    int getCount(int n,int target){
        int count=0;
        if(n==target&&target==0){
            return 1;
        }
        while(n!=0){
            if(n%10==target){
                count++;
            }
            n=n/10;
        }
        return count;
    }
}
