package LeetCode.LeetCodeSolution;

import org.junit.Test;

/**
 * Created by finup on 2017/7/4.
 */
public class S_53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int [] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=dp[i-1]>0?dp[i-1]+nums[i]: 0+nums[i];
            if(max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }
    @Test
    public void testMax(){
        int i = maxSubArray(new int[]{-1});
        System.out.println(i);
    }

}
