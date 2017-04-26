package LeetCode.LeetCodeSolution;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/26】 at 【14:55】.
 */
public class S_35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo=0,hi=nums.length-1,mid;
        while(lo<=hi){
            mid=lo+((hi-lo)>>1);
            if(target>nums[mid]){
                lo=mid+1;
            }else if(target<nums[mid]){
                hi=mid-1;
            }else{
                return mid;
            }
        }
        return lo;
    }
    @Test
    public void test(){
        System.out.println(searchInsert(new int[]{1,2,3,5},6));
    }
}
