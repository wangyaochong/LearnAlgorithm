package LeetCode.LeetCodeSolution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class S_97_InterleavingString_RECUR {
    @Test
    public void test(){
        System.out.println(isInterleave("abc", "bcd", "abbcdc"));
    }
    Map<String,Boolean> cache=new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        return isMatchTwo(0,0,0,s1,s2,s3);
    }
    private boolean isMatchTwo(int index1,int index2,int index3,String s1,String s2,String s3 ){
        if(s1.length()-index1+s2.length()-index2!=s3.length()-index3){
            return false;
        }
        return isMatchOne(1,index1,index2,index3,s1,s2,s3)||isMatchOne(2,index1,index2,index3,s1,s2,s3);
    }
    private boolean isMatchOne(int compareType,int index1,int index2,int index3,String s1,String s2,String s3){
        if( index3==s3.length()){
            if(index1==s1.length()&&index2==s2.length()){
                return true;
            }else{
                return false;
            }
        }
        if(compareType==1){
            if(index1==s1.length()){
                return false;
            }
            if(s1.charAt(index1)!=s3.charAt(index3)){
                return false;
            }
            index1++;
            index3++;
        }else {
            if(index2==s2.length()){
                return false;
            }
            if(s2.charAt(index2)!=s3.charAt(index3)){
                return false;
            }
            index2++;
            index3++;
        }
        String key=s1.substring(index1,s1.length())+","+s2.substring(index2,s2.length())+","+s3.substring(index3,s3.length());
        Boolean result = cache.get(key);
        if(result!=null){
            return result;
        }else{
            boolean matchTwo = isMatchTwo(index1, index2, index3, s1, s2, s3);
            cache.put(key,matchTwo);
            return matchTwo;
        }
    }

}
