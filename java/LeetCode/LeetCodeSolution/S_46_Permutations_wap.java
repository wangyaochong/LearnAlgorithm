package LeetCode.LeetCodeSolution;

import Util.UtilDisplay;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by【王耀冲】on 【2017/5/1】 at 【9:03】.
 */
public class S_46_Permutations_wap {
    @Test
    public void test(){
        List<List<Integer>> permute = permute(new int[]{1, 2, 3,4});
        for (List<Integer> integers : permute) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        getResult(nums,new ArrayList<>(),new ArrayList<>(),2,Integer.MIN_VALUE);
        return result;
    }
    public void getResult(int[] nums,ArrayList<Integer> path,ArrayList<Integer> invertPath,int targetInvertSize,int seqMax){
        int len=nums.length;
        if(path.size()==len&&targetInvertSize==invertPath.size()){
            result.add((List<Integer>) path.clone());
        }
        Integer num;
        for(int i=0;i<len;i++){
            if(visitedLoc[i]!=0)continue;
            visitedLoc[i]=1;
            num=nums[i];
            path.add(num);
            if(invertPath.size()==0){
                invertPath.add(num);
                getResult(nums,path,invertPath,targetInvertSize,seqMax);
                invertPath.remove(invertPath.size()-1);
            }else{
                if(invertPath.get(invertPath.size()-1)<num&&seqMax<num){
                    getResult(nums,path,invertPath,targetInvertSize,num);
                }else{
                    invertPath.add(num);
                    getResult(nums,path,invertPath,targetInvertSize,seqMax);
                    invertPath.remove(invertPath.size()-1);
                }
            }
            visitedLoc[i]=0;
            path.remove(num);
        }
    }
    byte []visitedLoc=new byte[30];
    List<List<Integer>> result=new ArrayList<>();
}
