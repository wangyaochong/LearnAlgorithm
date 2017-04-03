package LintCode.LintCodeSolution.b面试需要的基础知识;

/**
 * Created by 【王耀冲】 on 【2017/2/8】 at 【17:35】.
 */

import org.junit.Test;

/**
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。

 你需要找到其中最小的元素。

 你可以假设数组中不存在重复的元素。
 */
public class 寻找旋转排序数组中的最小值 {
    public int findMinFaster(int[] nums){//34512，最小值是1
        int min=0;
        int max=nums.length;
        while(min<max){
            int mid=min+((max-min)>>1);
            if(nums[mid]>=  nums[min]){//如果mid的值大于等于min的值，最小值在后面
                if(mid+1< nums.length&&nums[min]>nums[mid+1]){//如果正好越界，那么边界值就是最小值
                    return nums[mid+1];
                }
                min=mid+1;
            }
            else if(nums[mid]<nums[min]){
                //如果mid的值小于min的值，最小值在前面，
                // 但是这个位置是max等于mid，因为mid有可能就是最小值，所以max等于mid；
                max=mid;
            }
        }
        if(min>=nums.length){
            min=0;
        }
        return nums[min];
    }
    public int findMin(int[] nums) {
        // write your code here
        int min=0;
        int max=nums.length-1;
        int mid=min+(max-min+1)>>1;
        while(min<max){
            if(nums[min]<nums[mid]){//如果左边小于中间，那么左边移向中间
                min=mid+1;
                if(min<nums.length&&nums[min]<nums[min-1]){//如果移动一下，刚好跨越边界，那么此处是最小值
                    return nums[min];
                }
                mid=min+((max-min+1)>>1);
            }else if(nums[min]>nums[mid]){//如果左边大于中间，则说明最小值在左边和中间之间
                max=mid-1;
                if(max>=0&&nums[max]>nums[max+1]){//如果跨越边界
                    return nums[max+1];
                }
                mid=min+((max-min+1)>>1);
            }else{
                return nums[mid];
            }
        }
        return nums[0];//如果没有跨越过边界，则说明最小值是第一个
    }
    @Test
    public void testFindMin(){
//        int i=(4-3+1)>>1;
//        System.out.println(i);
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMinFaster(new int[]{4,5,6,7,0,1,2}));
    }
}
