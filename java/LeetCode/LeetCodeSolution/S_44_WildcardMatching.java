package LeetCode.LeetCodeSolution;

import org.junit.Test;

public class S_44_WildcardMatching {
    @Test
    public void test(){
        System.out.println(isMatch2("adceb",
                "*a*b"));
    }
    public boolean isMatch(String s, String p) {
        int sIndex=0;
        int pIndex=0;
        int matchIndex=0;
        int startIndex=-1;
        while(sIndex<s.length()){
            if(pIndex<p.length()&& (p.charAt(pIndex)==s.charAt(sIndex)||p.charAt(pIndex)=='?')){
                sIndex++;
                pIndex++;
            }else if(pIndex<p.length()&&p.charAt(pIndex)=='*'){
                matchIndex=sIndex;
                startIndex=pIndex;
                pIndex++;
            }else if(startIndex!=-1){//如果有星
                pIndex=startIndex+1;
                matchIndex++;
                sIndex=matchIndex;//从这个位置开始匹配
            }else{
                return false;
            }
        }
        while(pIndex<p.length()&&p.charAt(pIndex)=='*'){
            pIndex++;
        }
        return pIndex==p.length();
    }
    public boolean isMatch2(String str,String pattern){
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
