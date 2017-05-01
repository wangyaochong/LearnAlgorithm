package LeetCode.LeetCodeSolution;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by【王耀冲】on 【2017/4/30】 at 【14:43】.
 */
public class S_42_TrappingRainWater {
    public int trap(int[] height) {
        int len=height.length;
        int water=0;
        int maxLoc=0;
        int uncoverLoc=-1;
        int uncoverHeight=-1;
        int shouldMinus=0;
        for(int i=0;i<len;i++){
            if(height[i]!=0){
                if(height[maxLoc]<=height[i]){
                    maxLoc=i;//找到最高的高度，用于最后减去没有装下的部分
                }
                if(uncoverHeight==-1){//如果是-1，赋初值
                    uncoverHeight=height[i];
                    uncoverLoc=i;
                }else if(uncoverHeight>height[i]){//如果当前高度小，那么就减去该部分
                    shouldMinus+=height[i];
                }else if(uncoverHeight<=height[i]){//大于等于前面的
                    water+=(i-uncoverLoc-1)*uncoverHeight-shouldMinus;
                    uncoverHeight=height[i];
                    uncoverLoc=i;
                    shouldMinus=0;
                }
            }
        }
        if(len!=0){
            for(int i=1;i<= height[maxLoc];i++){
                for(int loc=len-1;loc>=0;loc--){
                    if(height[loc]>=i){
                        shouldMinus+=(len-loc-1);
                        break;
                    }
                }
            }
            int processSize=(len-maxLoc-1)*height[maxLoc];
            water+=processSize-shouldMinus;
        }
        return water;
    }
    @Test
    public void test(){
//        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{2,0,2}));
    }
}
