package LintCode.LintCodeSolution.i全部;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/3】 at 【22:55】.
 */
public class S_92_背包问题 {
    public int my(int m,int []A){
        int [] dp=new int[m+1];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<m;j++){
                if(dp[j]+A[i]<=m){
                    dp[j+1]=Math.max( dp[j+1], dp[j]+A[i]);
                }
            }
        }
        return dp[m];
    }
    public int backPack(int m, int[] A) {
        int[] dp = new int[m+1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j > 0; j--) {//逆序是因为01背包一个物品只能使用一次
                if (j >= A[i]) {
                    dp[j] = Math.max(dp[j], dp[j-A[i]] + A[i]);
                }
            }
        }
        return dp[m];
    }
    @Test
    public void testBackPack(){
        System.out.println(backPack(8, new int[]{2, 3, 5, 7}));
//        System.out.println(my(8, new int[]{2, 3, 5, 7}));
    }
}
