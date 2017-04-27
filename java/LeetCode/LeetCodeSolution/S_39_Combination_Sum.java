package LeetCode.LeetCodeSolution;

import Util.UtilDisplay;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by【王耀冲】on 【2017/4/27】 at 【10:57】.
 */
public class S_39_Combination_Sum {
    @Test
    public void test(){
        List<List<Integer>> lists = combinationSum(new int[]{2,3,6,7}, 7);
        UtilDisplay.display(lists);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getResult(candidates,0,0,target);
        return result;
    }
    List<Integer> record=new ArrayList<>();
    List<List<Integer>>result=new ArrayList<>();
    public void getResult(int[] candidates,int currentLoc,int currentSum,int targetSum){
        if(currentSum==targetSum){
            result.add(new ArrayList<Integer>(record));
            return ;
        }
        for(int i=currentLoc;i<candidates.length;i++){
            record.add(candidates[i]);
            if(currentSum+candidates[i]<=targetSum){
                getResult(candidates,i,currentSum+candidates[i],targetSum);
            }
            record.remove(record.size()-1);
        }
    }
}
