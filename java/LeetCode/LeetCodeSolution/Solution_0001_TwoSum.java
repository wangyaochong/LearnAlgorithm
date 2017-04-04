package LeetCode.LeetCodeSolution;

import Util.UtilDisplay;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
public class Solution_0001_TwoSum {
    //#1
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tmp=new HashMap<Integer, Integer>();
        Integer index;
        for(int i=0;i<nums.length;i++){
            int i1 = target - nums[i];
            index=tmp.get(i1);
            if(index==null){
                tmp.put(nums[i],i);
//                tmp.put(i,nums[i]);//注意，这种调用方式是错误的
                //map.get()是根据key获取value，所以应该以值为key，获取下标为value
            }else{
                return new int[]{index,i};
            }
        }
        return new int[]{1,1};
    }
    @Test
    public void testTwoSum(){
        int[] ints1 = {1, 2, 3, 4};
        int[] ints = twoSum(ints1, 4);
        UtilDisplay.display(ints);
    }
}
