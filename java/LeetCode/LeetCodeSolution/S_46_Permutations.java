package LeetCode.LeetCodeSolution;

import Util.UtilDisplay;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by【王耀冲】on 【2017/5/1】 at 【9:03】.
 */
public class S_46_Permutations {
    @Test
    public void test(){
        List<List<Integer>> permute = permute(new int[]{1, 2, 3,4,5,6});

        S_46_Permutations_final.checkInvert(permute);

        int target=15;
        int okCount=0;
        for (List<Integer> integers : permute) {
            int invertCount=0;
            for(int i=0;i<integers.size();i++){
                for(int j=0;j<i;j++){
                    if(integers.get(i)<integers.get(j)){
                        invertCount++;
                        System.out.println(integers.get(i)+"小于"+integers.get(j));
                    }
                }
            }
            if(invertCount==target){
                okCount++;
            }
        }
        System.out.println("ok:"+okCount);


//        for (List<Integer> integers : permute) {
//            for (Integer integer : integers) {
//                System.out.print(integer+" ");
//            }
//            System.out.println();
//        }
    }
    @Test
    public void testClone(){
        ArrayList<Integer> init=new ArrayList<>();
        init.add(1);
        init.add(2);
        ArrayList<Integer >clone = (ArrayList<Integer>) init.clone();
        UtilDisplay.display(clone);
    }
    public List<List<Integer>> permute(int[] nums) {
        getResult(nums,new ArrayList<>());
        return result;
    }
    public void getResult(int[] nums,ArrayList<Integer> path){
        int len=nums.length;
        if(path.size()==len){
            result.add((List<Integer>) path.clone());
        }
        Integer num;
        for(int i=0;i<len;i++){
            if(visitedLoc[i]!=0)continue;
            visitedLoc[i]=1;
            num=nums[i];
            path.add(num);
            getResult(nums,path);
            visitedLoc[i]=0;
            path.remove(num);
        }
    }
    byte []visitedLoc=new byte[30];
    List<List<Integer>> result=new ArrayList<>();
}
