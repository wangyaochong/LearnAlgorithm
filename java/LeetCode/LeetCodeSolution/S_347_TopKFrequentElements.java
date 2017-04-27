package LeetCode.LeetCodeSolution;

import Util.UtilDisplay;
import org.junit.Test;
import java.util.*;
/**
 * Created by【王耀冲】on 【2017/4/26】 at 【21:37】.
 */
public class S_347_TopKFrequentElements {
    public static int totalSize = 0;
    public void tryAdd(ArrayList<Map.Entry<Integer, Integer>> input, Map.Entry<Integer, Integer> add) {
        if (input.size() < totalSize) {
            int tmp = input.size();
            while (tmp != 0 && add.getValue() < input.get((tmp - 1) / 2).getValue()) {//因为是要获取出现最多的，所以要用最小堆
                if (tmp == input.size()) {
                    input.add(input.get((tmp - 1) / 2));
                } else {
                    input.set(tmp, input.get((tmp - 1) / 2));
                }
                tmp = (tmp - 1) / 2;
            }
            if (tmp == input.size()) {
                input.add(add);
            } else {
                input.set(tmp, add);
            }
            return;
        }
        if (add.getValue() < input.get(0).getValue()) {//出现次数太少
            return;
        } else {
            input.set(0, add);
            sinkMax(input, 0);
        }
    }

    public <T> void swap(ArrayList<T> input, int i, int j) {
        T tmp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, tmp);
    }

    public void sinkMax(ArrayList<Map.Entry<Integer, Integer>> input, int loc) {
        int minLoc = loc * 2 + 1;//要构建最小堆
        if (minLoc >= input.size()) return;
        if (minLoc + 1 < input.size() && input.get(minLoc).getValue() > input.get(minLoc + 1).getValue()) {
            minLoc = minLoc + 1;
        }
        if (input.get(loc).getValue() > input.get(minLoc).getValue()) {
            swap(input, loc, minLoc);
            sinkMax(input, minLoc);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        totalSize = k;
        TreeMap<Integer, Integer> record = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = record.get(nums[i]);
            if (integer == null) {
                record.put(nums[i], 1);
            } else {
                record.put(nums[i], integer + 1);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> resultTmp = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : record.entrySet()) {
            tryAdd(resultTmp, integerIntegerEntry);
        }
        ArrayList<Map.Entry<Integer, Integer>> pre = new ArrayList<>();
        pre.addAll(resultTmp);
        pre.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pre.get(i).getKey());
        }
        return result;
    }

    @Test
    public void test() {
        List<Integer> integers = topKFrequent(new int[]{1, 2}, 2);
        UtilDisplay.display(integers);
    }
//    @Test
//    public void testInteger(){
//        Integer a=1;
//        Integer b=a;
//        a++;
//        System.out.println(a);
//        System.out.println(b);
//    }
}
