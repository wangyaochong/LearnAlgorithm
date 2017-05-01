package LeetCode.LeetCodeSolution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by【王耀冲】on 【2017/5/1】 at 【10:29】.
 */
public class S_47_PermutationsII {
    @Test
    public void test(){
        List<List<Integer>> lists = permuteUnique(new int[]{1,1,2});
        for (List<Integer> integers : lists) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        getResult(nums,new ArrayList<>(),used);
        return result;
    }
    public void getResult( int[]  nums,ArrayList<Integer> path,boolean[] used){
        int len=nums.length;
        if(path.size()==len){
            result.add((List<Integer>) path.clone());
        }
        for(int i=0;i<len;i++){
            if(used[i])continue;
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1])continue;
            used[i]=true;
            path.add(nums[i]);
            getResult(nums,path,used);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }
    List<List<Integer>> result=new ArrayList<>();
}
