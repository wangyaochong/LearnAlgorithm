package LintCode.LintCodeSolution.e优化时间和空间效率;

public class 最大子数组 {
    public int maxSubArray(int[] nums) {
        int [] maxSubArr=new int[nums.length+1];//需要在开头加上一个0，因为有可能子数组是从0开始一直到末尾，也就是子数组不减去另一个子数组
        //用一个数组记录从[0-i)的子数组的和，
        // 那么[i-j)的子数组的和就等于[0-j)的子数组的和减去[0-i)的子数组的和
        maxSubArr[1]=nums[0];
        for(int i=1;i<nums.length;i++){
            maxSubArr[i+1]=nums[i]+maxSubArr[i];
        }
        int maxSub=Integer.MIN_VALUE;
        for(int i=1;i<nums.length+1;i++){
            for(int j=0;j<i;j++){
                if(maxSubArr[i]-maxSubArr[j]>maxSub){
                    maxSub=maxSubArr[i]-maxSubArr[j];
                }
            }
        }
        return maxSub;
    }
}
