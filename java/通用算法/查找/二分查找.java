package 通用算法.查找;

import org.junit.Test;

/**
 * Created by 【王耀冲】 on 【2017/2/9】 at 【13:39】.
 */
public class 二分查找 {
    public int binarySearch(int [] nums,int target){
        int low=0;
        int max=nums.length-1;

        //这个地方需要注意，因为max-low有可能只相差1个数，那么除以二永远是0，
        // 则无法前进，因此需mid=low+(max-low+1)>>1
        int mid=low+((max-low+1)>>1);


        while(low<=max){
            if(nums[mid]<target){
                low=mid+1;
            }else if(nums[mid]>target){
                max=mid-1;
            }else{//如果相等，则返回
                return mid;
            }
            mid=low+((max-low)>>1);
        }
        return -1;
    }
    @Test
    public void testBinarySearch(){
        int [] nums=new int[]{-1,0,1,2,5};
        System.out.println(binarySearch(nums,1));
        System.out.println(binarySearch(nums,0));
    }
}
