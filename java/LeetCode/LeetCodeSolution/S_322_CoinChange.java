package LeetCode.LeetCodeSolution;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/3】 at 【22:25】.
 */
public class S_322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        int [] dp=new int[amount+1];//dp[i]表示凑齐i的价值需要的最少硬币数
        for(int i=0;i<coins.length;i++){
            if(coins[i]<dp.length){
                dp[coins[i]]=1;
            }
        }
        for(int i=0;i<dp.length;i++){
            if(dp[i]!=1){
                dp[i]=Integer.MAX_VALUE-1;
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    dp[i]=Math.min( dp[i-coins[j]]+1,dp[i]);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE-1){
            return -1;
        }
        return dp[amount];
    }
    @Test
    public void testCoinChange(){
        System.out.println(coinChange(new int[]{2}, 3));
    }
}
