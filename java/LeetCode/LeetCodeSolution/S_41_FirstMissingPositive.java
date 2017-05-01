package LeetCode.LeetCodeSolution;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/28】 at 【11:58】.
 */
public class S_41_FirstMissingPositive {
    public void swap(int [] nums,int i,int j){
        int tmp=0;
        tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i]>0&&nums[i]-1<nums.length&&nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        int loc=0;
        int len=nums.length;
        while(loc<len&& nums[loc]==loc+1){
            loc++;
        }
        return loc+1;
    }
    @Test
    public void test(){
        System.out.println(firstMissingPositive(new int[]{1,2,2,3,4}));
    }
}
