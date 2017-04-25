package LeetCode.LeetCodeSolution;

/**
 * Created by【王耀冲】on 【2017/4/25】 at 【12:30】.
 */
public class S_34_SearchforaRange {
    public int[] searchRange(int[] nums, int target) {//这个版本是顺序查找，所以复杂度是O（n）
        int start=-1;
        int end=-1;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                if(start==-1){
                    start=i;
                }
                end=i;
            }
        }
        return new int[]{start,end};
    }
    public int[] searchRange2(int[] nums, int target) {//这个版本利用二分，效率明显提高
        int lo=0;
        int hi=nums.length-1;
        int start=-1;
        int end=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(target>nums[mid]){
                lo=mid+1;
            }else if(target<nums[mid]){
                hi=mid-1;
            }else{
                start=end=mid;
                while(start>=0&&target==nums[start]){
                    start--;
                }
                start++;
                while(end<nums.length&&target==nums[end]){
                    end++;
                }
                end--;
                break;
            }
        }
        return new int[]{start,end};
    }
}
