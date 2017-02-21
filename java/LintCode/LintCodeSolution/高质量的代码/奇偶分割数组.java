package LintCode.LintCodeSolution.高质量的代码;

/**
 * Created by 【王耀冲】 on 【2017/2/21】 at 【17:41】.
 * 分割一个整数数组，使得奇数在前偶数在后。
 */
public class 奇偶分割数组 {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        if(nums==null||nums.length==0){
            return ;
        }
        int oddLoc=0;
        int evenLoc=nums.length-1;
        while(oddLoc<evenLoc){
            while(nums[oddLoc]%2==1){
                oddLoc++;
            }
            while(nums[evenLoc]%2==0){
                evenLoc--;
            }
            if(oddLoc<evenLoc){
                swap(nums,oddLoc,evenLoc);
            }
        }
    }

    public void swap(int[] nums,int aLoc,int bLoc){
        int c=nums[aLoc];
        nums[aLoc]=nums[bLoc];
        nums[bLoc]=c;
    }


}
