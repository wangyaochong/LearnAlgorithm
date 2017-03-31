package 通用算法.动态规划;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/1】 at 【1:20】.
 */
public class Dp {
    @Test
    public  void testLCS(){
        System.out.println(testLCS("8123255524","922322214"));
    }

    public int testLCS(String a,String b){
        int[][] result=new int[a.length()+1][b.length()+1];
        for(int i=0;i<a.length();i++){
            for(int j=0;j<b.length();j++){
                if (a.charAt(i) == b.charAt(j)) {//result[i][j]表示0-i和0-j的最长公共序列
                    result[i+1][j+1]=result[i][j]+1;
                }else{//当前是求非连续的最长子序列，如果去掉else分之，就是求连续的最长字串
                    result[i+1][j+1]=Math.max(result[i+1][j],result[i][j+1]);
                }
            }
        }
        int r=0;
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                if(r<result[i][j]){
                    r=result[i][j];
                }
            }
        }
        return r;
    }
    public int testLIS(int[] input){
        int[] result=new int[input.length];
        //这里假设result[i]是
        for(int i=1;i<input.length;i++){
            for(int j=0;j<i;j++){
                if(input[i]>=input[j]&&result[j]+1>result[i]){//只要当前数字比前一个大，那么最长子序列长度应该+1
                    result[i]=result[j]+1;
                }
            }
        }
        int r=0;
        for(int i=0;i<result.length;i++){
            if(r<result[i]){
                r=result[i];
            }
        }
        return r+1;
    }
    @Test
    public void testLIS(){
        int[] input=new int[]{1,3,3234,5,2,23,5,6};
        System.out.println(testLIS(input));
    }
}
