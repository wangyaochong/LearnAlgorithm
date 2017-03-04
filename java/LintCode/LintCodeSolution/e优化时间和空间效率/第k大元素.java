package LintCode.LintCodeSolution.e优化时间和空间效率;

import java.util.ArrayList;
import java.util.Collections;

public class 第k大元素 {
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        return list.get(nums.length- k);
    }
}
