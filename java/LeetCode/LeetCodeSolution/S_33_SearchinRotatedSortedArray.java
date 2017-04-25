package LeetCode.LeetCodeSolution;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/24】 at 【17:18】.
 */
public class S_33_SearchinRotatedSortedArray {
    @Test
    public void testGetMinLoc(){
//        System.out.println(getMinLoc(new int[]{1,2,3,5,6}));
//        System.out.println(getMinLoc(new int[]{1}));
//        System.out.println(getMinLoc(new int[]{3,4,5}));
//        System.out.println(getMinLoc(new int[]{4,5,1,2,3}));
//        System.out.println(getMinLoc2(new int[]{1,2,3,5,6}));
//        System.out.println(getMinLoc2(new int[]{4,5,6,1,2,3}));
    }
    public int getMinLoc2(int []nums){
        int l=0;
        int h=nums.length-1;
        while(l<h){
            int mid=(l+h)/2;
            if(nums[l]<nums[mid]){//如果下边界比中间小，那么没有跨过边界，就往前走一步骤
                l=mid;
            }
            else if(nums[l]>=nums[mid]){//如果下边界比中间大，那么跨过边界
                h=mid-1;//这个地方有可能跨越下标
                if(h>=0&&nums[h]>nums[h+1]){//如果正好跨越边界
                    return h+1;
                }
            }
        }
        return 0;
    }
    public int getMinLoc(int[] nums){//原本的数组按照从小到大排列
        int l=0;
        int h=nums.length-1;
        while(l<h){
            int mid=(l+h)/2;
            if(nums[l]<=nums[mid]){//如果下边界比中间小，那么没有跨过边界，就往前走一步骤
                l=mid+1;//这个地方有可能跨越边界
                if(l-1>=0&& nums[l-1]>nums[l]){//如果正好跨越边界
                    return l;//l+1下标就是最小的
                }
            }
            else if(nums[l]>nums[mid]){//如果下边界比中间大，那么跨过边界
                h=mid;
            }
        }
        return 0;
    }
    public int search(int[] nums, int target) {
        int len=nums.length;
        int offset=getMinLoc(nums);
        System.out.println("offset:"+offset);

        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=(l+h)/2;
            int midOffset=(mid+offset)%len;
            if(nums[midOffset]<target){
                l=mid+1;
            }
            if(nums[midOffset]>target){
                h=mid-1;
            }
            if(nums[midOffset]==target){
                return midOffset;
            }
        }
        return -1;
    }
    @Test
    public void testSearch(){
//        System.out.println(search(new int[]{5,6,1,2,3,4},1));
        System.out.println(search(new int[]{3,4,5,6,1,2},2));
    }
}
