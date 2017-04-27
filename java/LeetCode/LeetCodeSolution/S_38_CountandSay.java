package LeetCode.LeetCodeSolution;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/27】 at 【9:37】.
 */
public class S_38_CountandSay {
    public String countAndSay2(int n){
        StringBuilder init=new StringBuilder("1");
        StringBuilder result;
        for(int i=1;i<n;i++){
            result=new StringBuilder();
            int currentCount=1;
            int len=init.length();
            char last=init.charAt(0);
            for(int j=1;j<len;j++){
               if(init.charAt(j)==last){//如果相等则数量加1
                   currentCount++;
               }else{
                   result.append(currentCount);
                   result.append(init.charAt(j-1));
                   last=init.charAt(j);
                   currentCount=1;
               }
            }
            result.append(currentCount);
            result.append(init.charAt(len-1));
            init=result;
        }
        return init.toString();
    }
    public String countAndSay(int n) {
        String init="1";
        for(int i=1;i<n;i++){
            String result="";
            int currentCount=0;
            int loc=0;
            while(loc<init.length()){
                currentCount=1;
                loc++;
                while(loc<init.length()&&init.charAt(loc)==init.charAt(loc-1)){
                    currentCount++;
                    loc++;
                }
                result+=currentCount;
                result+=init.charAt(loc-1);
            }
            init=result;
        }
        return init;
    }

    public String read(String input,int currentLoc,int currentCount){
        if(currentLoc==input.length())return ""+currentCount+"";
        if(currentLoc==0) return ""+input.charAt(currentLoc)+read(input,currentLoc+1,1);
        if(currentLoc<input.length()&&currentCount-1>=0&& input.charAt(currentLoc)==input.charAt(currentLoc-1)){
            return read(input,currentLoc+1,currentCount+1);//如果相同，就继续往后走
        }else{
            //如果不相同，那么就要返回一个计算的数量，同时开始一个新的字母
                return currentCount+""+input.charAt(currentLoc)+read(input,currentLoc+1,1);
        }
    }
    @Test
    public void testRead(){
        System.out.println(countAndSay(6));
        System.out.println(countAndSay2(6));
//        System.out.println(read("11122211",0,0));
    }
}
