package LeetCode.LeetCodeSolution;

import org.junit.Test;

import java.util.*;

/**
 * Created by【王耀冲】on 【2017/5/20】 at 【21:14】.
 */
public class S_49_GroupAnagrams {
    @Test
    public void test(){
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> resultMap=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String flag=new String(chars);
            if(!resultMap.containsKey(flag)) {
                resultMap.put(flag, new ArrayList<>());
            }
            resultMap.get(flag).add(strs[i]);
        }
        return new ArrayList<>(resultMap.values());
    }
}
