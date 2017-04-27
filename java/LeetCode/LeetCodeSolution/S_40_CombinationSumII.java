package LeetCode.LeetCodeSolution;

import Util.UtilDisplay;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by【王耀冲】on 【2017/4/27】 at 【11:09】.
 */
public class S_40_CombinationSumII {
    @Test
    public void test(){
        List<List<Integer>> lists = combinationSum2(new int[]{3,1,3,5,1,1}, 8);
        UtilDisplay.display(lists);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        getResult(candidates,0,target);
        return result;
    }
    List<Integer> record=new ArrayList<>();
    List<List<Integer>>result=new ArrayList<>();
    public void getResult(int[] candidates,int currentLoc,int currentLeft){
        if(currentLeft==0){
            result.add(new ArrayList<>(record));
            return ;
        }
        for(int i=currentLoc;i<candidates.length;i++){
            if(i>currentLoc&&candidates[i]==candidates[i-1])continue;
            if (currentLeft-candidates[i]>=0){
                record.add(candidates[i]);
                getResult(candidates,i+1,currentLeft-candidates[i]);
                record.remove(record.size()-1);
            }
        }
    }
}
