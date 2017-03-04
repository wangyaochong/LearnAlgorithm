package LintCode.LintCodeSolution.e优化时间和空间效率;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 主元素 {
    Map<Integer,Integer> numCount=new HashMap<Integer, Integer>();
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        for (Integer num : nums) {
            if (numCount.get(num)==null) {
                numCount.put(num,1);
            }else{
                numCount.put(num, numCount.get(num)+1);
            }
            if(numCount.get(num)>nums.size()/2){
                return num;
            }
        }
        return 0;
    }
}
