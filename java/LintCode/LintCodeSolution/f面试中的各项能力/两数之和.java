package LintCode.LintCodeSolution.f面试中的各项能力;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            cache.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            Integer tmp = cache.get(target - numbers[i]);
            if (tmp != null) {
                return new int[]{i+1,tmp+1};
            }
            cache.put(numbers[i], i);
        }
        return null;
    }
}
